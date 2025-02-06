# Etapa 1: Construcción del proyecto con Maven
FROM maven:3.9-eclipse-temurin-21 AS build

# Establecer el directorio de trabajo dentro del contenedor
WORKDIR /app

# Copiar el archivo pom.xml
COPY pom.xml .

# Descargar las dependencias (sin compilar el código aún)
RUN mvn dependency:go-offline

# Copiar el código fuente de la aplicación
COPY src ./src

# Compilar y empaquetar la aplicación
RUN mvn clean package -DskipTests

# Etapa 2: Creación de la imagen final
FROM eclipse-temurin:21-jre

# Establecer el directorio de trabajo
WORKDIR /app

# Copiar el JAR generado desde la etapa de construcción
COPY --from=build /app/target/*.jar app.jar

# Definir el comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]

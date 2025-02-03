# 🏥 **Patient Management Domain**

## 📖 Description
The **Patient Management** domain is responsible for managing all patient-related information within the hospital system. Each CRUD action is designed as an independent microservice to ensure **modularity, scalability, and maintainability**.

---

## 🔹 Microservice

### ✅ **1. Create Patient**
- **📌 Description:** Registers a new patient in the system.
- **🔹 Method:** `POST`
- **🔗 Dependencies:** Encryption microservice 🔐
- **📥 Inputs:** Patient data (*name, date of birth, gender, address, phone number, username, and password*)
- **📤 Outputs:** Creation confirmation ✅

---

## 🛠️ **Technologies Used**
- **⚙️ Backend:** Java, Spring Boot 💻
- **🗄️ Database:** PostgreSQL 🐘

---

## 🔗 **Integrations**
- **🩺 Medical Care Domain:** Patient data is used for scheduling medical appointments.
- **🩹 Clinical History Domain:** Patient data is used for recording their clinical history.


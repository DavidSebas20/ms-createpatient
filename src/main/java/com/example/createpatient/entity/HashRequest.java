package com.example.createpatient.entity;

public class HashRequest {
    private String password;

    // Constructor
    public HashRequest(String password) {
        this.password = password;
    }

    // Getter
    public String getPassword() {
        return password;
    }

    // Setter
    public void setPassword(String password) {
        this.password = password;
    }

    // toString
    @Override
    public String toString() {
        return "HashRequest{" +
                "password='" + password + '\'' +
                '}';
    }

    // equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HashRequest that = (HashRequest) o;
        return password != null ? password.equals(that.password) : that.password == null;
    }

    // hashCode
    @Override
    public int hashCode() {
        return password != null ? password.hashCode() : 0;
    }
}

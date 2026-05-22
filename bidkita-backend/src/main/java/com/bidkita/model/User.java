package com.bidkita.model;

import com.bidkita.model.enums.UserRole;
import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "users")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class User {

    @Id
    protected String userId;

    protected String username;

    protected String email;

    protected String password;

    protected String phoneNumber;

    public User() {
        this.userId = UUID.randomUUID().toString();
    }

    public abstract UserRole getRole();

    public String getUserId() { return userId; }
    public String getUsername() { return username; }
    public String getEmail() { return email; }
    public String getPassword() { return password; }
    public String getPhoneNumber() { return phoneNumber; }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        if (email == null || !email.matches("^[^@\\s]+@[^@\\s]+\\.[^@\\s]+$")) {
            throw new IllegalArgumentException("Email tidak valid");
        }
        this.email = email;
    }

    public void setPhoneNumber(String phoneNumber) {
        if (phoneNumber == null || !phoneNumber.matches("[+]?[0-9]{9,15}")) {
            throw new IllegalArgumentException("Nomor telepon tidak valid");
        }
        this.phoneNumber = phoneNumber;
    }
}

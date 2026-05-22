package com.bidkita.model;

import com.bidkita.model.enums.UserRole;
import jakarta.persistence.*;

@Entity
@PrimaryKeyJoinColumn(name = "user_id")
public class Admin extends User {

    private String adminCode;

    public Admin() {
        super();
    }

    @Override
    public UserRole getRole() {
        return UserRole.ADMIN;
    }

    public String getAdminCode() { return adminCode; }
    public void setAdminCode(String adminCode) { this.adminCode = adminCode; }
}

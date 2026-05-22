package com.bidkita.model;

import com.bidkita.model.enums.UserRole;
import jakarta.persistence.Entity;

@Entity
public class Buyer extends User {

    @Override
    public UserRole getRole() {
        return UserRole.BUYER;
    }
}

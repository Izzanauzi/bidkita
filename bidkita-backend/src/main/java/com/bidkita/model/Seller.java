package com.bidkita.model;

import com.bidkita.model.enums.UserRole;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@PrimaryKeyJoinColumn(name = "user_id")
public class Seller extends User {

    @OneToMany(mappedBy = "seller")
    @JsonIgnore
    private List<Auction> auctions = new ArrayList<>();

    private double rating = 0.0;

    private int totalSold = 0;

    public Seller() {
        super();
    }

    @Override
    public UserRole getRole() {
        return UserRole.SELLER;
    }

    public List<Auction> getAuctions() { return auctions; }
    public double getRating() { return rating; }
    public int getTotalSold() { return totalSold; }

    public void setRating(double rating) { this.rating = rating; }
    public void setTotalSold(int totalSold) { this.totalSold = totalSold; }
    public void incrementTotalSold() { this.totalSold++; }
}

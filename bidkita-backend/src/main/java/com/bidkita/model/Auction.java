package com.bidkita.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "auctions")
public class Auction implements Biddable {

    @Id
    private String auctionId;

    public Auction() {
        this.auctionId = UUID.randomUUID().toString();
    }

    @Override
    public boolean placeBid(Buyer bidder, double amount) {
        return false;
    }

    @Override
    public double getCurrentPrice() {
        return 0;
    }

    @Override
    public Buyer getHighestBidder() {
        return null;
    }

    @Override
    public List<Bid> getBidHistory() {
        return new ArrayList<>();
    }

    public String getAuctionId() { return auctionId; }
}

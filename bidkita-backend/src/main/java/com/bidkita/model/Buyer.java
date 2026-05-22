package com.bidkita.model;

import com.bidkita.model.enums.UserRole;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@PrimaryKeyJoinColumn(name = "user_id")
public class Buyer extends User {

    @OneToOne(mappedBy = "owner", cascade = CascadeType.ALL)
    private Wallet wallet;

    @OneToMany(mappedBy = "bidder")
    @JsonIgnore
    private List<Bid> bidHistory = new ArrayList<>();

    @ManyToMany
    @JoinTable(
        name = "buyer_watchlist",
        joinColumns = @JoinColumn(name = "buyer_id"),
        inverseJoinColumns = @JoinColumn(name = "auction_id")
    )
    @JsonIgnore
    private List<Auction> watchlist = new ArrayList<>();

    public Buyer() {
        super();
        this.wallet = new Wallet();
        this.wallet.setOwner(this);
    }

    @Override
    public UserRole getRole() {
        return UserRole.BUYER;
    }

    public boolean placeBid(Biddable auction, double amount) {
        return auction.placeBid(this, amount);
    }

    public Wallet getWallet() { return wallet; }
    public List<Bid> getBidHistory() { return bidHistory; }
    public List<Auction> getWatchlist() { return watchlist; }

    public void addToBidHistory(Bid bid) {
        bidHistory.add(bid);
    }

    public void addToWatchlist(Auction auction) {
        watchlist.add(auction);
    }
}

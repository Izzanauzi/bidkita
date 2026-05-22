package com.bidkita.model;

import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "wallets")
public class Wallet {

    @Id
    private String walletId;

    @OneToOne
    @JoinColumn(name = "buyer_id")
    private Buyer owner;

    private double balance = 0.0;

    public Wallet() {
        this.walletId = UUID.randomUUID().toString();
    }

    public void setOwner(Buyer owner) {
        this.owner = owner;
    }

    public Buyer getOwner() { return owner; }
    public String getWalletId() { return walletId; }
    public double getBalance() { return balance; }

    public void deposit(double amount) {
        this.balance += amount;
    }

    public void depositRefund(double amount) {
        this.balance += amount;
    }

    public boolean withdraw(double amount) {
        if (this.balance < amount) return false;
        this.balance -= amount;
        return true;
    }
}

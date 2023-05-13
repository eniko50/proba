package com.luxa.test.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class AuctionItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private int minimumBidPrice;
    private int buyoutPrice;
    private boolean sold;

    @OneToMany(mappedBy = "item")
    private Set<Bid> bids = new HashSet<>();

    public AuctionItem() {
    }

    public AuctionItem(String name, int minimumBidPrice, int buyoutPrice, Set<Bid> bids) {
        this.name = name;
        this.minimumBidPrice = minimumBidPrice;
        this.buyoutPrice = buyoutPrice;
        this.bids = bids;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMinimumBidPrice() {
        return minimumBidPrice;
    }

    public void setMinimumBidPrice(int minimumBidPrice) {
        this.minimumBidPrice = minimumBidPrice;
    }

    public int getBuyoutPrice() {
        return buyoutPrice;
    }

    public void setBuyoutPrice(int buyoutPrice) {
        this.buyoutPrice = buyoutPrice;
    }

    public boolean isSold() {
        return sold;
    }

    public void setSold(boolean sold) {
        this.sold = sold;
    }

    public Set<Bid> getBids() {
        return bids;
    }

    public void setBids(Set<Bid> bids) {
        this.bids = bids;
    }
}

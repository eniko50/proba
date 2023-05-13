package com.luxa.test.web.dto;

import com.luxa.test.model.AuctionItem;

public class AuctionItemDTO {
    private long id;
    private String name;
    private int minimumBidPrice;
    private int buyoutPrice;
    private boolean sold;

    public AuctionItemDTO() {
    }

    public AuctionItemDTO(AuctionItem item) {
        this.id = item.getId();
        this.name = item.getName();
        this.minimumBidPrice = item.getMinimumBidPrice();
        this.buyoutPrice = item.getBuyoutPrice();
        this.sold = item.isSold();
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
}

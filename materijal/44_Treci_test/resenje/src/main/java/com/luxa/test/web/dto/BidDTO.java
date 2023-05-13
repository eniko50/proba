package com.luxa.test.web.dto;

import com.luxa.test.model.Bid;

public class BidDTO {

    private long id;
    private int price;
    private String firstName;
    private String lastName;
    private String jmbg;
    private AuctionItemDTO item;

    public BidDTO() {
    }

    public BidDTO(int price, String firstName, String lastName, String jmbg) {
        this.price = price;
        this.firstName = firstName;
        this.lastName = lastName;
        this.jmbg = jmbg;
    }

    public BidDTO(Bid bid) {
        this.id = bid.getId();
        this.price = bid.getPrice();
        this.firstName = bid.getFirstName();
        this.lastName = bid.getLastName();
        this.jmbg = bid.getJmbg();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getJmbg() {
        return jmbg;
    }

    public void setJmbg(String jmbg) {
        this.jmbg = jmbg;
    }

    public AuctionItemDTO getItem() {
        return item;
    }

    public void setItem(AuctionItemDTO item) {
        this.item = item;
    }
}

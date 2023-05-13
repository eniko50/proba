package com.luxa.test.model;

import javax.persistence.*;

@Entity
public class Bid {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private int price;
    private String firstName;
    private String lastName;
    private String jmbg;

    @ManyToOne
    private AuctionItem item;

    public Bid() {
    }

    public Bid(int price, String firstName, String lastName, String jmbg, AuctionItem item) {
        this.price = price;
        this.firstName = firstName;
        this.lastName = lastName;
        this.jmbg = jmbg;
        this.item = item;
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

    public AuctionItem getItem() {
        return item;
    }

    public void setItem(AuctionItem item) {
        this.item = item;
    }
}

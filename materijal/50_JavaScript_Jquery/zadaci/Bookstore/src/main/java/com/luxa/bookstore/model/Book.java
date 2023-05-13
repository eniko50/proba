package com.luxa.bookstore.model;

public class Book {
    private long id;
    private String name;
    private String author;
    private String publicationDate;
    private int cost;

    public Book() {
    }

    public Book(long id, String name, String author, String publicationDate, int cost) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.publicationDate = publicationDate;
        this.cost = cost;
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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(String publicationDate) {
        this.publicationDate = publicationDate;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Book{" + "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", publicationDate='" + publicationDate + '\'' +
                ", cost=" + cost +
                '}';
    }


}

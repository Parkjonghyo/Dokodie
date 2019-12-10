package com.cookandroid.dokodie;

public class BookItem {
    private int id;
    private String title;
    private String writer;
    private String publisher;
    private String date;
    private Integer price;

    public void setId(int id) {
        this.id = id;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }
}

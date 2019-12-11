package com.cookandroid.dokodie;

public class RecyclerItem {
    private int bookimg;
    private String booktitle;
    private String bookwriter;

    public RecyclerItem(int img, String title, String writer){
        this.bookimg=img;
        this.booktitle=title;
        this.bookwriter=writer;
    }

    public int getBookimg(){
        return bookimg;
    }

    public String getBooktitle(){
        return booktitle;
    }

    public String getBookwriter(){
        return bookwriter;
    }

    public void setBookimg(int bookimg){
        this.bookimg=bookimg;
    }

    public void setBooktitle(String booktitle){
        this.booktitle=booktitle;
    }

    public void setBookwriter(String bookwriter){
        this.bookwriter=bookwriter;
    }
}

package com.cookandroid.dokodie;

import android.graphics.drawable.Drawable;

public class MyItem {

    private String num;
    private Drawable img;
    private String title;
    private String writer;

    public String getNum(){ return num;}

    public void setNum(String num){ this.num=num;}

    public Drawable getImg() {
        return img;
    }

    public void setImg(Drawable img) {
        this.img = img;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }
}

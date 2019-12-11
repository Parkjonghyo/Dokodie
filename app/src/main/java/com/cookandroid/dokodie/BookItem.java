package com.cookandroid.dokodie;

import android.os.Parcel;
import android.os.Parcelable;

public class BookItem implements Parcelable {
    private int id;
    private String title;
    private String writer;
    private String publisher;
    private String date;
    private Integer price;
    private int bookImgNumber;

    public BookItem(){}

    protected BookItem(Parcel in) {
        id = in.readInt();
        title = in.readString();
        writer = in.readString();
        publisher = in.readString();
        date = in.readString();
        if (in.readByte() == 0) {
            price = null;
        } else {
            price = in.readInt();
        }
        bookImgNumber = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(title);
        dest.writeString(writer);
        dest.writeString(publisher);
        dest.writeString(date);
        if (price == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(price);
        }
        dest.writeInt(bookImgNumber);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<BookItem> CREATOR = new Creator<BookItem>() {
        @Override
        public BookItem createFromParcel(Parcel in) {
            return new BookItem(in);
        }

        @Override
        public BookItem[] newArray(int size) {
            return new BookItem[size];
        }
    };

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

    public void setBookImgNumber(int bookImgNumber) {
        this.bookImgNumber = bookImgNumber;
    }

    public int getId() {
        return id;
    }

    public String getDate() {
        return date;
    }

    public Integer getPrice() {
        return price;
    }

    public String getPublisher() {
        return publisher;
    }

    public String getTitle() {
        return title;
    }

    public String getWriter() {
        return writer;
    }

    public int getBookImgNumber() {
        return bookImgNumber;
    }
}

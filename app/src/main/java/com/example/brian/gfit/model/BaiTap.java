package com.example.brian.gfit.model;

public class BaiTap {
    private String tenbaitap;
    private int image;

    public BaiTap(String tenbaitap, int image) {
        this.tenbaitap = tenbaitap;
        this.image = image;
    }

    public String getTenbaitap() {
        return tenbaitap;
    }

    public void setTenbaitap(String tenbaitap) {
        this.tenbaitap = tenbaitap;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}

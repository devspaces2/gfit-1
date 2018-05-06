package com.example.brian.gfit.model;

public class GiaoAn {
    private String name;
    private String image;
    private int count;

    public GiaoAn(String name, String image, int count) {
        this.name = name;
        this.image = image;
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}

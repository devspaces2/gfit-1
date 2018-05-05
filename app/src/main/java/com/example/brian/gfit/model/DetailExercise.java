package com.example.brian.gfit.model;

import android.support.annotation.NonNull;

public class DetailExercise {
    @NonNull
    private String title;
    @NonNull
    private String detail;
    @NonNull
    private String image;

    public DetailExercise(@NonNull String title, @NonNull String detail, @NonNull String image) {
        this.title = title;
        this.detail = detail;
        this.image = image;
    }

    @NonNull
    public String getTitle() {
        return title;
    }

    public void setTitle(@NonNull String title) {
        this.title = title;
    }

    @NonNull
    public String getDetail() {
        return detail;
    }

    public void setDetail(@NonNull String detail) {
        this.detail = detail;
    }

    @NonNull
    public String getImage() {
        return image;
    }

    public void setImage(@NonNull String image) {
        this.image = image;
    }
}

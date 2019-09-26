package com.ualr.recyclerview.model;

import android.graphics.drawable.Drawable;

/**
 * Created by irconde on 2019-09-25.
 */
public class People {
    private int image;
    private String name;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public Drawable getImageDrw() {
        return imageDrw;
    }

    public void setImageDrw(Drawable imageDrw) {
        this.imageDrw = imageDrw;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    private Drawable imageDrw;
    private String email;

    public People() {
    }

    public People(String name) {
        this.name = name;
    }
}

package com.ualr.recyclerview.model;

import android.graphics.drawable.Drawable;

/**
 * Created by irconde on 2019-09-25.
 */
public class People {
    public int image;
    public Drawable imageDrw;
    public String name;
    public String email;
    public boolean section = false;

    public People() {
    }

    public People(String name, boolean section) {
        this.name = name;
        this.section = section;
    }
}

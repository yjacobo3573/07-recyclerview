package com.ualr.recyclerview.model;

/**
 * Created by irconde on 2019-09-25.
 */
public abstract class Item {
    protected boolean section = true;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isSection() {
        return section;
    }

    protected String name;

}

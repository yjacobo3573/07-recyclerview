package com.ualr.recyclerview.model;

/**
 * Created by irconde on 2019-09-25.
 */

// TODO 01: We have to define a base class that represents any item in the list: both section headers and people rows
public abstract class Item {
    protected boolean section = false;
    public boolean isSection() {
        return section;
    }
}

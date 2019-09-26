package com.ualr.recyclerview.model;

/**
 * Created by irconde on 2019-09-26.
 */

// TODO 03: Create a class that extends from Item class
public class SectionHeader extends Item {
    private String label;

    public SectionHeader(String label) {
        this.label = label;
        this.section = true;
    }

    public SectionHeader() {
        this.section = true;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}

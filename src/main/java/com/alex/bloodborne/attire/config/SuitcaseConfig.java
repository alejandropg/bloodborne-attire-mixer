package com.alex.bloodborne.attire.config;

import com.alex.bloodborne.attire.Attire.Attribute;

import java.util.ArrayList;
import java.util.List;

public class SuitcaseConfig {

    private int size;
    private List<Attribute> attributes = new ArrayList<>();
    private boolean print;

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public List<Attribute> getAttributes() {
        return attributes;
    }

    public boolean isPrint() {
        return print;
    }

    public void setPrint(boolean print) {
        this.print = print;
    }

}

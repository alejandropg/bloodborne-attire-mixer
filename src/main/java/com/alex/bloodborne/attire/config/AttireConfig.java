package com.alex.bloodborne.attire.config;

import com.alex.bloodborne.attire.Attire;
import com.alex.bloodborne.attire.Attire.Type;

import java.util.ArrayList;
import java.util.List;

public class AttireConfig {

    private String name;
    private Attire.Type type;
    private final List<Integer> attributes = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public List<Integer> getAttributes() {
        return attributes;
    }

}

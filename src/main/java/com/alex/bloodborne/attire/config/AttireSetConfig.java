package com.alex.bloodborne.attire.config;

import java.util.ArrayList;
import java.util.List;

public class AttireSetConfig {

    private String name;
    private List<AttireConfig> attires = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<AttireConfig> getAttires() {
        return attires;
    }
}

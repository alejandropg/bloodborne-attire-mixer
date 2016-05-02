package com.alex.bloodborne.attire;

import java.io.Serializable;
import java.util.Comparator;

public class MaximizeAttributes implements Comparator<AttireSet>, Serializable {

    private final Attributes attributes;

    public MaximizeAttributes(Attributes attributes) {
        this.attributes = attributes;
    }

    @Override
    public int compare(AttireSet o1, AttireSet o2) {
        final int sum1 = o1.sum(attributes);
        final int sum2 = o2.sum(attributes);

        return sum1 - sum2;
    }
}

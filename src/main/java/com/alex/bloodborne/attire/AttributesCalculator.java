package com.alex.bloodborne.attire;

import com.alex.bloodborne.attire.Attire.Attribute;

public class AttributesCalculator {

    private final int[] attributeSums = new int[Attire.Attribute.values().length];
    private final AttireSet attireSet;
    private int total = 0;

    public AttributesCalculator(AttireSet attireSet, Attributes attributes) {
        this.attireSet = attireSet;
        sum(attributes);
    }

    private void sum(Attributes attributes) {
        for (Attribute attribute : attributes) {
            total += sum(attribute);
        }
    }

    private int sum(Attribute attribute) {
        int sum = 0;
        for (Attire attire : attireSet) {
            sum += attire.get(attribute);
        }

        attributeSums[attribute.ordinal()] = sum;
        return sum;
    }

    public int getSum(Attribute attribute) {
        return attributeSums[attribute.ordinal()];
    }

    public int getTotal() {
        return total;
    }
}

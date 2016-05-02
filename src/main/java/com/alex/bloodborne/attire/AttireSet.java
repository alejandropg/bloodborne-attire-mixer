package com.alex.bloodborne.attire;

import org.springframework.util.Assert;

import java.util.Arrays;
import java.util.Iterator;

import static com.alex.bloodborne.attire.Attire.Type.*;
import static java.util.Arrays.asList;

public class AttireSet implements Iterable<Attire> {

    private final String name;
    private final Attire[] attires = new Attire[Attire.Type.values().length];


    public AttireSet(String name, Attire head, Attire chest, Attire hands, Attire legs) {
        Assert.notNull(name);
        Assert.isTrue(head.getType() == HEAD);
        Assert.isTrue(chest.getType() == CHEST);
        Assert.isTrue(hands.getType() == HANDS);
        Assert.isTrue(legs.getType() == LEGS);

        this.name = name;
        attires[HEAD.ordinal()] = head;
        attires[CHEST.ordinal()] = chest;
        attires[HANDS.ordinal()] = hands;
        attires[LEGS.ordinal()] = legs;

    }

    public String getName() {
        return name;
    }

    @Override
    public Iterator<Attire> iterator() {
        return asList(attires).iterator();
    }

    public int sum(Attributes attributes) {
        return new AttributesCalculator(this, attributes).getTotal();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof AttireSet)) return false;

        final AttireSet attireSet = (AttireSet) obj;

        return name.equals(attireSet.name)
                && Arrays.equals(attires, attireSet.attires);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + Arrays.hashCode(attires);
        return result;
    }

}

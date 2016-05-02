package com.alex.bloodborne.attire;

import org.springframework.util.Assert;

import java.util.Arrays;

import static com.alex.bloodborne.attire.Attire.Attribute.*;

public class Attire {

    public enum Type {
        HEAD,
        CHEST,
        HANDS,
        LEGS
    }

    public enum Attribute {
        PHYSICAL,
        BLUNT,
        THRUST,
        BLOOD,
        ARCANE,
        FIRE,
        BOLT,
        SLOW_POISON,
        RAPID_POISON,
        FRENZY,
        BEASTHOOD
    }

    private final String name;
    private final Type type;

    private final int[] attributes = new int[Attribute.values().length];

    public Attire(String name, Type type, int physical,
                  int blunt,
                  int thrust,
                  int blood,
                  int arcane,
                  int fire,
                  int bolt,
                  int slowPoison,
                  int rapidPoison,
                  int frenzy,
                  int beasthood) {

        Assert.notNull(name);
        Assert.notNull(type);

        this.name = name;
        this.type = type;
        attributes[PHYSICAL.ordinal()] = physical;
        attributes[BLUNT.ordinal()] = blunt;
        attributes[THRUST.ordinal()] = thrust;
        attributes[BLOOD.ordinal()] = blood;
        attributes[ARCANE.ordinal()] = arcane;
        attributes[FIRE.ordinal()] = fire;
        attributes[BOLT.ordinal()] = bolt;
        attributes[SLOW_POISON.ordinal()] = slowPoison;
        attributes[RAPID_POISON.ordinal()] = rapidPoison;
        attributes[FRENZY.ordinal()] = frenzy;
        attributes[BEASTHOOD.ordinal()] = beasthood;
    }

    public String getName() {
        return name;
    }

    public Type getType() {
        return type;
    }

    public int get(Attribute attribute) {
        return attributes[attribute.ordinal()];
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Attire)) return false;

        final Attire attire = (Attire) obj;

        return type == attire.type
                && Arrays.equals(attributes, attire.attributes);

    }

    @Override
    public int hashCode() {
        int result = type.hashCode();
        result = 31 * result + Arrays.hashCode(attributes);
        return result;
    }

}

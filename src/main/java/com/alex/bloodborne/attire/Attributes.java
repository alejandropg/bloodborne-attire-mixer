package com.alex.bloodborne.attire;

import java.io.Serializable;
import java.util.Collection;
import java.util.EnumSet;
import java.util.Iterator;

import static com.alex.bloodborne.attire.Attire.Attribute;
import static java.util.Arrays.asList;

public class Attributes implements Iterable<Attribute>, Serializable {

    public static final Attributes ALL = new Attributes(Attribute.values());

    private final Collection<Attribute> attributes;

    public Attributes(Attribute... attributes) {
        this.attributes = EnumSet.copyOf(asList(attributes));
    }

    @Override
    public Iterator<Attribute> iterator() {
        return attributes.iterator();
    }

}

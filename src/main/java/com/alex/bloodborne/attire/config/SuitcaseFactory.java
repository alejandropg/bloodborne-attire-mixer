package com.alex.bloodborne.attire.config;

import com.alex.bloodborne.attire.Attire.Attribute;
import com.alex.bloodborne.attire.Attributes;
import com.alex.bloodborne.attire.MaximizeAttributes;
import com.alex.bloodborne.attire.Suitcase;

public class SuitcaseFactory {

    public Suitcase create(SuitcaseConfig suitcaseConfig) {
        final int size = suitcaseConfig.getSize();

        final int attributesSize = suitcaseConfig.getAttributes().size();
        final Attributes attributes = attributesSize == 0
                ? Attributes.ALL
                : new Attributes(suitcaseConfig.getAttributes().toArray(new Attribute[attributesSize]));

        return new Suitcase(size, new MaximizeAttributes(attributes));
    }

}

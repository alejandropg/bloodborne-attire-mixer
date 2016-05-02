package com.alex.bloodborne.attire.config;

import com.alex.bloodborne.attire.Attire;
import com.alex.bloodborne.attire.Attire.Type;
import com.alex.bloodborne.attire.AttireSet;
import com.alex.bloodborne.attire.Closet;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

import static com.alex.bloodborne.attire.Attire.Attribute.*;
import static com.alex.bloodborne.attire.Attire.Type.*;

public class ClosetFactory {

    public Closet create(Iterable<AttireSetConfig> attireSetConfigs) {
        final Closet closet = new Closet();

        for (AttireSetConfig attireSetConfig : attireSetConfigs) {
            closet.add(createAttireSet(attireSetConfig));
        }

        return closet;
    }

    private AttireSet createAttireSet(AttireSetConfig attireSetConfig) {
        final Map<Type, Attire> attires = new EnumMap<>(Type.class);

        for (AttireConfig attireConfig : attireSetConfig.getAttires()) {
            final Attire attire = createAttire(attireConfig);
            attires.put(attire.getType(), attire);
        }

        return new AttireSet(
                attireSetConfig.getName(),
                attires.get(HEAD),
                attires.get(CHEST),
                attires.get(HANDS),
                attires.get(LEGS)
        );
    }

    private Attire createAttire(AttireConfig attireConfig) {
        final List<Integer> attributes = attireConfig.getAttributes();
        return new Attire(
                attireConfig.getName(),
                attireConfig.getType(),
                attributes.get(PHYSICAL.ordinal()),
                attributes.get(BLUNT.ordinal()),
                attributes.get(THRUST.ordinal()),
                attributes.get(BLOOD.ordinal()),
                attributes.get(ARCANE.ordinal()),
                attributes.get(FIRE.ordinal()),
                attributes.get(BOLT.ordinal()),
                attributes.get(SLOW_POISON.ordinal()),
                attributes.get(RAPID_POISON.ordinal()),
                attributes.get(FRENZY.ordinal()),
                attributes.get(BEASTHOOD.ordinal())
        );
    }

}

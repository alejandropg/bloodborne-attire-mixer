package com.alex.bloodborne.attire;

import com.alex.bloodborne.attire.Attire.Type;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Closet {

    private final AttireSetNamer attireSetNamer = new AttireSetNamer();

    private final Collection<Attire> headAttires = new HashSet<>();
    private final Collection<Attire> chestAttires = new HashSet<>();
    private final Collection<Attire> handsAttires = new HashSet<>();
    private final Collection<Attire> legsAttires = new HashSet<>();
    private final Map<Type, Collection<Attire>> attiresByType = new HashMap<>();

    public Closet() {
        attiresByType.put(Type.LEGS, legsAttires);
        attiresByType.put(Type.HANDS, handsAttires);
        attiresByType.put(Type.CHEST, chestAttires);
        attiresByType.put(Type.HEAD, headAttires);
    }

    public void add(AttireSet attireSet) {
        attireSet.forEach(attire -> attiresByType.get(attire.getType()).add(attire));
    }

    public void packInto(Suitcase suitcase) {
        for (Attire head : headAttires) {
            for (Attire chest : chestAttires) {
                for (Attire hands : handsAttires) {
                    for (Attire legs : legsAttires) {
                        final String name = attireSetNamer.name(head, chest, hands, legs);
                        suitcase.add(new AttireSet(name, head, chest, hands, legs));
                    }
                }
            }
        }
    }

}

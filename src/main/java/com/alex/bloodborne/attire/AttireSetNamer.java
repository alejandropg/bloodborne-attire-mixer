package com.alex.bloodborne.attire;

public class AttireSetNamer {

    private int mixCounter = 0;

    public String name(Attire head, Attire chest, Attire hands, Attire legs) {
        if (head.getName().equals(chest.getName())
                && head.getName().equals(hands.getName())
                && head.getName().equals(legs.getName())) {
            return head.getName() + " Set";
        }

        mixCounter++;

        return "Mix " + mixCounter + " Set";
    }

}

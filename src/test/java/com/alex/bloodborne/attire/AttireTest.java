package com.alex.bloodborne.attire;

import org.junit.Test;

import static com.alex.bloodborne.attire.Attire.Type.*;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class AttireTest {

    private final AttireSet hunterWithCapeSet = new AttireSet("Cazador con capa corta",
            new Attire("Cazador con capa corta", HEAD, 50, 50, 40, 50, 20, 50, 30, 5, 11, 14, 16),
            new Attire("Cazador con capa corta", CHEST, 110, 110, 80, 110, 40, 110, 70, 17, 33, 48, 44),
            new Attire("Cazador con capa corta", HANDS, 50, 50, 50, 50, 40, 60, 50, 9, 17, 27, 25),
            new Attire("Cazador con capa corta", LEGS, 60, 60, 50, 60, 50, 60, 50, 10, 19, 30, 27)
    );

    private final AttireSet yharnamHunter = new AttireSet("Cazador de Yharnam",
            new Attire("Cazador de Yharnam", HEAD, 50, 40, 40, 40, 50, 50, 50, 16, 13, 14, 16),
            new Attire("Cazador de Yharnam", CHEST, 110, 80, 90, 90, 80, 100, 90, 48, 40, 41, 48),
            new Attire("Cazador de Yharnam", HANDS, 40, 50, 60, 40, 50, 60, 50, 25, 22, 22, 25),
            new Attire("Cazador de Yharnam", LEGS, 50, 60, 60, 50, 50, 60, 60, 27, 23, 24, 27)
    );

    private final Closet closet = new Closet();

    public AttireTest() {
        closet.add(hunterWithCapeSet);
        closet.add(yharnamHunter);
    }

    @Test
    public void pack_into_a_suitcase_large_enough() {
        final Suitcase suitcase = new Suitcase(20, (o1, o2) -> -1);

        closet.packInto(suitcase);

        assertThat(suitcase.size(), is(16));
    }

    @Test
    public void pack_into_a_small_suitcase() {
        final Suitcase suitcase = new Suitcase(5, (o1, o2) -> -1);

        closet.packInto(suitcase);

        assertThat(suitcase.size(), is(5));
    }

    @Test
    public void pack_into_a_filtered_suitcase() {
        final Suitcase suitcase = new Suitcase(10, new MaximizeAttributes(Attributes.ALL));

        closet.packInto(suitcase);

        assertThat(suitcase.size(), is(10));
    }

}

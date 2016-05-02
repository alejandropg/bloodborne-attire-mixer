package com.alex.bloodborne.attire.delivery.console;

import com.alex.bloodborne.attire.*;
import com.alex.bloodborne.attire.Attire.Attribute;
import com.alex.delivery.console.Table;

import static com.alex.delivery.console.Alignment.RIGHT;
import static com.alex.util.StringUtils.LS;

public class SuitcaseView {

    private final StringBuilder stringBuilder = new StringBuilder(8 * 1024);
    private final Table table = new Table(stringBuilder, 4, 8, 20, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 10);

    public String print(Suitcase suitcase) {
        suitcase.forEach(this::print);
        return stringBuilder.toString();
    }

    private void print(AttireSet attireSet) {
        stringBuilder.append(LS).append(attireSet.getName());
        table.nextRow();

        for (Attire attire : attireSet) {
            print(attire);
            table.nextRow();
        }

        printFooter(attireSet);
    }

    private void print(Attire attire) {
        table.addField(attire.getType());
        table.addField(attire.getName());

        for (Attribute attribute : Attribute.values()) {
            table.addField(attire.get(attribute), RIGHT);
        }
    }

    private void printFooter(AttireSet attireSet) {
        final AttributesCalculator calculator = new AttributesCalculator(attireSet, Attributes.ALL);

        table.addField("");
        table.addField("Total =", RIGHT);

        for (Attribute attribute : Attribute.values()) {
            table.addField(calculator.getSum(attribute), RIGHT);
        }
        table.addField(" = " + calculator.getTotal());
    }
}

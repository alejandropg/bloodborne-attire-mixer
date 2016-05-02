package com.alex.delivery.console;

import com.alex.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

import static com.alex.delivery.console.Alignment.LEFT;

public class Table {

    private final StringBuilder stringBuilder;
    private final List<Column> columns;

    private String indentation = "";
    private int columnIndex = 0;

    public Table(StringBuilder stringBuilder, int indentation, int... columnSizes) {
        this.stringBuilder = stringBuilder;

        if (indentation > 0) {
            final StringBuilder indentationBuilder = new StringBuilder(indentation);
            StringUtils.addSpaces(indentationBuilder, "", indentation);
            this.indentation = indentationBuilder.toString();
        }

        columns = new ArrayList<>(columnSizes.length);
        for (int size : columnSizes) {
            columns.add(new Column(stringBuilder, size));
        }
    }

    public void addField(Object field) {
        addField(field, LEFT);
    }

    public void addField(Object field, Alignment alignment) {
        final Column column = columns.get(columnIndex);
        column.adjust(field.toString(), alignment);
        // stringBuilder.append('|'); Show column border

        columnIndex++;
        if (columnIndex == columns.size()) {
            nextRow();
        }
    }

    public void nextRow() {
        stringBuilder.append(StringUtils.LS).append(indentation);
        columnIndex = 0;
    }

}

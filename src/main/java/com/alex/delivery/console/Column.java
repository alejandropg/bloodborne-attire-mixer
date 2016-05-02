package com.alex.delivery.console;

import com.alex.util.StringUtils;

import static com.alex.delivery.console.Alignment.LEFT;
import static com.alex.delivery.console.Alignment.RIGHT;

class Column {

    private final StringBuilder stringBuilder;
    private final int size;

    Column(StringBuilder stringBuilder, int size) {
        this.stringBuilder = stringBuilder;
        this.size = size;
    }

    void adjust(String field, Alignment alignment) {
        if (field.length() > size) {
            stringBuilder.append(field, 0, size - 1);
            return;
        }

        if (alignment == RIGHT) {
            StringUtils.addSpaces(stringBuilder, "", size - field.length());
        }
        stringBuilder.append(field);
        if (alignment == LEFT) {
            StringUtils.addSpaces(stringBuilder, "", size - field.length());
        }
    }
}

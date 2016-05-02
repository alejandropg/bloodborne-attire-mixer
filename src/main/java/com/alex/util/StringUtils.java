package com.alex.util;

public final class StringUtils {

    public static final String LS = System.lineSeparator();

    public static void addSpaces(StringBuilder stringBuilder, CharSequence charSequence, int justifyStringToLength) {
        final int spacesToAdd = justifyStringToLength - charSequence.length() - 1;
        for (int i = 0; i < spacesToAdd; i++) {
            stringBuilder.append(' ');
        }
    }

    private StringUtils() {
        throw new UnsupportedOperationException("Utility class. Cannot be instantiated.");
    }
}

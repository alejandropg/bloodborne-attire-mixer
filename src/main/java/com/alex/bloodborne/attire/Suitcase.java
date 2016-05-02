package com.alex.bloodborne.attire;

import java.util.Comparator;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.TreeSet;

public class Suitcase implements Iterable<AttireSet> {

    private final int maxCapacity;
    private final NavigableSet<AttireSet> sets;

    private int totalResults;

    public Suitcase(int maxCapacity, Comparator<AttireSet> comparator) {
        this.maxCapacity = maxCapacity;
        sets = new TreeSet<>(comparator);
    }

    public void add(AttireSet attireSet) {
        totalResults++;
        sets.add(attireSet);
        if (sets.size() > maxCapacity) {
            sets.pollFirst();
        }
    }

    @Override
    public Iterator<AttireSet> iterator() {
        return sets.iterator();
    }

    public int size() {
        return sets.size();
    }

    public int getTotalResults() {
        return totalResults;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

}

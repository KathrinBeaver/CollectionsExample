package ru.mai.filecollectiontest;

import java.util.Iterator;

/**
 * @author Beaver
 */
public class CustomEnumeration implements Iterator {

    /**
     * Массив, в котором хранятся числа
     */
    private int[] values;

    /**
     * Количество уже извлеченных чисел
     */
    private int current = 0;

    public CustomEnumeration(int[] values) {
        this.values = values;
    }

    @Override
    public boolean hasNext() {
        return current < values.length;
    }

    @Override
    public Object next() {
        return new Integer(values[current++]);
    }

    @Override
    public void remove() {
        for (int i = current; i < values.length - 1; i++) {
            values[i] = values[i + 1];
        }
    }
}

package com.kozlowst.concurrency;

import java.util.Date;

/**
 * Created by tomek on 10/1/14.
 */
public class Immutable {
    private final int[] array;
    private final Date date;
    public final String name;

    public Immutable(int[] array, Date date, String name) {
        this.array = new int[array.length];
        arrayCopy(array);
        this.date = new Date();
        this.date.setTime(date.getTime());
        this.name = name;
    }

    private void arrayCopy(int[] array) {
        for (int i = 0; i < array.length; i++) {
            this.array[i] = array[i];
        }
    }

    public int[] getArray() {
        return array;
    }

    public Date getData() {
        return date;
    }

    public String getName() {
        return name;
    }
}

package com.kozlowst.concurrency;

import org.junit.Test;

import java.util.Date;

import static junit.framework.TestCase.assertTrue;

/**
 * Created by tomek on 10/1/14.
 */
public class ImmutableTest {
    @Test
    public void test() {
        int[] array = new int[]{1, 2, 3, 4, 5};
        Date data = new Date(123456789l);

        Immutable immutable = new Immutable(array, data, "tomek");
        array[0]++;
        data.setTime(2222222222l);

        assertTrue(immutable.getArray()[0] == 1);
        assertTrue(immutable.getData().getTime() == 123456789l);
    }
}

package kozlowst;

import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

/**
 * Created by tomek on 9/27/14.
 */
public class SortUtilsTest {
    @Test
    public void testArraySortCheck() {
        Integer[] arrSorted = new Integer[]{1, 2, 3, 5, 7, 9};
        Integer[] arrNotSorted = new Integer[]{2, 1, 3, 4, 5, 8, 9};
        assertTrue(SortUtils.isSorted(arrSorted));
        assertFalse(SortUtils.isSorted(arrNotSorted));
    }

    @Test
    public void testLessThenCheck() {
        assertTrue(SortUtils.less(1, 2));
        assertFalse(SortUtils.less(2, 1));
    }

    @Test
    public void testSwap() {
        Integer[] a = new Integer[]{1, 2, 3};
        SortUtils.swap(a, 0, 2);
        assertTrue(1 == a[2]);
        assertTrue(3 == a[0]);
    }
}

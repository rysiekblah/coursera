package kozlowst;

import org.junit.Test;

import java.util.Arrays;

import static junit.framework.TestCase.assertTrue;

/**
 * Created by tomek on 9/27/14.
 */
public class SelectionSortTest {

    @Test
    public void testSortCheck() {
        Integer[] arr = new Integer[]{1, 3, 2, 5, 3, 6, 4};
        SelectionSort.sort(arr);
        assertTrue(SortUtils.isSorted(arr));
    }

    @Test
    public void testSortReverse() {
        Integer[] arr = new Integer[]{9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        SelectionSort.sort(arr);
        assertTrue(SortUtils.isSorted(arr));
    }

}

package kozlowst;

import org.junit.Test;

/**
 * Created by tomek on 2/15/15.
 */
public class MergeSortTest {
    @Test
    public void test1() {
        Integer[] arr = new Integer[]{1, 3, 2, 5, 3, 6, 4};
        MergeSort.sort(arr);
        for (Integer integer : arr) {
            System.out.println(integer);
        }

    }
}

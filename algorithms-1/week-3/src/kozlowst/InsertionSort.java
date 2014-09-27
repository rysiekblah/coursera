package kozlowst;

import static kozlowst.SortUtils.less;
import static kozlowst.SortUtils.swap;

/**
 * Created by tomek on 9/27/14.
 */
public class InsertionSort {
    public static void sort(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = i; j > 0; j--) {
                if (less(a[j], a[j - 1])) {
                    swap(a, j - 1, j);
                }
            }
        }
    }
}

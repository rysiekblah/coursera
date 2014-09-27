package kozlowst;

import static kozlowst.SortUtils.*;

/**
 * Created by tomek on 9/27/14.
 */
public class SelectionSort {
    public static void sort(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            int index = i;
            for (int j = i; j < a.length; j++) {
                if (less(a[j], a[index])) {
                    index = j;
                }
            }
            swap(a, i, index);
        }
    }
}

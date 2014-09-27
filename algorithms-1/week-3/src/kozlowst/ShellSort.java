package kozlowst;

import static kozlowst.SortUtils.less;
import static kozlowst.SortUtils.swap;

/**
 * Created by tomek on 9/27/14.
 */
public class ShellSort {
    public static void sort(Comparable[] a) {
        int h = 1;
        while (h < a.length / 3) h = 3 * h + 1;

        while (h >= 1) {
            for (int i = h; i < a.length; i++) {
                for (int j = i; j >= h && less(a[j], a[j - h]); j -= h) {
                    swap(a, j, j - h);
                }
            }
            h /= 3;
        }

    }
}

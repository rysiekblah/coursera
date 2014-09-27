package kozlowst;

/**
 * Created by tomek on 9/27/14.
 */
public class SortUtils {
    public static boolean isSorted(Comparable a[]) {

        for (int i = 1; i < a.length; i++) {
            if (!less(a[i - 1], a[i]) && !equal(a[i - 1], a[i])) {
                return false;
            }
        }
        return true;
    }

    public static boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }

    public static boolean equal(Comparable a, Comparable b) {
        return a.compareTo(b) == 0;
    }

    public static void swap(Object[] a, int i, int j) {
        Object o = a[i];
        a[i] = a[j];
        a[j] = o;
    }
}

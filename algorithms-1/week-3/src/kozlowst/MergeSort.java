package kozlowst;

import static kozlowst.SortUtils.*;

/**
 * Created by tomek on 9/26/14.
 */
public class MergeSort {

    public static void sort(Comparable[] a) {
        Comparable[] aux = new Comparable[a.length];
        sort(a, aux, 0, a.length-1);
    }

    private static void sort(Comparable[] a, Comparable[] aux, int lo, int hi) {
        if(lo >= hi) return;
        int mid = lo + (hi - lo)/2;
        System.out.println("lo: " + lo + ", mid: " + mid + ", hi: " + hi);
        sort(a, aux, lo, mid);
        sort(a, aux, mid + 1, hi);
        merge(a, aux, lo, mid, hi);
    }

    private static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi) {
        assert isSorted(a, lo, mid);
        assert isSorted(a, mid + 1, hi);

        // copy all data from a to aux array
        for (int i = lo; i <= hi; i++) {
            aux[i] = a[i];
        }

        int left = lo;
        int right = mid + 1;

        for (int i = lo; i <= hi; i++) {
            if     (left > mid) a[i] = aux[right++];
            else if(right > hi) a[i] = aux[left++];
            else if(less(aux[right], aux[left])) a[i] = aux[right++];
            else a[i] = aux[left++];
        }
        assert isSorted(a, lo, hi);
    }


}

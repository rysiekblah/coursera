package unionfind;

import java.util.Arrays;

/**
 * Created by tomek on 9/8/14.
 */
public class QuickFindUF implements UnionFind {

    private int[] elements;

    public QuickFindUF(int num) {
        elements = new int[num];
        for (int i=0; i<num; i++) {
            elements[i] = i;
        }

    }

    @Override
    public void union(int p, int q) {
        int elp = elements[p];
        int elq = elements[q];
        elements[p] = elements[q];
        for (int i = 0; i < elements.length; i++) {
            if (elements[i] == elp) {
                elements[i] = elq;
            }
        }
        System.out.println("(" + p + "," + q + ")  - " + Arrays.toString(elements));
    }

    @Override
    public boolean connected(int p, int q) {
        return elements[p] == elements[q];
    }

    @Override
    public int find(int p) {
        return 0;
    }

    @Override
    public int count() {
        return 0;
    }

    public int[] getElements() {
        System.out.println(Arrays.toString(elements));
        return elements;
    }
}

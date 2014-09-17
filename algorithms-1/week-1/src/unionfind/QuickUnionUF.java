package unionfind;

import java.util.Arrays;

/**
 * Created by tomek on 9/8/14.
 */
public class QuickUnionUF implements UnionFind {

    private int[] elements;

    public QuickUnionUF(int num) {
        elements = new int[num];
        for (int i = 0; i < num ; i++) {
            elements[i] = i;
        }
    }

    private int root(int i) {
        while (i != elements[i]) {
            i = elements[i];
        }
        return i;
    }

    @Override
    public void union(int p, int q) {
        int pr = root(p);
        int qr = root(q);
        if (qr == pr) return;
        elements[pr] = qr;
        System.out.println("(" + p + "," + q + ")  - " + Arrays.toString(elements));
    }

    @Override
    public boolean connected(int p, int q) {
        return false;
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
        return elements;
    }
}

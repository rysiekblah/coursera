package unionfind;

import java.util.Arrays;

/**
 * Created by tomek on 9/8/14.
 */
public class WeightedQuickUnionUF implements UnionFind {

    private int[] elements;
    private int[] branchSize;

    public WeightedQuickUnionUF(int size) {
        elements = new int[size];
        branchSize = new int[size];
        for (int i = 0; i < size; i++) {
            elements[i] = i;
            branchSize[i] = 1;
        }
    }

    private int root(int index) {
        while (index != elements[index]) {
            index = elements[index];
        }
        return index;
    }

    @Override
    public void union(int p, int q) {
        //System.out.println(" -- union " + p + ", " + q);
        int elp = root(p);
        int elq = root(q);

        if (elp == elq) {
            return;
        }

        if (branchSize[elp] >= branchSize[elq]) {
            elements[elq] = elp;
            branchSize[elp] += branchSize[elq];
        } else {
            elements[elp] = elq;
            branchSize[elq] += branchSize[elp];
        }
    }

    @Override
    public boolean connected(int p, int q) {
        return root(p) == root(q);
    }

    @Override
    public int find(int p) {
        return root(p);
    }

    @Override
    public int count() {
        return 0;
    }

    public int[] getElements() {
        return elements;
    }

    public void print() {
        System.out.println("UF: " + Arrays.toString(elements));
    }
}

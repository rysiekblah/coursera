import java.util.Arrays;

import unionfind.WeightedQuickUnionUF;


/**
 * Created by tomek on 9/10/14.
 */
public class Percolation {
    private int TOP, BOTTOM;
    private int N;
    private boolean[] fieldsState;
    private int[] bottomConnectedSites;
    private int bottomCount;

    private WeightedQuickUnionUF uf;

    // create N-by-N grid, with all sites blocked
    public Percolation(int N) {
        if (N <= 0) {
            throw new IllegalArgumentException();
        }
        this.N = N;
        int size;
        bottomCount = 0;
        bottomConnectedSites = new int[N];
        size = N * N + 2;
        uf = new WeightedQuickUnionUF(size);
        fieldsState = new boolean[size];
        TOP = 0;
        BOTTOM = size - 1;
    }

    // open site (row i, column j) if it is not already
    public void open(int i, int j) {
        checkRanges(i, j);
        if (i == 1) {
            uf.union(getIndex(i, j), TOP);
        }

        if (i == N /* && isFull(i, j)*/) {
            //uf.union(BOTTOM, TOP);
            uf.union(getIndex(i, j), BOTTOM);
            //bottomConnectedSites[bottomCount++] = getIndex(i, j);
        }

        setFieldAsOpen(i, j);

        // check up
        if (i > 1 && isOpen(i - 1, j)) {
            //System.out.println("  +++ check UP");
            manageSites(getIndex(i, j), getIndex(i - 1, j));
        }

        // check down
        if (i < N && isOpen(i + 1, j)) {
            //System.out.println("  +++ check DOWN");
            manageSites(getIndex(i, j), getIndex(i + 1, j));
        }

        // check left
        if (j > 1 && isOpen(i, j - 1)) {
            //System.out.println("  +++ check LEFT");
            manageSites(getIndex(i, j), getIndex(i, j - 1));
        }

        // check right
        if (j < N && isOpen(i, j + 1)) {
            //System.out.println("  +++ check RIGHT");
            manageSites(getIndex(i, j), getIndex(i, j + 1));
        }
    }

    private void manageSites(int i, int j) {
        uf.union(i, j);
    }

    private boolean getFieldState(int i, int j) {
        //System.out.println("Index: " + i + ", " + j + " -- " + fieldsState[getIndex(i, j)]);
        return fieldsState[getIndex(i, j)];
    }

    private int getIndex(int i, int j) {
        return (i - 1) * N + j;
    }

    private void setFieldAsOpen(int i, int j) {
        if (!fieldsState[getIndex(i, j)]) {
            fieldsState[getIndex(i, j)] = true;
        }
    }

    // is site (row i, column j) open?
    public boolean isOpen(int i, int j) {
        checkRanges(i, j);
        return getFieldState(i, j);
    }

    // is site (row i, column j) full?
    public boolean isFull(int i, int j) {
        boolean isfull = isOpen(i, j) && uf.connected(TOP, getIndex(i, j));
        if (i == N && isfull) {
            uf.union(BOTTOM, TOP);
        }
        return isfull;

//        if (!isOpen(i, j)) {
//            return false;
//        }
//        for (int k = 1; k <= N; k++) {
//            if (uf.find(getIndex(i, j)) == uf.find(getIndex(1, k))) {
//                return true;
//            }
//        }
//        return false;
    }

    // does the system percolate?
    public boolean percolates() {
        return uf.connected(TOP, BOTTOM);

//        for (int jDown = 1; jDown <= N; jDown++) {
//            for (int jUp = 1; jUp <= N; jUp++) {
//                if (uf.find(getIndex(N, jDown)) == uf.find(getIndex(1, jUp))) {
//                    return isOpen(N, jDown) && isOpen(1, jUp);
//                }
//            }
//        }
//        return false;
    }

    private void checkRanges(int i, int j) {
        //System.out.println("  -- checkRanges ids: " + i + ", " + j);
        if ((i < 1 || i > N) || (j < 1 || j > N)) {
            throw new IndexOutOfBoundsException();
        }
    }

    public void print() {
//        System.out.println("Siz" +
//                "e: " + fieldsState.length);
//        System.out.println(Arrays.toString(fieldsState));
//        System.out.println(">> " + Arrays.toString(uf.getElements()));
        uf.print();
    }

}


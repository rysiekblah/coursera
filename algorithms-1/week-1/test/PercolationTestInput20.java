import org.junit.Test;

import java.awt.*;

import static junit.framework.TestCase.assertFalse;

/**
 * Created by tomek on 9/16/14.
 */
public class PercolationTestInput20 {

    @Test
    public void test() {
        In in = new In("feeds/input20.txt");      // input file
        int N = in.readInt();
        System.out.println("Size: " + N);
        Percolation p = new Percolation(N);
        while (!in.isEmpty()) {
            StdDraw.show(0);
            int i = in.readInt();
            int j = in.readInt();
            p.open(i, j);
            draw(p, N);
            StdDraw.show(10);
        }

        while (true) {

        }

        //assertFalse(p.isFull(18, 1));
        /*
        * Percolation perc = new Percolation(N);
        draw(perc, N);
        while (!in.isEmpty()) {
            StdDraw.show(0);          // turn on animation mode
            int i = in.readInt();
            int j = in.readInt();
            perc.open(i, j);
            draw(perc, N);
            StdDraw.show(100);        // pause for 100 miliseconds
        }
        * */
    }

    public static void draw(Percolation perc, int N) {
        StdDraw.clear();
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.setXscale(0, N);
        StdDraw.setYscale(0, N);
        StdDraw.filledSquare(N/2.0, N/2.0, N/2.0);

        // draw N-by-N grid
        int opened = 0;
        for (int row = 1; row <= N; row++) {
            for (int col = 1; col <= N; col++) {
                if (perc.isFull(row, col))
                    StdDraw.setPenColor(StdDraw.BOOK_LIGHT_BLUE);
                else if (perc.isOpen(row, col))
                    StdDraw.setPenColor(StdDraw.WHITE);
                else
                    StdDraw.setPenColor(StdDraw.BLACK);
                StdDraw.filledSquare(col - 0.5, N - row + 0.5, 0.45);
                if (perc.isOpen(row, col)) opened++;
            }
        }

        // write status text
        StdDraw.setFont(new Font("SansSerif", Font.PLAIN, 12));
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.text(.25*N, -N*.025, opened + " open sites");
        if (perc.percolates()) StdDraw.text(.75*N, -N*.025, "percolates");
        else                   StdDraw.text(.75*N, -N*.025, "does not percolate");

    }

}

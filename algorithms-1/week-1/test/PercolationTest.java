import org.junit.Test;

/**
 * Created by tomek on 9/16/14.
 */

import java.util.Arrays;
import java.util.Random;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

/**
 * Created by tomek on 9/10/14.
 */
public class PercolationTest {

    @Test
    public void test1() {
        Percolation p = new Percolation(4);

        p.open(2, 2);
        assertFalse(p.isFull(2, 2));

        p.open(1, 2);
        assertTrue(p.isFull(2, 2));

        p.open(4, 3);
        assertFalse(p.isFull(4, 3));

        p.open(2, 3);
        assertFalse(p.isFull(4, 3));

        assertFalse(p.percolates());

        p.open(3, 3);
        //p.print();
        assertTrue(p.isFull(4, 3));
        assertTrue(p.percolates());

        assertTrue(p.isOpen(2, 2));
        assertTrue(p.isOpen(1, 2));
        assertTrue(p.isOpen(4, 3));
        assertTrue(p.isOpen(2, 3));
        assertTrue(p.isOpen(3, 3));

    }




    @Test
    public void test2() {
        Percolation p = new Percolation(5);

        System.out.println(" >> CHECK IF NOT OPENED");
        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= 5; j++) {
                assertFalse(i + ", " + j, p.isOpen(i, j));
                assertFalse(p.isFull(i, j));
            }
        }

        assertFalse(p.percolates());

        System.out.println(" >> OPEN SITES");
        //p.print();
        for (int i = 5; i > 1; i--) {
            for (int j = 1; j <= 5; j++) {
                p.open(i, j);
                assertTrue(i + ", " + j, p.isOpen(i, j));
            }
        }
        //p.print();

        System.out.println(" >> CHECK IF NOT FULL");
        for (int i = 5; i > 1; i--) {
            for (int j = 1; j <= 5; j++) {
                assertFalse(i + ", " + j, p.isFull(i, j));
                assertTrue(i + ", " + j, p.isOpen(i, j));
            }
        }

        assertFalse(p.percolates());
        // p.print();

        for (int i = 1; i <= 5; i++) {
            assertFalse(1 + ", " + i, p.isOpen(1, i));
        }

        System.out.println(" >> MAKE PERLOCATED Grid");
        p.open(1, 1);
        //p.print();
        assertTrue(p.percolates());

    }

    @Test
    public void test3() {
        Percolation p = new Percolation(5);
        p.open(5, 1);
        p.open(4, 2);
        p.open(3, 3);
        p.open(2, 4);
        p.open(5, 5);
        p.open(4, 4);
        p.open(2, 2);
        p.open(1, 1);
        p.open(2, 3);

        for (int i = 1; i < 6; i++) {
            for (int j = 1; j < 6; j++) {
                if (i != 1) {
                    assertFalse(i + ", " + j, p.isFull(i, j));
                }
            }
        }

        assertFalse(p.percolates());

        p.open(2, 1);
        assertFalse(p.percolates());

        assertTrue(1 + ", " + 1, p.isFull(1, 1));
        assertTrue(2 + ", " + 1, p.isFull(2, 1));
        assertTrue(2 + ", " + 2, p.isFull(2, 2));
        assertTrue(2 + ", " + 3, p.isFull(2, 3));
        assertTrue(2 + ", " + 4, p.isFull(2, 4));
        assertTrue(3 + ", " + 3, p.isFull(3, 3));

        assertFalse(p.percolates());
        p.open(4, 3);
        assertFalse(p.percolates());
        p.open(3, 4);
        assertFalse(p.percolates());
        p.open(4, 5);
        assertTrue(p.percolates());
    }


    @Test
    public void test4() {
        Percolation p = new Percolation(1);
        assertFalse(p.percolates());
        p.open(1, 1);
        assertTrue(p.percolates());
    }

    @Test
    public void test5() {
        Percolation p = new Percolation(2);
        assertFalse(p.percolates());
        p.open(1, 1);
        p.open(2, 1);
        assertTrue(p.percolates());
    }

    @Test
    public void test6() {
        Percolation p = new Percolation(4);
        p.open(2, 1); //1
        p.open(3, 2); //2
        p.open(3, 3); //3
        p.open(3, 1); //4
        p.open(3, 4); //5
        p.open(1, 4); //6
        p.open(2, 3); //7
        p.open(1, 1); //8
        p.open(4, 3); //9
        assertTrue(p.isFull(4, 3));

    }

    @Test
    public void test7() {
        Percolation p = new Percolation(4);
        p.open(2, 1);
        p.open(3, 1);
        p.open(4, 1);
        assertFalse(p.isFull(4, 1));
    }

    @Test
    public void test8() {
        Random rnd = new Random();

        Percolation p = new Percolation(4);
        for (int i = 0; i < 1000; i++) {
            int pp = rnd.nextInt(3) + 2;
            int qq = rnd.nextInt(4) + 1;
            //System.out.println(" >> " + pp + ", " + qq);
            p.open(pp, qq);
        }
        for (int i = 1; i <= 4; i++) {
            assertFalse(p.isOpen(1, i));
        }
        for (int i = 2; i <= 4; i++) {
            for (int j = 1; j <= 4; j++) {
                assertTrue(p.isOpen(i, j));
                assertFalse(p.isFull(i, j));
            }
        }

        assertFalse(p.percolates());

        p.open(1, 1);
        assertTrue(p.percolates());
        for (int i = 2; i <= 4; i++) {
            for (int j = 1; j <= 4; j++) {
                assertTrue(p.isOpen(i, j));
                assertTrue(p.isFull(i, j));
            }
        }

    }

    @Test
    public void test9() {
        Percolation p = new Percolation(4);
        p.open(3, 3);
        p.open(2, 4);
        p.open(3, 4);
        p.open(2, 2);
        p.open(3, 2);
        p.open(1, 2);
        assertFalse(p.percolates());
        assertTrue(p.isFull(2, 4));
        p.open(4, 4);
        assertTrue(p.percolates());
    }

    @Test
    public void test10() {
        Percolation p = new Percolation(4);
        p.open(1, 3);
        p.open(2, 4);
        p.open(3, 3);
        p.open(4, 4);
    }

    @Test
    public void test11() {
        Percolation p = new Percolation(5);
        p.open(1, 3);
        p.open(1, 4);
        p.open(2, 1);
        p.open(2, 2);
        p.open(2, 4);
        p.open(2, 5);
        p.open(3, 3);
        p.open(3, 5);
        p.open(4, 1);
        //p.open(4, 2);
        //p.open(4, 4);
        p.open(4, 5);
        p.open(5, 1);
        p.open(5, 3);
        p.open(5, 4);
        //p.open(5, 5);


        assertFalse(p.isFull(4, 1));
    }

    @Test
    public void test12() {

        Percolation p = new Percolation(4);
        p.open(1, 4);
        p.print();
        p.open(2, 4);
        p.print();
        p.open(3, 1);
        p.print();
        p.open(3, 2);
        p.print();
        p.open(3, 4);
        p.print();
        p.open(4, 1);
        p.print();
        p.open(4, 4);
        p.print();

        assertFalse(p.isFull(3, 1));
    }

    @Test
    public void testRecur() {
        System.out.println(find(0));
        System.out.println(Arrays.toString(tab));
        matrix2();
    }

    int[] tab = new int[]{1,3,5,7,9};

    private int find(int i) {
        if (i == tab.length-1) {
            return tab[i];
        }
        int val = find(i + 1);
        tab[i] = val;
        return val;
    }

    private void matrix() {
        int[][] mx = new int[5][5];
        for (int i = 0; i < 5; i++) {
            for (int j = 4; j >= 4-i; j--) {
                mx[i][j] = 1;
            }
        }

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(mx[i][j] + " ");
            }
            System.out.println();
        }
    }

    private void matrix2() {
        char[][] mx = new char[5][5];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (j == (4 - i)) {
                    mx[i][j] = '*';
                } else if (j >= (5 - i)) {
                    mx[i][j] = '-';
                } else {
                    mx[i][j] = '+';
                }
            }
        }
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(mx[i][j] + " ");
            }
            System.out.println();
        }
    }
}

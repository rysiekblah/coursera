package kozlowst;

import org.junit.Test;

/**
 * Created by tomek on 9/25/14.
 */
public class Checksum {

    private int checksumCalc(int[] a) {
        int chks = 0;
        for (int i : a) {
            chks += i;
        }
        chks &= 0xff;
        return chks;
    }

    @Test
    public void test() {
        int[] a = new int[]{1, 2, 3};
        int[] b = new int[]{2, 2, 2};

        System.out.println(checksumCalc(a));
        System.out.println(checksumCalc(b));
    }

}

package kozlowst;

import org.junit.Test;

import java.util.Arrays;

import static kozlowst.SortUtils.isSorted;
import static org.junit.Assert.assertTrue;

/**
 * Created by tomek on 9/27/14.
 */
public class ShellSorTest {

    @Test
    public void test() {
        Integer arr[] = new Integer[]{4, 2, 1, 3, 0, 1, 0, 2, 4, 5};
        ShellSort.sort(arr);
        assertTrue(isSorted(arr));
    }

}

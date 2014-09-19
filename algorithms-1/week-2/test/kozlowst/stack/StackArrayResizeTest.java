package kozlowst.stack;

import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

/**
 * Created by tomek on 9/19/14.
 */
public class StackArrayResizeTest {

    private CommonStackTest commonStackTest = new CommonStackTest();

    @Test
    public void test1() {
        commonStackTest.test1(new StackArrayResize());
    }

    @Test
    public void test2() {
        commonStackTest.test2(new StackArrayResize());
    }

    @Test
    public void test3() {
        commonStackTest.test3(new StackArrayResize());
    }

}

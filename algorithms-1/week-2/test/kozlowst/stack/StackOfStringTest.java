package kozlowst.stack;

import org.junit.Test;

/**
 * Created by tomek on 9/19/14.
 */
public class StackOfStringTest {

    CommonStackTest commonStackTest = new CommonStackTest();

    @Test
    public void test1() {
        commonStackTest.test1(new StackOfString(commonStackTest.items1.length));
    }

    @Test
    public void test2() {
        commonStackTest.test2(new StackOfString(commonStackTest.items1.length));
    }

    @Test
    public void test3() {
        commonStackTest.test3(new StackOfString(commonStackTest.items3.length));
    }

}

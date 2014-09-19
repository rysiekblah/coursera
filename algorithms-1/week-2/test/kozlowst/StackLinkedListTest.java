package kozlowst;

import org.junit.Test;

/**
 * Created by tomek on 9/19/14.
 */
public class StackLinkedListTest {

    CommonStackTest commonStackTest = new CommonStackTest();

    @Test
    public void test1() {
        commonStackTest.test1(new StackLinkedList());
    }

    @Test
    public void test2() {
        commonStackTest.test2(new StackLinkedList());
    }

    @Test
    public void test3() {
        commonStackTest.test3(new StackLinkedList());
    }

}

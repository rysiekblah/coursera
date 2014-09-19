package kozlowst.stack;

import kozlowst.stack.Stack;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

/**
 * Created by tomek on 9/19/14.
 */
public class CommonStackTest {

    public String[] items1 = new String[]{"all", "politicians", "are", "idiots"};
    public String[] items3 = new String[]{
            "0", "1", "2", "3", "4", "5", "6", "7", "9"
    };

    public void test1(Stack stack) {

        for (String item : items1) {
            stack.push(item);
        }

        assertFalse(stack.isEmpty());
        assertEquals(items1.length, stack.size());

        for (int i = items1.length - 1; i >= 0; i--) {
            assertEquals(items1[i], stack.pop());
        }
    }

    public void test2(Stack stack) {

        for (String item : items1) {
            stack.push(item);
            assertEquals(item, stack.pop());
            assertTrue(stack.isEmpty());
        }
    }

    public void test3(Stack stack) {

        assertEquals(0, stack.size());
        assertTrue(stack.isEmpty());

        for (String item : items3) {
            stack.push(item);
        }

        int sizeSnap = stack.size();

        for (String item : items3) {
            stack.pop();
        }

        assertTrue("size: " + stack.size(), stack.size() == 0);
    }

}

package kozlowst;

import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

/**
 * Created by tomek on 9/19/14.
 */
public class StackOfStringTest {

    @Test
    public void test1() {

        String[] items = new String[]{"all", "politicians", "are", "idiots"};

        StackOfString stack = new StackOfString(items.length);

        for (String item : items) {
            stack.push(item);
        }

        assertFalse(stack.isEmpty());
        assertEquals(items.length, stack.size());

        for (int i = items.length - 1; i >= 0; i--) {
            assertEquals(items[i], stack.pop());
        }
    }

    @Test
    public void test2() {
        String[] items = new String[]{"all", "politicians", "are", "idiots"};

        StackOfString stack = new StackOfString(items.length);

        for (String item : items) {
            stack.push(item);
            assertEquals(item, stack.pop());
            assertTrue(stack.isEmpty());
        }
    }

}

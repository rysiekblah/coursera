import org.junit.Test;

import static junit.framework.Assert.fail;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

/**
 * Created by tomek on 9/20/14.
 */
public class DequeIteratorTest {

    @Test
    public void testAddFirstAndIterate() {
        Deque<Integer> deque = new Deque<>();
        Integer[] items = new Integer[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        for (Integer item : items) {
            deque.addFirst(item);
        }

        int i = 9;
        for (Integer integer : deque) {
            assertEquals(items[i], integer);
            i--;
        }

    }

    @Test
    public void testAddLastAndIterate() {
        Deque<Integer> deque = new Deque<>();
        Integer[] items = new Integer[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        for (Integer item : items) {
            deque.addLast(item);
        }

        int i = 0;
        for (Integer integer : deque) {
            assertEquals(items[i], integer);
            i++;
        }
        assertTrue(items.length == i);
    }

    @Test
    public void testIterateEmpty() {
        Deque deque = new Deque();

        for (Object o : deque) {
            fail("Shouldn't enter here");
        }

    }

}

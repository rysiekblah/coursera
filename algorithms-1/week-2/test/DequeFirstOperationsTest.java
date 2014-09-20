import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by tomek on 9/20/14.
 */
public class DequeFirstOperationsTest {

    @Test
    public void test1() {
        Deque<Integer> deque = new Deque<>();
        deque.addFirst(1);
        deque.addFirst(2);
        assertEquals(2, deque.removeFirst().intValue());
        assertEquals(1, deque.removeFirst().intValue());
    }

    @Test
    public void test2() {
        Integer[] items = new Integer[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

        Deque<Integer> deque = new Deque<>();

        for (Integer item : items) {
            deque.addFirst(item);
        }

        for (int i = items.length - 1; i <= 0; i++) {
            assertEquals(items[i], deque.removeFirst());
        }

    }
}

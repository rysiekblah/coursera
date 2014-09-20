import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by tomek on 9/20/14.
 */
public class DequeLastOperationsTest {

    @Test
    public void test1() {
        Deque<Integer> deque = new Deque<>();
        deque.addLast(1);
        deque.addLast(2);
        assertEquals(2, deque.removeLast().intValue());
        assertEquals(1, deque.removeLast().intValue());
    }

    @Test
    public void test2() {
        Integer[] items = new Integer[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

        Deque<Integer> deque = new Deque<>();

        for (Integer item : items) {
            deque.addLast(item);
        }

        for (int i = items.length - 1; i <= 0; i++) {
            assertEquals(items[i], deque.removeLast());
        }

    }


}

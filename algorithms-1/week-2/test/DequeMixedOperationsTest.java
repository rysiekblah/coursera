import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by tomek on 9/20/14.
 */
public class DequeMixedOperationsTest {



    @Test
    public void testSimpleAddRemove() {
        Deque<Integer> deque = new Deque<>();
        deque.addFirst(1);
        deque.addLast(2);
        assertEquals(1, deque.removeFirst().intValue());
        assertEquals(2, deque.removeLast().intValue());
    }

    @Test
    public void testLILOScenario() {
        Deque<Integer> deque = new Deque<>();
        deque.addFirst(1);
        deque.addFirst(2);
        deque.addFirst(3);
        assertEquals(1, deque.removeLast().intValue());
        assertEquals(2, deque.removeLast().intValue());
        assertEquals(3, deque.removeLast().intValue());
    }

    @Test
    public void testLILOScenario2() {
        Deque<Integer> deque = new Deque<>();
        deque.addLast(1);
        deque.addLast(2);
        deque.addLast(3);
        assertEquals(1, deque.removeFirst().intValue());
        assertEquals(2, deque.removeFirst().intValue());
        assertEquals(3, deque.removeFirst().intValue());
    }
}

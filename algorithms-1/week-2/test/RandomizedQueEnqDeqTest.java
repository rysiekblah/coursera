import org.junit.Test;

import java.util.Iterator;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

/**
 * Created by tomek on 9/21/14.
 */
public class RandomizedQueEnqDeqTest {

    @Test
    public void testBasic() {
        RandomizedQueue<Integer> queue = new RandomizedQueue<>();
        queue.enqueue(1);
        assertEquals(1, queue.dequeue().intValue());
    }

    @Test
    public void testBasic2() {
        RandomizedQueue<Integer> queue = new RandomizedQueue<>();
        queue.enqueue(1);
        queue.enqueue(2);
        assertEquals(2, queue.size());
        queue.dequeue();
        queue.dequeue();
        assertTrue(queue.isEmpty());
        assertEquals(0, queue.size());
    }

    @Test
    public void test() {

        RandomizedQueue<Integer> queue = new RandomizedQueue<>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        for (Integer integer : queue) {
            System.out.println(integer);
        }
        System.out.println("----");
        System.out.println(queue.sample());
        System.out.println(queue.sample());
        System.out.println(queue.sample());
        System.out.println(queue.sample());
        System.out.println(queue.sample());
        System.out.println(queue.sample());

    }

}

import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.junit.Assert.fail;

/**
 * Created by tomek on 9/20/14.
 */
public class RandomizedQueExceptionsTest {

    @Test(expected = NullPointerException.class)
    public void testAddNull() {
        RandomizedQueue<Integer> queue = new RandomizedQueue<>();
        queue.enqueue(null);
    }

    @Test(expected = NoSuchElementException.class)
    public void testDequeueIfEmpty1() {
        RandomizedQueue<Integer> queue = new RandomizedQueue<>();
        queue.dequeue();
    }

    @Test(expected = NoSuchElementException.class)
    public void testDequeueIfEmpty2() {
        RandomizedQueue<Integer> queue = new RandomizedQueue<>();
        queue.enqueue(1);
        queue.dequeue();
        queue.dequeue();
    }

    @Test(expected = NoSuchElementException.class)
    public void testSampleIfEmpty() {
        RandomizedQueue queue = new RandomizedQueue();
        queue.sample();
    }


    @Test(expected = UnsupportedOperationException.class)
    public void testCallIteratorRemove() {
        RandomizedQueue queue = new RandomizedQueue();
        queue.iterator().remove();
    }

    @Test(expected = NoSuchElementException.class)
    public void testCallIteratorNextIfEmpty1() {
        RandomizedQueue queue = new RandomizedQueue();
        queue.iterator().next();
    }

    @Test(expected = NoSuchElementException.class)
    public void testCallIteratorNextIfEmpty2() {
        RandomizedQueue<Integer> queue = new RandomizedQueue<>();
        queue.enqueue(1);
        Iterator<Integer> it = queue.iterator();
        try {
            it.next();
        } catch (Exception e) {
            fail("Exception thrown " + e);
        }
        it.next();
    }

    @Test(expected = NoSuchElementException.class)
    public void testCallIteratorNextIfEmpty3() {
        RandomizedQueue<Integer> queue = new RandomizedQueue<>();
        queue.enqueue(1);
        queue.dequeue();
        Iterator<Integer> it = queue.iterator();
        it.next();
    }

}

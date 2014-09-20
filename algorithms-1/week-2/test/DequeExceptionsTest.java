import org.junit.Test;

import java.util.NoSuchElementException;

import static org.junit.Assert.assertEquals;

/**
 * Created by tomek on 9/20/14.
 */
public class DequeExceptionsTest {



    @Test(expected = NullPointerException.class)
    public void testAddFirstNullValue() {
        Deque<Integer> deque = new Deque<>();
        deque.addFirst(null);
    }

    @Test(expected = NullPointerException.class)
    public void testAddLastNullValue() {
        Deque<Integer> deque = new Deque<>();
        deque.addLast(null);
    }

    @Test(expected = NoSuchElementException.class)
    public void testRemoveFirstEmptyQue1() {
        Deque<Integer> deque = new Deque<>();
        deque.removeFirst();
    }

    @Test(expected = NoSuchElementException.class)
    public void testRemoveFirstEmptyQue2() {
        Deque<Integer> deque = new Deque<>();
        deque.addFirst(1);
        deque.removeFirst();
        deque.removeFirst();
    }

    @Test(expected = NoSuchElementException.class)
    public void testRemoveLastEmptyQue1() {
        Deque deque = new Deque();
        deque.removeLast();
    }

    @Test(expected = NoSuchElementException.class)
    public void testRemoveLastEmptyQue2() {
        Deque deque = new Deque();
        deque.addLast(new Object());
        deque.removeLast();
        deque.removeFirst();
    }

    @Test(expected = NoSuchElementException.class)
    public void testAddFirstRemoveLast() {
        Deque<Integer> deque = new Deque<>();
        deque.addFirst(1);
        deque.removeFirst();
        deque.removeFirst();
    }

    @Test(expected = NoSuchElementException.class)
    public void testAddLastRemoveFirst() {
        Deque<Integer> deque = new Deque<>();
        deque.addLast(1);
        deque.removeFirst();
        deque.removeFirst();
    }

}

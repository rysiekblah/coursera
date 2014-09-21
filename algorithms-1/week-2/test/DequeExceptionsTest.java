import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

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

    @Test(expected = UnsupportedOperationException.class)
    public void testCallIteratorRemove() {
        Deque deque = new Deque();
        deque.iterator().remove();
    }

    @Test(expected = NoSuchElementException.class)
    public void testCallIteratorNextIfEmpty() {
        Deque deque = new Deque();
        deque.iterator().next();
    }

    @Test(expected = NoSuchElementException.class)
    public void testCallIteratorNextIfEmpty2() {
        Deque<Integer> deque = new Deque<>();
        deque.addFirst(1);
        Iterator<Integer> it = deque.iterator();
        it.next();
        it.next();
    }

    @Test(expected = NoSuchElementException.class)
    public void testCallIteratorNextIfEmpty3() {
        Deque<Integer> deque = new Deque<>();
        deque.addLast(1);
        Iterator<Integer> it = deque.iterator();
        it.next();
        it.next();
    }

    @Test(expected = NoSuchElementException.class)
    public void testCallIteratorNextIfEmpty4() {
        Deque<Integer> deque = new Deque<>();
        deque.addLast(1);
        deque.addFirst(2);
        Iterator<Integer> it = deque.iterator();
        it.next();
        it.next();
        it.next();
    }

}

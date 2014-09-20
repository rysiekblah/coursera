import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by tomek on 9/20/14.
 */
public class Deque<Item> implements Iterable<Item> {

    private Node<Item> head, tail;
    private int N;

    // return an iterator over items in order from front to end
    @Override
    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    // construct an empty deque
    public Deque() {
        head = tail = new Node();
        head.next = tail;
        tail.prev = head;
    }
    // is the deque empty?
    public boolean isEmpty() {
        return N == 0;
    }

    // return the number of items on the deque
    public int size() {
        return N;
    }

    // insert the item at the front
    public void addFirst(Item item) {
        checkItem(item);
        Node<Item> node = new Node<>();
        head.item = item;
        head.prev = node;
        node.next = head;
        head = node;
        N++;

    }

    // insert the item at the end
    public void addLast(Item item) {
        checkItem(item);
        Node<Item> node = new Node<>();
        node.item = item;
        tail.next = node;
        node.prev = tail;
        tail = node;
        N++;
    }

    // delete and return the item at the front
    public Item removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        Item item = head.next.item;
        head = head.next;
        N--;
        return item;
    }

    // delete and return the item at the end
    public Item removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        Item item = tail.item;
        System.out.println("ItemTail: " + item);
        tail.prev.next = null;
        tail = tail.prev;
        N--;
        return item;
    }

    private void checkItem(Item item) {
        if (item == null) {
            throw new NullPointerException();
        }
    }

    // unit testing
    public static void main(String[] args) {

    }

    private class ListIterator implements Iterator<Item> {

        private int index = 0;

        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public Item next() {
            if (N == index || isEmpty()) {
                throw new NoSuchElementException();
            }
            return null;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    private static class Node<Item> {
        Item item;
        Node<Item> next;
        Node<Item> prev;
    }
}

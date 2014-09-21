import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by tomek on 9/20/14.
 */
public class RandomizedQueue<Item> implements Iterable<Item> {

    private Node<Item> head, tail;
    private int N;

    // construct an empty randomized queue
    public RandomizedQueue() {
        head = tail = new Node();
    }

    // is the queue empty?
    public boolean isEmpty() {
        return N == 0;
    }

    // return the number of items on the queue
    public int size() {
        return N;
    }

    // add the item
    public void enqueue(Item item) {
        if (item == null) {
            throw new NullPointerException();
        }
        N++;
        tail.item = item;
        Node<Item> node = new Node<>();
        tail.next = node;
        tail = node;
    }

    // delete and return a random item
    public Item dequeue() {
        checkContent();
        N--;
        Item item = head.item;
        head = head.next;
        return item;
    }

    // return (but do not delete) a random item
    public Item sample() {
        checkContent();
        Node<Item> node = head;
        for (int i = 0; i < StdRandom.uniform(N); i++) {
            node = node.next;
        }
        return node.item;
    }

    private void checkContent() {
        if (N == 0) {
            throw new NoSuchElementException();
        }
    }

    public static void main(String[] args) {

    }   // unit testing

    // return an independent iterator over items in random order
    @Override
    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item> {

        //private Node<Item> node = head;
        private int index = 0;
        private int[] ii = new int[N];

        private ListIterator() {
            for (int i = 0; i < N; i++) {
                ii[i] = i;
            }
            StdRandom.shuffle(ii);
            System.out.println("index order: " + Arrays.toString(ii));
        }

        @Override
        public boolean hasNext() {
            return !(index == N);
        }

        @Override
        public Item next() {
            if (N == index) {
                throw new NoSuchElementException();
            }
            Node<Item> n = head;
            for (int i = 0; i < ii[index]; i++) {
                n = n.next;
            }
            index++;
            return n.item;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    private class Node<Item> {
        Item item;
        Node<Item> next;
        Node<Item> prev;
    }
}
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by tomek on 9/20/14.
 */
public class Deque<Item> implements Iterable<Item> {

    private Node<Item> head;
    private Node<Item> tail = new Node<>();
    private int N;

    // construct an empty deque
    public Deque() {
        head = tail;
        head.setNext(tail);
        tail.setPrev(head);
    }

    // return an iterator over items in order from front to end
    @Override
    public Iterator<Item> iterator() {
        return new ListIterator();
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
        head.setItem(item);
        head.setPrev(node);
        node.setNext(head);
        head = node;
        N++;

    }

    // insert the item at the end
    public void addLast(Item item) {
        checkItem(item);
        Node<Item> node = new Node<>();
        node.setItem(item);
        tail.setNext(node);
        node.setPrev(tail);
        tail = node;
        N++;
    }

    // delete and return the item at the front
    public Item removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        Item item = head.getNext().getItem();
        head = head.getNext();
        N--;
        return item;
    }

    // delete and return the item at the end
    public Item removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        Item item = tail.getItem();
        //System.out.println("ItemTail: " + item);
        tail.getPrev().setNext(null);
        tail = tail.getPrev();
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
        private Node<Item> node = head.getNext();

        @Override
        public boolean hasNext() {
            return node != null && !(N == index);
        }

        @Override
        public Item next() {
            if (N == index || isEmpty()) {
                throw new NoSuchElementException();
            }
            index++;
            Item item = node.getItem();
            node = node.getNext();
            //System.out.println("index: " + index + ", item: " + item + ", next: " + node + ", N: " + N);
            return item;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    private static class Node<Item> {
        private Item item;
        private Node<Item> next;
        private Node<Item> prev;

        public Item getItem() {
            return item;
        }

        public void setItem(Item newitem) {
            this.item = newitem;
        }

        public Node<Item> getNext() {
            return next;
        }

        public void setNext(Node<Item> newnext) {
            this.next = newnext;
        }

        public Node<Item> getPrev() {
            return prev;
        }

        public void setPrev(Node<Item> newprev) {
            this.prev = newprev;
        }
    }
}

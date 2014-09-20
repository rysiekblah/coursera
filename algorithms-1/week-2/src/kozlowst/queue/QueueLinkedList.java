package kozlowst.queue;

import kozlowst.Node;

/**
 * Created by tomek on 9/19/14.
 */
public abstract class QueueLinkedList<T> implements Queue<T> {

    private Node<T> head;
    private Node<T> tail;
    private int N;

    public QueueLinkedList() {
        head = tail = new Node();
    }

    @Override
    public void enqueue(T item) {
        tail.item = item;
        Node node = new Node();
        tail.next = node;
        tail = node;
        N++;
    }

    @Override
    public T dequeue() {
        N--;
        T item = head.item;
        head = head.next;
        return item;
    }

    @Override
    public boolean isEmpty() {
        return N == 0;
    }

    @Override
    public int size() {
        return N;
    }

    @Override
    public void clear() {

    }

}

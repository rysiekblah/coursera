package kozlowst.queue;

/**
 * Created by tomek on 9/19/14.
 */
public interface Queue<T> {

    void enqueue(T item);

    T dequeue();

    boolean isEmpty();

    int size();

    void clear();

    T[] createTable(int size);

}

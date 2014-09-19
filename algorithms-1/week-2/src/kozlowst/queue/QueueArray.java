package kozlowst.queue;

import java.util.Arrays;

/**
 * Created by tomek on 9/19/14.
 */
public abstract class QueueArray<T> implements Queue<T> {

    protected T[] items;
    protected int N = 0;
    protected int NOUT = 0;

    private void resize(int capacity) {
        T[] tmp = createTable(capacity);
        int ii = 0;

        for (int i = NOUT; i < N; i++) {
            tmp[ii++] = items[i];
        }
        items = tmp;
    }

    protected abstract void init();

    @Override
    public void enqueue(T item) {
        init();
        items[N++] = item;
        if (N == items.length) {
            resize(items.length * 2);
        }
    }

    @Override
    public T dequeue() {
        T item = items[NOUT++];
        if ((N - NOUT) > 0 && (items.length - (N - NOUT)) < items.length / 4) {
            resize(items.length/2);
        }
        return item;
    }

    @Override
    public boolean isEmpty() {
        return N - NOUT == 0;
    }

    @Override
    public int size() {
        return N - NOUT;
    }

    @Override
    public void clear() {

    }

    public void print() {
        System.out.println(Arrays.toString(items));
    }
}

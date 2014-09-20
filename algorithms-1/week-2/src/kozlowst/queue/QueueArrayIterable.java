package kozlowst.queue;

import java.util.Iterator;

/**
 * Created by tomek on 9/20/14.
 */
public class QueueArrayIterable<T> extends QueueArray<T> implements Iterable<T> {

    @Override
    public Iterator<T> iterator() {
        return new ListIterator();
    }

    @Override
    protected void init() {
        if (items == null) {
            items = (T[]) (new Object[1]);
        }
    }

    @Override
    public T[] createTable(int size) {
        return (T[])(new Object[size]);
    }

    private class ListIterator implements Iterator<T> {

        private int NN = 0;

        @Override
        public boolean hasNext() {
            return NN < N && !isEmpty();
        }

        @Override
        public T next() {
            return items[NN++];
        }

        @Override
        public void remove() {

        }
    }
}

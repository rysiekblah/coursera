package kozlowst;

/**
 * Created by tomek on 9/19/14.
 */
public abstract class StackArray<T> implements Stack<T> {

    protected T[] items;
    protected int N;

    @Override
    abstract public void push(T item);

    @Override
    abstract public T pop();

    @Override
    public boolean isEmpty() {
        return N == 0;
    }

    @Override
    public int size() {
        return N;
    }
}

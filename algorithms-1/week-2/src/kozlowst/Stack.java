package kozlowst;

/**
 * Created by tomek on 9/19/14.
 */
public interface Stack<T> {

    void push(T item);

    T pop();

    boolean isEmpty();

    int size();
}

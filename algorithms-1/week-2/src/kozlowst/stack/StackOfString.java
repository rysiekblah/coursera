package kozlowst.stack;

/**
 * Created by tomek on 9/19/14.
 */
public class StackOfString extends StackArray<String> {

    public StackOfString(int capacity) {
        this.N = 0;
        this.items = new String[capacity];
    }

    @Override
    public void push(String item) {
        items[N++] = item;
    }

    @Override
    public String pop() {
        return items[--N];
    }

}

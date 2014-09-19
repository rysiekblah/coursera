package kozlowst;

import java.util.Arrays;

/**
 * Created by tomek on 9/19/14.
 */
public class StackArrayResize extends StackArray<String> {

    public StackArrayResize() {
        items = new String[1];
    }

    @Override
    public void push(String item) {
        items[N++] = item;
        if (N == items.length) {
            resize(N*2);
        }
    }

    @Override
    public String pop() {
        if (N > 0 && N < items.length / 4) {
            resize(items.length / 2);
        }
        return items[--N];
    }

    private void resize(int capacity) {
        System.out.println("Size: " + items.length + ", content: " + Arrays.toString(items));
        String[] tmp = new String[capacity];
        for (int i = 0; i < N; i++) {
            tmp[i] = items[i];
        }
        items = tmp;
    }
}

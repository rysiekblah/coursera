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
        if (N >= items.length / 2) {
            resize();
        }
    }

    @Override
    public String pop() {
        return items[--N];
    }

    private void resize() {
        System.out.println("Size: " + items.length + ", content: " + Arrays.toString(items));
        String[] tmp = new String[N * 2];
        for (int i = 0; i < items.length; i++) {
            tmp[i] = items[i];
        }
        items = tmp;
    }
}

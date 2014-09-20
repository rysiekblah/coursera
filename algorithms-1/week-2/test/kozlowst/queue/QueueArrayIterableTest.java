package kozlowst.queue;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by tomek on 9/20/14.
 */
public class QueueArrayIterableTest {

    @Test
    public void test1() {
        QueueArrayIterable<String> queue = new QueueArrayIterable<>();

        String[] items3 = new String[]{
                "0", "1", "2", "3", "4", "5", "6", "7", "9"
        };

        for (String s : items3) {
            queue.enqueue(s);
        }

        queue.print();
        int i = 0;
        for (String s : queue) {
            assertEquals(items3[i++], s);
            System.out.println("item: " + s);
        }


    }

}

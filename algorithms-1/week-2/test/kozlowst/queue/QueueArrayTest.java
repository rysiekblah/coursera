package kozlowst.queue;

import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

/**
 * Created by tomek on 9/19/14.
 */
public class QueueArrayTest {

    @Test
    public void test1() {
        String[] items3 = new String[]{
                "0", "1", "2", "3", "4", "5", "6", "7", "9"
        };

        QueueArray<String> queue = new QueueArray<String>() {
            @Override
            protected void init() {
                if (items == null) {
                    items = new String[1];
                }
            }

            @Override
            public String[] createTable(int size) {
                return new String[size];
            }
        };

        for (String s : items3) {
            queue.enqueue(s);
        }

        assertFalse(queue.isEmpty());
        assertEquals(items3.length, queue.size());

        queue.print();
        for (String s : items3) {
            assertEquals(s, queue.dequeue());
        }

        assertTrue(queue.isEmpty());
        assertTrue(queue.size() == 0);

    }

}

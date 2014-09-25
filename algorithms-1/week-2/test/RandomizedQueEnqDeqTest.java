import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

/**
 * Created by tomek on 9/21/14.
 */
public class RandomizedQueEnqDeqTest {

    @Test
    public void testBasic() {
        RandomizedQueue<Integer> queue = new RandomizedQueue<>();
        queue.enqueue(1);
        assertEquals(1, queue.dequeue().intValue());
    }

    @Test
    public void testBasic2() {
        RandomizedQueue<Integer> queue = new RandomizedQueue<>();
        queue.enqueue(1);
        queue.enqueue(2);
        assertEquals(2, queue.size());
        queue.dequeue();
        queue.dequeue();
        assertTrue(queue.isEmpty());
        assertEquals(0, queue.size());
    }

    @Test
    public void test() {

        RandomizedQueue<Integer> queue = new RandomizedQueue<>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        for (Integer integer : queue) {
            System.out.println(integer);
        }
        System.out.println("----");
        System.out.println(queue.sample());
        System.out.println(queue.sample());
        System.out.println(queue.sample());
        System.out.println(queue.sample());
        System.out.println(queue.sample());
        System.out.println(queue.sample());

    }

    @Test
    public void testRandomizationCheck() {
        RandomizedQueue<Integer> queue = new RandomizedQueue<>();
        List<Integer> qlist1 = new ArrayList<>();
        List<Integer> qlist2 = new ArrayList<>();
        for (int i = 0; i < 10; i++) queue.enqueue(i);
        for (int i = 0; i < 10; i++) qlist1.add(queue.dequeue());
        for (int i = 0; i < 10; i++) queue.enqueue(i);
        for (int i = 0; i < 10; i++) qlist2.add(queue.dequeue());

        int couner = 0;
        for (int i = 0; i < qlist1.size(); i++) {
            if (qlist1.get(i) == qlist2.get(i)) {
                couner++;
            }
        }
        assertFalse("Ups, order the same", couner == 10);

        Collections.sort(qlist1);
        Collections.sort(qlist2);

        for (int i = 0; i < 10; i++) assertTrue(qlist1.get(i) == qlist2.get(i));

    }

    @Test
    public void testRandomizeSample() {
        RandomizedQueue<Integer> queue = new RandomizedQueue<>();
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
        }

        for (int i = 0; i < 10; i++) {
            list.add(queue.sample());
        }

        System.out.println(list);
    }


}

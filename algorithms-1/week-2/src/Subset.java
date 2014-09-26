
/**
 * Created by tomek on 9/26/14.
 */
public class Subset {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Please provide positive number as parameter.");
            return;
        }

        int cout = Integer.parseInt(args[0]);

        RandomizedQueue<String> queue = new RandomizedQueue<>();

        while (!StdIn.isEmpty()) {
            queue.enqueue(StdIn.readString());
        }

        for (int i = 0; i < cout; i++) {
            System.out.println(queue.dequeue());
        }



    }
}

package kozlowst;

/**
 * Created by tomek on 9/19/14.
 */
public class StackLinkedList implements Stack<String> {

    private Node node;
    private int N;

    public StackLinkedList() {
        node = new Node();
        N = 0;
    }

    @Override
    public void push(String item) {
        Node n = new Node();
        n.item = item;
        n.next = node;
        node = n;
        N++;
    }

    @Override
    public String pop() {
        N--;
        String item = node.item;
        node = node.next;
        return item;
    }

    @Override
    public boolean isEmpty() {
        return N == 0;
    }

    @Override
    public int size() {
        return N;
    }

    @Override
    public void clear() {
        node = null;
    }

    public static class Node {

        public String item;
        public Node next;

        public Node(String item, Node next) {
            this.item = item;
            this.next = next;
        }

        public Node(String item) {
            this(item, null);
        }

        public Node() {
            this(null, null);
        }
    }
}

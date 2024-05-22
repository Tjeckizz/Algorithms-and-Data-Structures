package Labb6;

import java.util.NoSuchElementException;

public class TreeIterator {
    private Node current;
    private final Stack stack;

    public TreeIterator(Node root) {
        stack = new Stack();
        current = root;
        moveLeftmost(current);

    }

    private void moveLeftmost(Node current) {
        while (current != null) {
            stack.push(current);
            current = current.left;
        }
    }

    public boolean hasNext() {
        return stack.isEmpty();
    }

    public Node next() {
        Node r = current;
        current = stack.pop();

        if (current.right != null) {
            moveLeftmost(current.right);
        }
        if (r == null) {
            current = null;
        }
        return current;
    }
}




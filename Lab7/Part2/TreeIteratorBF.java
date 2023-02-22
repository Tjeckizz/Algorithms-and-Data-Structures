package Labb7_1;

public class TreeIteratorBF {
    private final Queue q;

    public TreeIteratorBF(Node root) {
        q = new Queue();
        q.add(root);
    }

    public boolean hasNext() {
        return q.Head != null;
    }

    public Node next() {

        Node current = q.remove();

        //add left child to the queue
        if (current.left != null) {
            q.add(current.left);
        }

        //add right child to the queue
        if (current.right != null) {
            q.add(current.right);
        }

        return current;
    }
}





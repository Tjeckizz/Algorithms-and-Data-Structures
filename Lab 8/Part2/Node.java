package Labb8_1;

public class Node {
    public int subtree;
    public Integer value;
    public Node left, right;
    public Node next;

    public Node(Integer value, int subtree) {
        this.value = value;
        this.subtree = subtree;
        this.left = this.right = null;
    }

    public void print() {
        System.out.println("Value" + value);
        if (left != null) {
            left.print();
        }
        if (right != null) {
            left.print();
        }
    }
}

package Labb6;

public class Stack {

    Node head;

    boolean isEmpty() {
        boolean flag = head == null;
        return flag;
    }

    void push(Node current) {
        Node newNode = new Node(current.key, current.value);
        newNode.left = current.left;
        newNode.right = current.right;
        if (head == null) {
            head = newNode;
        }
        newNode.next = head;
        head = newNode;
    }

    Node pop() {
        if (head == null) {
            System.out.println("Stack is empty");
            return null;
        } else {
            Node pop = head;
            head = head.next;
            return pop;
        }
    }
}
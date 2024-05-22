package Labb7_1;

public class BinaryTree {
    Node root = null;

    public void addTree(Integer key, Integer value) {
        root = addRecursive(root, key, value);
    }

    private Node addRecursive(Node current, Integer key, Integer value) {
        if (current == null) {
            return new Node(key, value);
        }
        if (key == current.key) {
            current.value = value;
            return current;
        } else if (key < current.key) {
            current.left = addRecursive(current.left, key, value);
            return current;
        } else if (key > current.key) {
            current.right = addRecursive(current.right, key, value);
            return current;
        }
        return current;
    }

    public Integer lookup(Integer key) {
        return recursivelookup(root, key);
    }

    private Integer recursivelookup(Node current, int key) {
        if (current == null) {
            return null;
        } else if (current.key == key) {
            return current.value;
        } else if (current.key > key) {
            return recursivelookup(current.left, key);
        } else if (current.key < key) {
            return recursivelookup(current.right, key);
        }
        return null;
    }
}


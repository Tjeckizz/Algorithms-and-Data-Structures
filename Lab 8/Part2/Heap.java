package Labb8_1;

public class Heap {
    Node root = null;
    int left = 1;

    int counter = 0;

    public void add(Integer value) {
        root = addRecursive(root, value);
    }

    private Node addRecursive(Node current, Integer value) {
        Integer temp;

        if (current == null) {
            return new Node(value, 0);
        } else if (value < current.value) {
            temp = current.value;
            current.value = value;
            value = temp;
        }

        if (current.left == null) {
            current.subtree++;
            current.left = addRecursive(current.left, value);
            return current;
        } else if (current.right == null) {
            current.subtree++;
            current.right = addRecursive(current.right, value);
            return current;
        } else if (left == 1) {
            current.subtree++;
            current.left = addRecursive(current.left, value);
            left = 0;
            return current;
        } else if (left == 0) {
            current.subtree++;
            current.right = addRecursive(current.right, value);
            left = 1;
            return current;
        }
        return current;
    }

    public Integer remove() {
        Integer r = root.value;
        root = removeRecursive(root);
        return r;
    }

    public Node removeRecursive(Node current) {
        current.subtree--;
        if (current == null) {
            return null;
        } else if (current.left == null) {
            current = current.right;
            return current;
        } else if (current.right == null) {
            current = current.left;
            return current;
        } else if (current.left.value > current.right.value) {
            //promote right
            current.value = current.right.value;
            current.right = removeRecursive(current.right);
            return current;
        } else if (current.left.value < current.right.value) {
            //promote left
            current.value = current.left.value;
            current.left = removeRecursive(current.left);
            return current;

        }
        return current;
    }

    public Integer push(Integer incr) {
        Integer newValue = this.root.value;
        Integer returner = null;
        if (newValue != null) {
            for (int i = 0; i < incr; i++) {
                newValue++;
            }
            int i = counter;
            root = pushRecursive(root, newValue);
            returner = (counter - i);
        }
        return returner;
    }

    private Node pushRecursive(Node current, Integer newValue) {
        counter++;
        if (current.right == null && current.left == null) {
            current.value = newValue;
            return current;
        } else if (current.right == null) {
            if (current.left.value < newValue) {
                current.value = current.left.value;
                current = pushRecursive(current.left, newValue);
                return current;
            } else {
                current.value = newValue;
                return current;
            }
        } else if (current.left == null) {
            if (current.right.value < newValue) {
                current.value = current.right.value;
                current = pushRecursive(current.right, newValue);
                return current;
            } else {
                current.value = newValue;
                return current;
            }
        } else if (current.left.subtree > current.right.subtree) {
            //promote right
            current.value = current.right.value;
            current.right = pushRecursive(current.right, newValue);
            return current;
        } else {
            //promote left
            current.value = current.left.value;
            current.left = pushRecursive(current.left, newValue);
            return current;
        }
    }

    public void printNodes() {
        root.print();
    }
}

package Labb8;

public class Node {

    public Integer item;
    public Node tail;

    public Node(Integer item, Node list) {
        this.item = item;
        this.tail = list;
    }
}


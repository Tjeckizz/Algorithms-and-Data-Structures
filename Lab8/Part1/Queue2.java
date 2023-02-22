package Labb8;

import java.util.Random;

public class Queue2 {
    Node Head = null;

    public void add(Integer item) {
        Node newNode = new Node(item, null);
        Node temp = Head;
        Node next = null;
        Node prev = null;
        Node previous = Head;

        //System.out.println("Inserting: " + item);

        //If queue is empty create first node
        if (Head == null) {
            Head = newNode;
        } else if (item < Head.item) {
            newNode.tail = Head;
            Head = newNode;
        } else {
            while (temp != null && temp.item < item) {
                if (temp.item > item) {
                    prev = previous;
                    next = temp;
                }
                previous = temp;
                temp = temp.tail;
            }
            if (prev != null) {
                prev.tail = newNode;
                newNode.tail = next;
            } else {
                previous.tail = newNode;
            }
        }
    }

    public Integer remove() {
        Node R = Head;
        //System.out.println("Removing: " + R.item);
        // advance front to the next node
        if (Head.tail != null) {
            Head = Head.tail;
        }
        // if the list becomes empty
        return R.item;
    }

    public static void main(String[] Args) {

        int iterations = 100000;
        int[] n = new int[]{100, 200, 400, 800, 1600, 3200};
        Random rnd = new Random();

        for (int k = 0; k < n.length; k++) {
            long t0;
            long t_total = 0;
            long t = 0;
            long t_total1 = 0;
            long t1 = 0;

            for (int i = 0; i < iterations; i++) {
                Queue2 q = new Queue2();

                int reverse = n[k];
                t0 = System.nanoTime();
                for (int j = 0; j < n[k]; j++) {
                    q.add(rnd.nextInt(n[k] * n[k]));
                    reverse--;
                }
                t = (System.nanoTime() - t0);
                t_total += t;

                t0 = System.nanoTime();
                for (int j = 0; j < n[k]; j++) {
                    //System.out.println(q.remove());
                    q.remove();
                }
                t1 = (System.nanoTime() - t0);
                t_total1 += t1;
            }
            System.out.println("n =" + n[k]);
            System.out.println();
            t_total = t_total / (iterations);
            System.out.println("add is: " + t_total + "ns");
            System.out.println();

            t_total1 = t_total1 / (iterations);
            System.out.println("remove is: " + t_total1 + "ns");
            System.out.println();
        }
    }
}


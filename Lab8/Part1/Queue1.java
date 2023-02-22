package Labb8;

import java.util.Random;

public class Queue1 {

    Node Head = null;
    Node Next = null;

    public void add(Integer item) {
        Node newNode = new Node(item, null);
        //System.out.println("Inserting: " + item);
        //If queue is empty create first node
        if (Head == null) {
            Head = newNode;
            Next = newNode;
        } else {
            Next.tail = newNode;
            Next = newNode;
        }
    }

    public Integer remove() {
        Integer lowest_value = Integer.MAX_VALUE;
        Node prev = null;
        Node next = null;
        Node temp = Head;
        Node previous = Head;

        while (temp != null) {
            if (temp.item < lowest_value) {
                lowest_value = temp.item;
                prev = previous;
                next = temp.tail;
            }
            previous = temp;
            temp = temp.tail;
        }

        if (prev == Head && Head.tail == null) {
            Head = null;
        } else if (prev == Head && Head.tail != null) {
            Head = Head.tail;
        } else if (next != null) {
            prev.tail = next;
        } else {
            prev.tail = null;
        }
        // if the list becomes empty
        if (Head == null) {
            Next = null;
        }
        return lowest_value;
    }

    public static void main(String[] Args) {

        int iterations = 10000;
        int[] n = new int[]{100, 200, 400, 800, 1600, 3200};
        Random rnd = new Random();

        for (int k = 0; k < n.length; k++) {
            long t0;
            long t_total = 0;
            long t = 0;
            long t_total1 = 0;
            long t1 = 0;

            for (int i = 0; i < iterations; i++) {
                Queue1 q = new Queue1();

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
package Labb7;

import java.util.Random;

public class Queue {

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
        Node R = Head;
        //System.out.println("Removing: " + R.item);

        // advance front to the next node
        Head = Head.tail;

        // if the list becomes empty
        if (Head == null) {
            Next = null;
        }
        return R.item;
    }


    public static void main(String[] Args) {
        Queue q = new Queue();
        int iterations = 100000;
        int n = 20;
        Random rnd = new Random();

        long t0;
        long t_total = 0;
        long t = 0;

        t0 = System.nanoTime();
        for (int i = 0; i < iterations; i++) {
            for (int j = 0; j < n; j++) {
                q.add(i);
            }
        }
        t_total = (System.nanoTime() - t0);
        t_total = t_total / iterations;
        System.out.println("add is: " + t_total + "ns");
        System.out.println();


        t0 = System.nanoTime();
        for (int i = 0; i < iterations; i++) {
            for (int j = 0; j < n; j++) {
                q.remove();
            }
        }
        t_total = (System.nanoTime() - t0);
        t_total = t_total / (iterations);
        System.out.println("remove is: " + t_total + "ns");
        System.out.println();
    }
}

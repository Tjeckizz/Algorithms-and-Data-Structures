package Labb5;

public class LinkedListCreation {
    int head;
    LinkedListCreation tail;

    public static void main(String[] Args) {

        int iterations = 1000000;
        int n = 16000;
        long t0;
        long t_total = 0;
        long t = 0;
        long min = Integer.MAX_VALUE;

        for (int i = 0; i < iterations; i++) {
            LinkedListCreation a = new LinkedListCreation(1, null);
            t0 = System.nanoTime();
            a = createLinkedList(n);
            t = (System.nanoTime() - t0);
            t_total += t;
            if (min > t) {
                min = t;
            }
        }
        t_total = t_total / iterations;
        System.out.println("Creating a list avg. = " + t_total + "ns");
        System.out.println("Min Value = " + min + "ns");
        System.out.println();


        t_total = 0;
        min = Integer.MAX_VALUE;

        for (int i = 0; i < iterations; i++) {
            t0 = System.nanoTime();
            int[] array = new int[n];
            t = (System.nanoTime() - t0);
            t_total += t;
            if (min > t) {
                min = t;
            }
        }
        t_total = t_total / iterations;
        System.out.println("Creating an array avg. = " + t_total + "ns");
        System.out.println("Min Value = " + min + "ns");
        System.out.println();
    }

    public LinkedListCreation(int item, LinkedListCreation list) {
        head = item;
        tail = list;
    }

    public static LinkedListCreation createLinkedList(int n) {
        LinkedListCreation nlist = new LinkedListCreation(1, null);
        LinkedListCreation nxt = nlist;
        for (int i = 0; i < (n - 1); i++) {
            nxt.tail = new LinkedListCreation(1, null);
            nxt = nxt.tail;
        }
        return nlist;
    }

    public int head() {
        return this.head;
    }

    public LinkedListCreation tail() {
        return this.tail;
    }

    public void append(LinkedListCreation b) {
        LinkedListCreation nxt = this;
        while (nxt.tail != null) {
            nxt = nxt.tail;
        }
        nxt = b;
    }
}



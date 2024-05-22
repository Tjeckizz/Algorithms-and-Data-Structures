package Labb5;

public class LinkedList {
    int head;
    LinkedList tail;

    public static void main(String[] Args) {

        int iterations = 100000;
        int n = 3200;
        long t0;
        long t_total = 0;
        long t = 0;
        long min = Integer.MAX_VALUE;

        LinkedList a;
        a = createLinkedList(n);
        LinkedList b;
        b = createLinkedList(1);


        for (int i = 0; i < iterations; i++) {
            t0 = System.nanoTime();
            a.append(b);
            t = (System.nanoTime() - t0);
            if (min > t) {
                min = t;
            }
            t_total += t;
        }
        t_total = t_total / iterations;
        System.out.println("Average Value = " + t_total + "ns");
        System.out.println("Min Value = " + min + "ns");
    }

    public LinkedList(int item, LinkedList list) {
        head = item;
        tail = list;
    }

    public static LinkedList createLinkedList(int n) {
        LinkedList nlist = new LinkedList(1, null);
        LinkedList nxt = nlist;
        for (int i = 0; i < (n - 1); i++) {
            nxt.tail = new LinkedList(1, null);
            nxt = nxt.tail;
        }
        return nlist;
    }

    public int head() {
        return this.head;
    }

    public LinkedList tail() {
        return this.tail;
    }

    public void append(LinkedList b) {
        LinkedList nxt = this;
        while (nxt.tail != null) {
            nxt = nxt.tail;
        }
        nxt = b;
    }


}
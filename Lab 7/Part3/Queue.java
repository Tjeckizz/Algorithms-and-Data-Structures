package Labb7_2;

import Labb7_1.BinaryTree;

import java.util.Random;

public class Queue {
    private int indexFirst;
    private int indexNext;
    private int capacity;
    private int i;

    private Integer[] queue;

    public Queue(int cap) {
        capacity = cap;
        queue = new Integer[capacity];
        indexFirst = 0;
        indexNext = 0;
    }

    public void add(int element) {

        if (indexNext == (capacity)) {
            indexNext = 0;
        }
        if (indexNext == indexFirst) {
            expandArray();
            if (i != 0) {
                indexNext = queue.length / 2;
            }
            queue[indexNext] = element;
            i++;
        } else {
            queue[indexNext] = element;    //insert the data
        }
        System.out.println();
        for (int i = 0; i < queue.length; i++)
            System.out.println(queue[i]);
        indexNext++;
        System.out.println();
    }

    public Integer remove() {
        if (indexFirst == (capacity)) {
            indexFirst = 0;
        }
        if (queue[indexFirst] == null) {
            return null;
        } else {
            Integer returner = queue[indexFirst];
            queue[indexFirst] = null;
            indexFirst++;
            return returner;
        }
    }

    public boolean isEmpty() {
        return queue[indexFirst] == null;
    }

    public void expandArray() {
        int curr_size = capacity;
        Integer[] new_array = new Integer[curr_size * 2];

        int i = 0;
        for (int j = indexFirst; j < curr_size; j++) {
            new_array[i] = queue[j];
            i++;
        }
        for (int j = 0; j < indexFirst; j++) {
            new_array[i] = queue[j];
            i++;
        }

        indexFirst = 0;
        queue = new_array;              //refer to the new array
        capacity = new_array.length;
    }

    /*
    public void display() {
        for (int i = 0; i <= index; i++) {
            System.out.print(stack[i] + "=>");
        }
        System.out.println();
        System.out.println("ARRAY SIZE:" + stack.length);
    }*/
    public static void main(String[] Args) {
        int sizeOfQueue = 5;

        int[] n = {100, 200, 400, 800, 1600, 3200, 6400};
        int k = 100000;
        long t, t0, t_tot = 0;

        Random rnd = new Random();
        Queue q = new Queue(sizeOfQueue);

        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        q.add(6);
        q.add(7);
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        q.add(6);
        q.add(7);
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        q.add(6);
        q.add(7);
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        q.add(6);
        q.add(7);
        System.out.println(q.remove());
        System.out.println(q.remove());

        q.add(8);
        q.add(9);
        q.add(10);
        q.add(11);
        System.out.println(q.remove());
        System.out.println(q.remove());
        System.out.println(q.remove());
        System.out.println(q.remove());
        System.out.println(q.remove());
        System.out.println(q.remove());
        System.out.println(q.remove());
        System.out.println(q.remove());
        System.out.println(q.remove());
        System.out.println(q.remove());
        System.out.println(q.remove());
        System.out.println(q.remove());
        /*
        for (int i = 0; i < n.length; i++) {
            for (int j = 0; j < k; j++) {

                int rando = rnd.nextInt((n[i]*n[i]));
                t0 = System.nanoTime();
                q.add((n[i]*n[i])/2);
                for(int m = 0; m < n[i] - 1; m++) {

                    q.add(rando);
                }
                t = System.nanoTime() - t0;
                t_tot += t;

                /*
                TreeIteratorBF iter = new TreeIteratorBF(julgran.root);
                Integer findkey = rnd.nextInt(n[i]);


                while (iter.hasNext() == true) {
                    if (iter.next().key == findkey) {
                        break;
                    }
                }

            }
            t_tot = t_tot / k;
            System.out.println("n: " + n[i] + " tid: " + t_tot);*/
    }
}





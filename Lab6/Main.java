package Labb6;

import java.util.*;

public class Main {

    public static void main(String[] Args) {
        BinaryTree bt = new BinaryTree();

        Random rnd = new Random();
        int iterations = 1;
        int n = 10;
        int[] keys = new int[n];
        int[] values = new int[n];
        int[] iteratorSq = new int[n];

        long t0;
        long t_total = 0;
        long t = 0;
        Integer result;

        keys[0] = ((n * n) / 2);

        //Creating keys and values for each node
        for (int i = 1; i < n; i++) {
            keys[i] = rnd.nextInt(n * n);
        }
        for (int j = 0; j < n; j++) {
            values[j] = rnd.nextInt(n * n);
        }
        System.out.println("Keys: " + Arrays.toString(keys));
        System.out.println("Values: " + Arrays.toString(values));
        System.out.println();

        //Constructing tree
        for (int k = 0; k < n; k++) {
            bt.add(keys[k], values[k]);
        }
        /*
        //Benchmark
        t0 = System.nanoTime();
        for (int l = 0; l < iterations; l++) {
            for (int m = 0; m < n; m++) {
                result = bt.lookup(keys[m]);
            /*if (l == iterations - 1){
                System.out.println("Key " + keys[m] + " is mapping to the value " + result);
            }
            }
        }
        t_total = (System.nanoTime() - t0);
        System.out.println("");
        System.out.println("Average runtime to find the value of a certain node with n = " + n + " number of nodes: " + (t_total / (n * iterations)) + "ns");
        System.out.println("");

        t_total = 0;*/

        //Iterator
        for (int l = 0; l < iterations; l++) {
            TreeIterator itr = new TreeIterator(bt.root);
            Integer Findkey = rnd.nextInt(n * n);
            Integer r = 0;
            t0 = System.nanoTime();
            while (Findkey != r && r != null) {
                r = itr.next().key;
                System.out.println(r);
            }
            t = (System.nanoTime() - t0);
            t_total += t;
        }
        System.out.println();
        System.out.println("Average runtime to iterate through the entire tree in order with n = " + n + " number of nodes: " + (t_total / iterations) + "ns");
        System.out.println();
    }
}



package Labb8_1;

import java.util.Random;
import java.util.Arrays;


public class Main {
    public static void main(String[] Args) {
        Heap tree = new Heap();
        tree.add(10);
        tree.add(5);
        tree.add(7);
        tree.add(6);
        tree.add(8);
        tree.add(14);
        tree.add(4);

        tree.printNodes();

        System.out.println();

        tree.remove();
        tree.printNodes();

        System.out.println();

        tree.remove();
        tree.printNodes();

        System.out.println();

        tree.add(6);
        tree.printNodes();

        System.out.println();

        tree.remove();
        tree.printNodes();
        System.out.println();

        tree.remove();
        tree.printNodes();
        System.out.println();

        tree.remove();
        tree.printNodes();
        System.out.println();

        tree.remove();
        tree.printNodes();
        System.out.println();

        tree.remove();
        tree.printNodes();
        System.out.println();

        tree.remove();
        tree.printNodes();
        System.out.println();
        /*int iterations = 1;
        int[] n = new int[]{6};

        Random rnd = new Random();

        for (int k = 0; k < n.length; k++) {
            long t0;
            long t_total = 0;
            long t = 0;
            long t_total1 = 0;
            long t1 = 0;

            for (int i = 0; i < iterations; i++) {
                Heap test = new Heap();

                t0 = System.nanoTime();
                for (int j = 0; j < n[k]; j++) {
                    test.add(j);
                }
                t = (System.nanoTime() - t0);
                t_total += t;

                t0 = System.nanoTime();
                for (int j = 0; j < n[k]; j++) {
                    System.out.println(test.remove());
                    test.printTree();
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
        }*/
    }
}


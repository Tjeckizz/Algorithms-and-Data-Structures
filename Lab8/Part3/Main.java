package Labb8_2;

import java.util.Arrays;
import java.util.Random;

public class Main {
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
                Heap test = new Heap(n[k]);


                t0 = System.nanoTime();
                for (int j = 0; j < n[k]; j++) {
                    test.add(rnd.nextInt(n[k]));
                }
                t = (System.nanoTime() - t0);
                t_total += t;

                t0 = System.nanoTime();
                for (int j = 0; j < n[k]; j++) {
                    test.remove();
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

package Labb5;

import java.util.*;

public class ArrayLinkedList {
    public static void main(String[] args) {
        Random rnd = new Random();
        int iterations = 100000;
        int n = 12800;
        int constant = 100;
        int[] array = new int[n];
        int[] brray = new int[constant];
        double t0;
        double t_total = 0;
        double t = 0;
        int[] r = new int[array.length + brray.length];
        double min = Integer.MAX_VALUE;

        for (int k = 0; k < iterations; k++) {
            for (int i = 0; i < n; i++) {
                array[i] = rnd.nextInt(n);
            }
            for (int j = 0; j < constant; j++) {
                brray[j] = rnd.nextInt(n);
            }
            t0 = System.nanoTime();
            r = Link(array, brray);
            t = (System.nanoTime() - t0);
            if (min > t) {
                min = t;
            }
            t_total += t;
            //System.out.println(t + "ns");
        }
        t_total = t_total / iterations;
        System.out.println("Average Value = " + t_total + "ns");
        System.out.println("Min Value = " + min + "ns");
    }

    public static int[] Link(int[] array, int[] brray) {
        int[] link = new int[array.length + brray.length];
        int tail = 0;
        for (int i = 0; i < array.length; i++) {
            link[i] = array[i];
            tail++;
        }
        for (int j = 0; j < brray.length; j++) {
            link[tail] = brray[j];
            tail++;
        }
        return link;
    }
}

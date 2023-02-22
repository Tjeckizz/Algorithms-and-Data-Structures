package Labb4;

import java.util.Arrays;
import java.util.Random;

public class Sort1 {

    public static void main(String[] args) {
        Random rnd = new Random();
        int iterations = 100000;
        int n = 25;
        int[] array = new int[n];
        long t0;
        long t_total = 0;
        long t = 0;
        int[] r = new int[n];

        for (int i = 0; i < iterations; i++) {
            int nxt = 0;
            for (int j = 0; j < n; j++) {
                nxt = rnd.nextInt(2 * n);
                array[j] = nxt;
            }

            t0 = System.nanoTime();
            r = Sort(array);
            t = (System.nanoTime() - t0);
            t_total += t;
        }
        t_total = t_total / iterations;
        System.out.println(t_total + "ns");
        System.out.println(Arrays.toString(r));
    }

    public static int[] Sort(int[] array) {
        int temp = 0;
        for (int i = 0; i < array.length - 1; i++) {
            // let's set the first candidate to the index itself
            int cand = i;
            for (int j = i; j < array.length; j++) {
                // If the element at position j is smaller than the value at the candidate position -
                if (array[cand] > array[j]) {
                    cand = j;
                }
                // then you have a new candidate position.
            }
            // Swap the item at position i with the item at the candidate position.
            if (cand != i) {
                temp = array[i];
                array[i] = array[cand];
                array[cand] = temp;
            }
        }
        return array;
    }
}
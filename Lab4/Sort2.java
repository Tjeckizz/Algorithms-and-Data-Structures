package Labb4;

import java.util.Arrays;
import java.util.Random;

public class Sort2 {

    public static void main(String[] args) {
        Random rnd = new Random();
        int iterations = 100000;
        int n = 50;
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

        int n = array.length;
        for (int i = 1; i < n; ++i) {
            int key = array[i];
            int j = i - 1;

            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j = j - 1;
            }
            array[j + 1] = key;
        }
        return array;
    }
}
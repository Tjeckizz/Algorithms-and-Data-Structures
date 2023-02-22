package Labb3;

import java.util.Random;

public class Search3 {

    public static void main(String[] args) {
        Random rnd = new Random();
        int n = 1000;
        int iterations = 100000;
        int[] array = new int[n];
        long t0;
        long t_total = 0;
        long t = 0;
        boolean r;
        int hitsum = 0;

        for (int j = 0; j < iterations; j++) {
            int nxt = 0;
            for (int i = 0; i < n; i++) {
                nxt += rnd.nextInt(10) + 1;
                array[i] = nxt;
            }
            t0 = System.nanoTime();
            for (int k = 0; k < n; k++) {
                int key = rnd.nextInt(nxt);
                r = binary_search(array, key);
            }
            t = (System.nanoTime() - t0);
            t_total += t;

        }
        t_total = (t_total / (iterations * n));
        System.out.println(t_total + "ns");
        System.out.println("hitsum: " + hitsum);
    }

    public static boolean binary_search(int[] array, int key) {
        int first = 0;
        int last = array.length - 1;

        while ((last - first) > 1) {

            int index = ((first + last) / 2);
            if (array[index] == key) {
                return true;
            }
            if (array[index] < key) {
                first = index + 1;
                continue;
            }
            if (array[index] > key) {
                last = index;
            }
        }
        if (array[first] == key) {
            return true;
        } else return array[last] == key;

    }
}

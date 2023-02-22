import java.util.Random;

public class Search4_3 {
    public static void main(String[] args) {
        Random rnd = new Random();
        int n = 3200;
        int iterations = 100000;
        int[] array = new int[n];
        int[] key = new int[n];
        long t0;
        long t_total = 0;
        long t = 0;
        int r = 0;

        for (int j = 0; j < iterations; j++) {
            int nxt = 0;
            for (int i = 0; i < n; i++) {
                nxt += rnd.nextInt(10) + 1;
                array[i] = nxt;
            }
            int nxt2 = 0;
            for (int k = 0; k < n; k++) {
                nxt2 += rnd.nextInt(10) + 1;
                key[k] = nxt2;
            }

            t0 = System.nanoTime();
            r += cross_search(array, key);
            t = (System.nanoTime() - t0);
            t_total += t;
        }
        t_total = t_total / iterations;
        System.out.println(t_total + "ns");
        System.out.println("hitsum: " + r);
    }

    public static int cross_search(int[] array, int[] key) {

        int j = 0;
        int i = 0;
        int hitsum = 0;

        for (int k = 0; k < array.length - 1; k++) {
            if (array[j] == key[i]) {
                hitsum++;
                i++;
                j++;
                continue;
            }
            if (key[i + 1] > array[j + 1]) {
                j++;
                continue;
            }
            if (key[i + 1] <= array[j + 1]) {
                i++;
            }
        }
        return hitsum;
    }
}

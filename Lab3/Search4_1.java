import java.util.Random;

public class Search4_1 {
    public static void main(String[] args) {
        Random rnd = new Random();
        int n = 3200;
        int iterations = 100000;
        int[] array = new int[n];
        int[] key = new int[n];
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
            int nxt2 = 0;
            for (int k = 0; k < n; k++) {
                nxt2 += rnd.nextInt(10) + 1;
                key[k] = nxt2;
            }

            t0 = System.nanoTime();
            r = binary_search1(array, key);
            t = (System.nanoTime() - t0);
            t_total += t;
            if (r) {
                hitsum++;
            }
        }
        System.out.println(t_total / iterations);
    }

    public static boolean binary_search1(int[] array, int[] key) {
        for (int i = 0; i < array.length; i++) {
            for (int index = 0; index < array.length; index++) {
                if (array[index] == key[i]) {
                    break;
                }
            }
        }
        return true;
    }
}


//n^2
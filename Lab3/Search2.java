import java.util.Random;

public class Search2 {

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
            int key = rnd.nextInt(nxt);

            t0 = System.nanoTime();
            r = search_sorted(array, key);
            t = (System.nanoTime() - t0);
            t_total += t;
            if (r) {
                hitsum++;
            }
        }
        t_total = t_total / iterations;
        System.out.println(t_total + "ns");
        System.out.println("hitsum: " + hitsum);
    }

    public static boolean search_sorted(int[] array, int key) {
        for (int index = 0; index < array.length; index++) {
            if (array[index] == key) {
                return true;
            }
            if (key < array[index]) {
                return false;
            }
        }
        return false;
    }
}




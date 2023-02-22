import java.util.Random;

public class Search4_2 {

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
        int u = 0;


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
            r = binary_search2(array, key);
            t = (System.nanoTime() - t0);
            t_total += t;
            u += r;


        }
        t_total = t_total / iterations;
        System.out.println(t_total + "ns");
        System.out.println("hitsum: " + u);
    }


    public static int binary_search2(int[] array, int[] key) {
        int hitsum = 0;

        for (int i = 0; i < key.length - 1; i++) {
            int first = 0;
            int last = array.length - 1;
            while ((last - first) > 1) {
                int index = ((first + last) / 2);

                if (array[index] == key[i]) {
                    hitsum++;
                    break;
                }
                if (array[index] < key[i]) {
                    first = index + 1;
                    continue;
                }
                if (array[index] > key[i]) {
                    last = index - 1;
                    continue;
                }
            }
        }
        return hitsum;
    }
}
//O(n log(n))

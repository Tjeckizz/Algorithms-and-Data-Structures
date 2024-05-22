import java.util.*;

class T3 {
    public static void main(String[] args) {

        int n = 1000;
        int k = 100;
        double medel = 0;
        for (int i = 0; i < k; i++) {
            double s = access(n);
            medel += s;
            System.out.println(s + "ns");
        }
        medel = medel / k;
        System.out.println("Medelvärdet:  " + medel + "ns");
    }

    public static double access(int n) {
        int m = 10000;
        int k = 100;

        Random rnd = new Random();

        long t_total = 0;
        int[] keys = new int[m];
        int[] array = new int[n];

        for (int j = 0; j < k; j++) {

// fill the keys array with random number from 0 to 10*n
            for (int i = 0; i < n; i++) {
                keys[i] = rnd.nextInt(10 * n);
            }

// fill the array with with random number from 0 to 10*n
            for (int i = 0; i < n; i++) {
                array[i] = rnd.nextInt(10 * n);
            }

            int sum = 0;
            long t0 = System.nanoTime();
            for (int ki = 0; ki < n; ki++) {
                int key = keys[ki];
                for (int i = 0; i < n; i++) {
                    if (array[i] == key) {
                        sum++;
                    }
                }
            }
            t_total += (System.nanoTime() - t0);

        }
        return (((double) t_total) / ((double) k));
    }
}
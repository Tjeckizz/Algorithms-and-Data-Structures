package Labb4;


import java.util.Random;

public class Sort3 {

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
            int[] aux = new int[array.length];
            t0 = System.nanoTime();
            r = sort(array, aux, 0, array.length - 1);
            t = (System.nanoTime() - t0);
            t_total += t;
        }
        t_total = t_total / (iterations);
        System.out.print("(" + n + ", " + t_total + ")");

    }


    private static int[] sort(int[] org, int[] aux, int lo, int hi) {
        if (lo != hi) {
            int mid = lo + (hi - lo) / 2;

            // sort the items from lo to mid
            sort(org, aux, lo, mid);

            // sort the items from mid+1 to hi
            sort(org, aux, mid + 1, hi);

            // merge the two sections using the additional array
            merge(org, aux, lo, mid, hi);
        }
        return org;
    }

    private static void merge(int[] org, int[] aux, int lo, int mid, int hi) {

        // copy all items from lo to hi from org to aux
        if (hi + 1 - lo >= 0) System.arraycopy(org, lo, aux, lo, hi + 1 - lo);
        // let's do the merging
        int i = lo; // the index in the first part
        int j = mid + 1; // the index in the second part

        // for all indeces from lo to hi
        for (int k = lo; k <= hi; k++) {

            // if i is greater than mid, move the j item to the org array, update j
            if (i > mid) {
                org[k] = aux[j];
                j++;
            }
            // else if j is greater than hi, move the i item to the org array, update i
            else if (j > hi) {
                org[k] = aux[i];
                i++;
            }
            // else if the i item is smaller than the j item, move it to the org array, update i
            else if (aux[i] < aux[j]) {
                org[k] = aux[i];
                i++;
            }
            // else you can move the j item to the org array, update j
            else {
                org[k] = aux[j];
                j++;
            }
        }
    }
}


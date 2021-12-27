package W9.p2;

import java.util.Arrays;

public class QuickSelect {
    private static final int SIZE = 10;
    private static final int RANGE = 20;

    // generate a random array
    public static int[] generate() {
        int[] res = new int[SIZE];
        for (int i = 0; i < SIZE; i++) {
            res[i] = (int) (Math.random() * RANGE + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] a = generate();
        int k = 5;
        System.out.println(Arrays.toString(Arrays.stream(a).toArray()));
        System.out.println(quickSelect(a, 0, a.length - 1, k - 1));


    }

    private static int quickSelect(int[] a, int l, int r, int k) {
        if (l == r) {
            return a[l];
        }

        int pivot = partition(a, l, r);
        if (k <= pivot) {
            return quickSelect(a, l, pivot, k);
        } else {
            return quickSelect(a, pivot + 1, r, k);
        }
    }

    private static int partition(int[] a, int l, int r) {
        int pivot = a[l];
        int i = l;
        int j = r;
        while (true) {
            while (a[i] < pivot) {
                i++;
            }
            while (pivot < a[j]) {
                j--;
            }
            if (i >= j) {
                return j;
            }
            int tmp = a[j];
            a[j] = a[i];
            a[i] = tmp;
            i++;
            j--;
        }
    }

}

package W9.p1;

import java.util.Arrays;

public class Sorting {

    private static final int SIZE = 6;

    private static int[] generate() {
        int[] arr = new int[SIZE];
        for (int i = 0; i < SIZE; i++) {
            arr[i] = (int) (Math.random() * SIZE * 100 + 1);
        }
        return arr;
    }

    private static void mergeSort(int[] arr) {
        if (arr.length > 1) {
            int n = arr.length;
            int mid = n / 2;

            int[] sub1 = copyArr(arr, 0, mid);
            int[] sub2 = copyArr(arr, mid, n);

            mergeSort(sub1);
            mergeSort(sub2);

            merge(sub1, sub2, arr);
        }
    }

    private static void merge(int[] sub1, int[] sub2, int[] arr) {
        int p1 = 0, p2 = 0, idx = 0;
        while (p1 < sub1.length && p2 < sub2.length) {
            if (sub1[p1] < sub2[p2]) {
                arr[idx++] = sub1[p1++];
            } else {
                arr[idx++] = sub2[p2++];
            }
        }

        while (p1 < sub1.length) {
            arr[idx++] = sub1[p1++];
        }

        while (p2 < sub2.length) {
            arr[idx++] = sub2[p2++];
        }
    }

    private static int[] copyArr(int[] arr, int start, int end) {
        int[] res = new int[end - start];
        int idx = 0;
        for (int i = start; i < end; i++) {
            res[idx++] = arr[i];
        }
        return res;
    }


    private static void quickSort(int[] arr, int l, int r) {
        if (l < r) {
            int s = partition(arr, l, r);
            quickSort(arr, l, s);
            quickSort(arr, s + 1, r);
        }
    }

    private static int partition(int[] arr, int l, int r) {
        int pivot = arr[l];
        int p1 = l;
        int p2 = r;
        while (true) {
            while (arr[p1] < pivot) {
                p1++;
            }
            while (arr[p2] > pivot) {
                p2--;
            }
            if (p1 >= p2) {
                return p2;
            }
            int tmp = arr[p1];
            arr[p1] = arr[p2];
            arr[p2] = tmp;
            p1++;
            p2--;
        }
    }

    public static void main(String[] args) {
        int[] a = generate();
        System.out.println(Arrays.toString(Arrays.stream(a).toArray()));
        mergeSort(a);
        System.out.println(Arrays.toString(Arrays.stream(a).toArray()));
        int[] b = new int[]{3, 5, 1, 7, 9, 4, 2};
        System.out.println(Arrays.toString(Arrays.stream(b).toArray()));
        quickSort(b, 0, 6);
        System.out.println(Arrays.toString(Arrays.stream(b).toArray()));
    }
}

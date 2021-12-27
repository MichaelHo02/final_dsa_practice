package w7.p1;

import java.util.Arrays;

public class ArraySort {
    static int START = 5;
    static int RANGE = 10;//_000_000;
    // Generate random number
    private static int[] generate(int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = (int) (Math.random() * (RANGE - START) + 1 + START);
        }
        return arr;
    }

    private static void sort(int[] arr) {
        int[] aux = new int[(RANGE - START) + 1];
        for (int i = 0; i < arr.length; i++) {
            aux[arr[i] - START]++;
        }
//        int cur = 0;
//        for (int i = 0; i < aux.length; i++) {
//            if (aux[i] == 0) continue;
//            for (int j = 0; j < aux[i]; j++) {
//                arr[cur++] = i;
//            }
//        }
        int idx = 0;
        for (int i = 0; i < RANGE - START; i++) {
            Arrays.fill(arr, idx, idx + aux[i], i + START);
            idx += aux[i];
        }
    }

    public static void main(String[] args) {
        int[] arr = generate(10);
        int[] test = Arrays.copyOf(arr, arr.length);

        printArray(arr);
        long startTime = System.currentTimeMillis();
        sort(arr);
        long endTime = System.currentTimeMillis();
        printArray(arr);
        System.out.println((endTime - startTime) + " milli seconds");

        System.out.println("///////////////////////////////////////////");

        printArray(test);
        startTime = System.currentTimeMillis();
        java.util.Arrays.sort(test);
        endTime = System.currentTimeMillis();
        printArray(test);
        System.out.println((endTime - startTime) + " milli seconds");
    }

    private static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}

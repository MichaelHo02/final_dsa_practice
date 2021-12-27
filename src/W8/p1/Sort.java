package W8.p1;

import java.util.Arrays;

public class Sort {
    private static final int SIZE = 5;

    private static int[] generate() {
        int[] arr = new int[SIZE];
        for (int i = 0; i < SIZE; i++) {
            arr[i] = (int) (Math.random() * SIZE * 100 + 1);
        }
        return arr;
    }

    private static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[minIndex] > arr[j]) {
                    minIndex = j;
                }
            }
            int tmp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = tmp;
        }
    }

    private static void bubbleSort(int[] arr) {
        boolean isSwap = false;
        for (int last = arr.length; last > 1; last--) {
            for (int i = 1; i < last; i++) {
                if (arr[i] < arr[i - 1]) {
                    int tmp = arr[i];
                    arr[i] = arr[i - 1];
                    arr[i - 1] = tmp;
                    isSwap = true;
                }
            }
            if (!isSwap) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] a = generate();
        int[] b = generate();
        System.out.println(Arrays.toString(Arrays.stream(a).toArray()));
        selectionSort(a);
        System.out.println(Arrays.toString(Arrays.stream(a).toArray()));
        System.out.println("||||||||||||||");
        System.out.println(Arrays.toString(Arrays.stream(b).toArray()));
        selectionSort(b);
        System.out.println(Arrays.toString(Arrays.stream(b).toArray()));


    }
}

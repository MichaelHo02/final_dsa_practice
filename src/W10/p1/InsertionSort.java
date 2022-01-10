package W10.p1;

public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = {5, 3, 2, 4, 1};
        print(arr);
        sort(arr);
    }

    private static void sort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int value = arr[i];
            // find the correct location of value
            int idx = getLocation(arr, i - 1, value);
            // shift all elements from idx to (i-1) one step to the right
            for (int j = i - 1; j >= idx; j--) {
                arr[j + 1] = arr[j];
            }
            arr[idx] = value;
            print(arr);
        }
    }

    private static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (i + 1 == arr.length) {
                System.out.println(arr[i]);
            } else {
                System.out.print(arr[i] + ",");
            }
        }
    }

    private static int getLocation(int[] arr, int r, int value) {
        int l = 0;
        while (l < r) {
            int mid = (l + r) / 2;
            if (arr[mid] <= value) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        if (arr[l] > value) {
            return l;
        }
        return l + 1;
    }
}

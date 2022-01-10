package W11.p1;

import java.util.Arrays;
import java.util.Stack;

public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        int[] arr = {5, 2, 3, 9, 6, 7, 8};
        int[] result = longestIncreasingSubsequence(arr);
        print(result);
    }

    private static void print(int[] result) {
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }

    private static int[] longestIncreasingSubsequence(int[] arr) {
        int n = arr.length;
        int[] dp = new int[n];
        int[] preElement = new int[n];

        Arrays.fill(dp, 1);
        Arrays.fill(preElement, -1);

        int maxEnd = 0;
        for (int current = 1; current < n; current++) {
            for (int previous = 0; previous < current; previous++) {
                if (arr[previous] < arr[current]) {
                    if (dp[previous] + 1 > dp[current]) {
                        dp[current] = dp[previous] + 1;
                        preElement[current] = previous;
                    }
                }
            }
            if (dp[current] > dp[maxEnd]) {
                maxEnd = current;
            }
        }

        Stack<Integer> stack = new Stack<>();
        do {
            stack.push(arr[maxEnd]);
            maxEnd = preElement[maxEnd];
        } while (maxEnd != -1);

        int[] result = new int[stack.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = stack.pop();
        }

        return result;
    }


}

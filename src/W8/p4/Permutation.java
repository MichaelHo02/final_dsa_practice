package W8.p4;

import java.util.Arrays;
import java.util.Stack;

public class Permutation {
    public static void main(String[] args) {
        char[] arr = new char[]{'A', 'B', 'C'};
        Stack<Character> stack = new Stack<>();
        generate(stack, arr, 0);
    }

    private static void generate(Stack<Character> stack, char[] arr, int n) {
        if (stack.size() == arr.length + n) {
            System.out.println(Arrays.toString(stack.toArray()));
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            char[] tmp = new char[arr.length - 1];
            int idx = 0;
            for (int j = 0; j < arr.length; j++) {
                if (j != i) {
                    tmp[idx++] = arr[j];
                }
            }
            stack.push(arr[i]);
            generate(stack, tmp, n + 1);
            stack.pop();
        }
    }
}

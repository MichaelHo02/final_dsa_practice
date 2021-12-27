package W8.p3;

import java.util.Arrays;
import java.util.Stack;

public class SubsetArray {
    public static void main(String[] args) {
        char[] arr = new char[]{'A', 'B', 'C'};
        Stack<Character> stack = new Stack<>();
        buildSub(stack, arr, 0);
    }


    private static void buildSub(Stack<Character> stack, char[] arr, int idx) {
        if (arr.length == idx) {
            System.out.println(Arrays.toString(stack.toArray()));
            return;
        }
        buildSub(stack, arr, idx + 1);

        stack.push(arr[idx]);
        buildSub(stack, arr, idx + 1);
        stack.pop();
    }
}

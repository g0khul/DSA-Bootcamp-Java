package Problems;

import java.util.*;

public class FirstGreatestNum {

    public static void firstGreatestInteger(int arr[]) {

        int result[] = new int[arr.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = result.length - 1; i >= 0; i--) {

            if (!stack.isEmpty()) {
                while (!stack.isEmpty() && stack.peek() <= arr[i]) {
                    stack.pop();
                }
            }

            if (stack.isEmpty()) {
                result[i] = -1;
            } else {
                result[i] = stack.peek();
            }

            stack.push(arr[i]);
        }
        for (int i : result)
            System.out.print(i + " ");
        System.out.println();

    }

    public static void main(String[] args) {

        int arr[] = { 4, 7, 3, 4, 8, 1 };
        firstGreatestInteger(arr);

    }
}

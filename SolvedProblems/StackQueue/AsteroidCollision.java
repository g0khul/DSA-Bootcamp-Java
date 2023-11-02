package SolvedProblems.StackQueue;

import java.util.Arrays;
import java.util.Stack;

public class AsteroidCollision {
    public static void main(String[] args) {
        int[] asteroids = { -2, -1, 1, 2 };
        System.out.println(Arrays.toString(asteroidCollision(asteroids)));
    }

    public static int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for (int n : asteroids) {
            boolean flag = true;
            while (!stack.isEmpty() && n < 0 && stack.peek() > 0) {
                if (Math.abs(n) > Math.abs(stack.peek())) {
                    stack.pop();
                } else if (Math.abs(n) < Math.abs(stack.peek())) {
                    flag = false;
                    break;
                } else {
                    stack.pop();
                    flag = false;
                    break;
                }
            }
            if (flag) {
                stack.push(n);
            }
        }

        int[] result = new int[stack.size()];
        for (int index = result.length - 1; index >= 0; index--) {
            result[index] = stack.pop();
        }

        return result;
    }
}

package StackQueue;

import java.util.Stack;

public class GameOfTwoStacks {
    public static void main(String[] args) {
        Stack<Integer> a = new Stack<>();
        Stack<Integer> b = new Stack<>();
        int maxSum = 12;

        for (int i = 0; i < 5; i++) {
            a.push(5 - i);
        }

        for (int i = 6; i < 10; i++) {
            b.push(i);
        }

        System.out.println(a.toString());
        System.out.println(b.toString());

        int count = getMaxCount(a, b, 0, 0, maxSum) - 1;

        System.out.println(count);

    }

    private static int getMaxCount(Stack<Integer> a, Stack<Integer> b, int sum, int count, int maxSum) {
        if (sum > maxSum) {
            return count;
        }

        if(a.empty() || b.empty()){
            return count;
        }
        int take;
        int count1 = 0;
        int count2 = 0;

        // Take from 'a' stack
        take = a.pop();
        count1 = getMaxCount(a, b, sum + take, count + 1, maxSum);
        a.push(take);

        // Take from 'b' stack
        take = b.pop();
        count2 = getMaxCount(a, b, sum + take, count + 1, maxSum);
        b.push(take);

        count = (count1 > count2) ? count1 : count2;

        return count;
    }
}

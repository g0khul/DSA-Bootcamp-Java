// package DynamicProgramming;

import java.util.Arrays;

public class ClimbingStairs {
    public static void main(String[] args) {
        int n = 3;
        System.out.println(climbStairs(n));
    }

    public static int climbStairs(int n) {
        // if (n <= 1) {
        // return 1;
        // }

        // int left = climbStairs(n - 1);
        // int right = climbStairs(n - 2);

        // return left + right;

        // int[] dp = new int[n + 1];
        // Arrays.fill(dp, -1);
 
        // return helper(n, dp);

        int previous = 1;
        int secondPrevious = 1;

        for (int i = 2; i < n + 1; i++) {
            int current = previous + secondPrevious;
            secondPrevious = previous;
            previous = current;
        }

        return previous;
    }

    public static int helper(int n, int[] dp) {
        if (n <= 1) {
            return 1;
        }

        if (dp[n] != -1) {
            return dp[n];
        }

        dp[n] = helper(n - 1, dp) + helper(n - 2, dp);

        return dp[n];
    }
}

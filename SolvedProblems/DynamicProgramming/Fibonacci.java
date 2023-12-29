// package DynamicProgramming;

import java.util.Arrays;

public class Fibonacci {
    public static void main(String[] args) {
        int n = 5;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        int fib = fibonacci(n, dp);
        System.out.println(fib);
    }

    public static int fibonacci(int n, int[] dp){
        if(n <= 1){
            return n;
        }

        if(dp[n] != -1){
            return dp[n];
        }

        dp[n] = fibonacci(n - 1, dp) + fibonacci(n - 2, dp);

        return dp[n];
    }
}

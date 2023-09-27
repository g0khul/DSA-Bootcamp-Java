package Recursion;

import java.util.Arrays;

public class PerfectSquares {
    // public static int numSquares(int n) {
    // if (n == 1) {
    // return 1;
    // }

    // int limit = (int) Math.sqrt(n);
    // ArrayList<Integer> sqrt = new ArrayList<>();

    // for (int i = 1; i <= limit; i++) {
    // int sqr = i * i;
    // if (sqr <= n) {
    // sqrt.add(sqr);
    // } else {
    // break;
    // }
    // }

    // return helper(sqrt, n, 0, Integer.MAX_VALUE);

    // }

    // private static int helper(ArrayList<Integer> sqrt, int n, int size, int
    // minSize) {
    // if (n == 0) {
    // return (size < minSize) ? size : minSize;
    // }

    // if (n < 0) {
    // return minSize;
    // }

    // for (int i = 0; i < sqrt.size(); i++) {
    // minSize = helper(sqrt, n - sqrt.get(i), size + 1, minSize);
    // }

    // return minSize;
    // }

    public static int numSquares(int n) {
        if (n <= 0) {
            return 0;
        }

        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(numSquares(51));
    }
}

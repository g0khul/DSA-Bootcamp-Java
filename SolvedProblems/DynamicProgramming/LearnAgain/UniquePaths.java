// https://leetcode.com/problems/unique-paths/description/

import java.util.Arrays;

public class UniquePaths {
    public static void main(String[] args) {
        int m = 3;
        int n = 7;
        System.out.println(uniquePathsWithRecursion(m, n));
        System.out.println(uniquePathsWithMemoization(m, n));
        System.out.println(uniquePathsWithDP(m, n));
        System.out.println(uniquePathsWithSpaceOptimization(m, n));

    }

    public static int uniquePathsWithRecursion(int m, int n) {
        if (m == 1 && n == 1) {
            return 1;
        }

        if (m <= 0 || n <= 0) {
            return 0;
        }

        int up = uniquePathsWithRecursion(m - 1, n);
        int left = uniquePathsWithRecursion(m, n - 1);

        return up + left;
    }

    public static int uniquePathsWithMemoization(int m, int n) {
        int[][] memo = new int[m][n];
        for (int[] is : memo) {
            Arrays.fill(is, -1);
        }

        return helper(m - 1, n - 1, memo);
    }

    public static int helper(int m, int n, int[][] memo) {
        if (m == 0 && n == 0) {
            return memo[m][n] = 1;
        }

        if (m < 0 || n < 0) {
            return 0;
        }

        if (memo[m][n] != -1) {
            return memo[m][n];
        }

        int left = helper(m, n - 1, memo);
        int right = helper(m - 1, n, memo);

        return memo[m][n] = left + right;
    }

    public static int uniquePathsWithDP(int m, int n) {
        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = 1;
                } else {
                    int up = 0;
                    int left = 0;
                    if (i > 0)
                        up = dp[i - 1][j];
                    if (j > 0)
                        left = dp[i][j - 1];
                    dp[i][j] = up + left;
                }
            }
        }

        return dp[m - 1][n - 1];
    }

    public static int uniquePathsWithSpaceOptimization(int m, int n) {
        int[] dp = new int[n];

        for (int i = 0; i < m; i++) {
            int[] temp = new int[n];
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    temp[j] = 1;
                } else {
                    int up = 0;
                    int left = 0;
                    if (i > 0)
                        up = dp[j];
                    if (j > 0)
                        left = temp[j - 1];
                    temp[j] = up + left;
                }
            }
            dp = temp;
        }

        return dp[n - 1];
    }
}

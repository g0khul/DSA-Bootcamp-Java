import java.util.Arrays;

public class RodCuttingProblem {
    public static void main(String[] args) {
        int[] price = { 2, 5, 7, 8, 10 };
        int n = 5;
        System.out.println(cutRodRecursion(price, n));
        System.out.println(cutRodMemoization(price, n));
        System.out.println(cutRodDp(price, n));
        System.out.println(cutRodSpaceOptimization(price, n));
        System.out.println(cutRod1DSpaceOptimization(price, n));
    }

    public static int cutRodRecursion(int[] price, int n) {
        return helperRecursion(price, n, price.length - 1);
    }

    public static int helperRecursion(int[] price, int n, int index) {
        if (index == 0) {
            return n * price[index];
        }

        int leaveIt = helperRecursion(price, n, index - 1);
        int takeIt = Integer.MIN_VALUE;
        if (n - (index + 1) >= 0) {
            takeIt = price[index] + helperRecursion(price, n - (index + 1), index);
        }

        return Math.max(leaveIt, takeIt);
    }

    public static int cutRodMemoization(int[] price, int n) {
        int[][] memo = new int[price.length][n + 1];
        for (int[] is : memo) {
            Arrays.fill(is, -1);
        }

        return helperMemoization(price, n, price.length - 1, memo);
    }

    public static int helperMemoization(int[] price, int n, int index, int[][] memo) {
        if (index == 0) {
            return n * price[index];
        }

        if (memo[index][n] != -1) {
            return memo[index][n];
        }

        int leaveIt = helperMemoization(price, n, index - 1, memo);
        int takeIt = Integer.MIN_VALUE;
        if (n - (index + 1) >= 0) {
            takeIt = price[index] + helperMemoization(price, n - (index + 1), index, memo);
        }

        return memo[index][n] = Math.max(leaveIt, takeIt);
    }

    public static int cutRodDp(int[] price, int N) {
        int[][] dp = new int[price.length][N + 1];
        for (int n = 0; n <= N; n++) {
            dp[0][n] = n * price[0];
        }

        for (int index = 1; index < price.length; index++) {
            for (int n = 0; n <= N; n++) {
                int leaveIt = dp[index - 1][n];
                int takeIt = Integer.MIN_VALUE;
                if (n - (index + 1) >= 0) {
                    takeIt = price[index] + dp[index][n - (index + 1)];
                }
                dp[index][n] = Math.max(leaveIt, takeIt);
            }
        }

        return dp[price.length - 1][N];
    }

    public static int cutRodSpaceOptimization(int[] price, int N) {
        int[] prev = new int[N + 1];
        for (int n = 0; n <= N; n++) {
            prev[n] = n * price[0];
        }

        for (int index = 1; index < price.length; index++) {
            int[] curr = new int[N + 1];
            for (int n = 0; n <= N; n++) {
                int leaveIt = prev[n];
                int takeIt = Integer.MIN_VALUE;
                if (n - (index + 1) >= 0) {
                    takeIt = price[index] + curr[n - (index + 1)];
                }
                curr[n] = Math.max(leaveIt, takeIt);
            }
            prev = curr;
        }

        return prev[N];
    }

    public static int cutRod1DSpaceOptimization(int[] price, int N) {
        int[] dp = new int[N + 1];
        for (int n = 0; n <= N; n++) {
            dp[n] = n * price[0];
        }

        for (int index = 1; index < price.length; index++) {
            for (int n = 0; n <= N; n++) {
                int leaveIt = dp[n];
                int takeIt = Integer.MIN_VALUE;
                if (n - (index + 1) >= 0) {
                    takeIt = price[index] + dp[n - (index + 1)];
                }
                dp[n] = Math.max(leaveIt, takeIt);
            }
        }

        return dp[N];
    }
}

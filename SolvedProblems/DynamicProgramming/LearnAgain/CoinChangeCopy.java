import java.util.Arrays;

public class CoinChangeCopy {
    public static void main(String[] args) {
        int[] coins = { 1, 2, 5 };
        int amount = 11;
        System.out.println(coinChangeRecursion(coins, amount));
        System.out.println(coinChangeMemiozation(coins, amount));
        System.out.println(coinChangeDp(coins, amount));
        System.out.println(coinChangeSpaceOptimization(coins, amount));
    }

    public static int coinChangeRecursion(int[] coins, int amount) {
        int minCoins = helperRecursion(coins, amount, coins.length - 1);
        return minCoins == Integer.MAX_VALUE ? -1 : minCoins;
    }

    public static int helperRecursion(int[] coins, int amount, int index) {
        if (index == 0) {
            return (amount % coins[index] == 0) ? amount / coins[index] : Integer.MAX_VALUE;
        }

        int leaveIt = helperRecursion(coins, amount, index - 1);
        int takeIt = Integer.MAX_VALUE;
        if (amount - coins[index] >= 0) {
            takeIt = helperRecursion(coins, amount - coins[index], index);
            if (takeIt != Integer.MAX_VALUE) {
                takeIt += 1;
            }
        }

        return Math.min(leaveIt, takeIt);
    }

    public static int coinChangeMemiozation(int[] coins, int amount) {
        int[][] memo = new int[coins.length][amount + 1];
        for (int[] is : memo) {
            Arrays.fill(is, -1);
        }

        int minCoins = helperMemoization(coins, coins.length - 1, amount, memo);
        return minCoins == Integer.MAX_VALUE ? -1 : minCoins;
    }

    public static int helperMemoization(int[] coins, int index, int amount, int[][] memo) {
        if (index == 0) {
            return (amount % coins[index] == 0) ? amount / coins[index] : Integer.MAX_VALUE;
        }

        if (memo[index][amount] != -1) {
            return memo[index][amount];
        }

        int leaveIt = helperMemoization(coins, index - 1, amount, memo);
        int takeIt = Integer.MAX_VALUE;
        if (amount - coins[index] >= 0) {
            takeIt = helperMemoization(coins, index, amount - coins[index], memo);
            if (takeIt != Integer.MAX_VALUE) {
                takeIt += 1;
            }
        }

        return memo[index][amount] = Math.min(leaveIt, takeIt);
    }

    public static int coinChangeDp(int[] coins, int A) {
        int[][] dp = new int[coins.length][A + 1];
        for (int amount = 0; amount <= A; amount++) {
            dp[0][amount] = (amount % coins[0] == 0) ? amount / coins[0] : A + 1;
        }

        for (int index = 1; index < coins.length; index++) {
            for (int amount = 0; amount <= A; amount++) {
                int leaveIt = dp[index - 1][amount];
                int takeIt = A + 1;
                if (amount - coins[index] >= 0) {
                    takeIt = 1 + dp[index][amount - coins[index]];
                }
                dp[index][amount] = Math.min(leaveIt, takeIt);
            }
        }

        return dp[coins.length - 1][A] == A + 1 ? -1 : dp[coins.length - 1][A];
    }

    public static int coinChangeSpaceOptimization(int[] coins, int A) {
        int[] prev = new int[A + 1];
        for (int amount = 0; amount <= A; amount++) {
            prev[amount] = (amount % coins[0] == 0) ? amount / coins[0] : A + 1;
        }

        for (int index = 1; index < coins.length; index++) {
            int[] curr = new int[A + 1];
            for (int amount = A; amount >= 0; amount--) {
                int leaveIt = prev[amount];
                int takeIt = A + 1;
                if (amount - coins[index] >= 0) {
                    takeIt = 1 + curr[amount - coins[index]];
                }
                curr[amount] = Math.min(leaveIt, takeIt);
            }
            prev = curr;
        }

        return prev[A] == A + 1 ? -1 : prev[A];
    }
}

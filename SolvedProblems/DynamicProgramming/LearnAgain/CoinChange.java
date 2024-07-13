import java.util.Arrays;

public class CoinChange {
    public static void main(String[] args) {
        int[] coins = { 2, 5, 10, 1 };
        int amount = 27;
        System.out.println(coinChangeRecursion(coins, amount));
        System.out.println(coinChangeMemiozation(coins, amount));
        System.out.println(coinChangeDp(coins, amount));
    }

    public static int coinChangeRecursion(int[] coins, int amount) {
        int minCoins = helperRecursion(coins, amount, coins.length - 1);
        return minCoins == Integer.MAX_VALUE ? -1 : minCoins;
    }

    public static int helperRecursion(int[] coins, int amount, int index) {
        if (amount < 0 || index < 0) {
            return Integer.MAX_VALUE;
        }

        if (amount == 0) {
            return 0;
        }

        int minCoins = Integer.MAX_VALUE;
        for (int i = index; i >= 0; i--) {
            if (amount - coins[i] >= 0) {
                int currCoins = helperRecursion(coins, amount - coins[i], i);
                if (currCoins != Integer.MAX_VALUE) {
                    minCoins = Math.min(minCoins, currCoins + 1);
                }
            }
        }

        return minCoins;
    }

    public static int coinChangeMemiozation(int[] coins, int amount) {
        int[][] memo = new int[coins.length][amount + 1];
        for (int[] is : memo) {
            Arrays.fill(is, -1);
        }

        int minCoins = helperMemoization(coins, amount, coins.length - 1, memo);
        return minCoins == Integer.MAX_VALUE ? -1 : minCoins;
    }

    public static int helperMemoization(int[] coins, int amount, int index, int[][] memo) {
        if (amount < 0 || index < 0) {
            return Integer.MAX_VALUE;
        }

        if (amount == 0) {
            return 0;
        }

        if (memo[index][amount] != -1) {
            return memo[index][amount];
        }

        int minCoins = Integer.MAX_VALUE;
        for (int i = index; i >= 0; i--) {
            if (amount - coins[i] >= 0) {
                int currCoins = helperMemoization(coins, amount - coins[i], i, memo);
                if (currCoins != Integer.MAX_VALUE) {
                    minCoins = Math.min(minCoins, currCoins + 1);
                }
            }
        }

        return memo[index][amount] = minCoins;
    }

    public static int coinChangeDp(int[] coins, int A) {
        int[][] dp = new int[coins.length][A + 1];
        for (int target = 0; target < dp[0].length; target++) {
            if (coins[0] <= A && A % coins[0] == 0) {
                dp[0][target] = A / coins[0];
            } else {
                dp[0][target] = Integer.MAX_VALUE;
            }
        }

        for (int index = 1; index < coins.length; index++) {
            for (int amount = 0; amount <= A; amount++) {
                int minCoins = Integer.MAX_VALUE;
                for (int i = index; i >= 0; i--) {
                    if (amount - coins[i] >= 0) {
                        int currCoins = dp[i][amount - coins[i]];
                        if (currCoins != Integer.MAX_VALUE) {
                            minCoins = Math.min(minCoins, currCoins + 1);
                        }
                    }
                }
                dp[index][amount] = minCoins;
            }
        }

        return dp[coins.length - 1][A];
    }
}

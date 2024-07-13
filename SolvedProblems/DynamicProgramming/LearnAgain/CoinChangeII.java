import java.lang.reflect.Array;
import java.util.Arrays;

public class CoinChangeII {
    public static void main(String[] args) {
        int[] coins = { 1, 2, 5 };
        int amount = 5;
        System.out.println(changeRecursion(amount, coins));
        System.out.println(changeMemoization(amount, coins));
        System.out.println(coinChangeDp(amount, coins));
        System.out.println(coinChangeSpaceOptimization(amount, coins));
    }

    public static int changeRecursion(int amount, int[] coins) {
        return helperRecursion(amount, coins.length - 1, coins);
    }

    public static int helperRecursion(int amount, int index, int[] coins) {
        if (index == 0) {
            return amount % coins[index] == 0 ? 1 : 0;
        }

        int leaveIt = helperRecursion(amount, index - 1, coins);
        int takeIt = 0;
        if (amount - coins[index] >= 0) {
            takeIt = helperRecursion(amount - coins[index], index, coins);
        }

        return takeIt + leaveIt;
    }

    public static int changeMemoization(int amount, int[] coins) {
        int[][] memo = new int[coins.length][amount + 1];
        for (int[] is : memo) {
            Arrays.fill(is, -1);
        }

        return helperMemoization(coins.length - 1, amount, coins, memo);
    }

    public static int helperMemoization(int index, int amount, int[] coins, int[][] memo) {
        if (index == 0) {
            return amount % coins[index] == 0 ? 1 : 0;
        }

        if (memo[index][amount] != -1) {
            return memo[index][amount];
        }

        int leaveIt = helperMemoization(index - 1, amount, coins, memo);
        int takeIt = 0;
        if (amount - coins[index] >= 0) {
            takeIt = helperMemoization(index, amount - coins[index], coins, memo);
        }

        return memo[index][amount] = takeIt + leaveIt;
    }

    public static int coinChangeDp(int A, int[] coins) {
        int[][] dp = new int[coins.length][A + 1];
        for (int amount = 0; amount <= A; amount++) {
            dp[0][amount] = amount % coins[0] == 0 ? 1 : 0;
        }

        for (int index = 1; index < coins.length; index++) {
            for (int amount = 0; amount <= A; amount++) {
                int leaveIt = dp[index - 1][amount];
                int takeIt = 0;
                if (amount - coins[index] >= 0) {
                    takeIt = dp[index][amount - coins[index]];
                }
                dp[index][amount] = takeIt + leaveIt;
            }
        }

        return dp[coins.length - 1][A];
    }

    public static int coinChangeSpaceOptimization(int A, int[] coins) {
        int[] prev = new int[A + 1];
        for (int amount = 0; amount <= A; amount++) {
            prev[amount] = amount % coins[0] == 0 ? 1 : 0;
        }

        for (int index = 1; index < coins.length; index++) {
            int[] curr = new int[A + 1];
            for (int amount = 0; amount <= A; amount++) {
                int leaveIt = prev[amount];
                int takeIt = 0;
                if (amount - coins[index] >= 0) {
                    takeIt = curr[amount - coins[index]];
                }
                curr[amount] = takeIt + leaveIt;
            }
            prev = curr;
        }

        return prev[A];
    }
}

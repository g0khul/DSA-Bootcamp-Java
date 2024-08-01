import java.util.Arrays;

public class BestTimeToBuyAndSellStockWithTransactionFee {
    public static void main(String[] args) {
        int[] prices = { 1, 3, 2, 8, 4, 9 };
        int fee = 2;
        System.out.println(maxProfitDp(prices, fee));
        System.out.println(maxProfitSpaceOptimization(prices, fee));
    }

    public static int maxProfitDp(int[] prices, int fee) {
        int n = prices.length;
        int[][] dp = new int[n + 1][2];
        dp[n - 1][0] = +prices[n - 1] - fee;
        dp[n - 1][1] = 0;

        for (int index = n - 2; index >= 0; index--) {
            for (int canBuy = 1; canBuy >= 0; canBuy--) {
                int profit = Integer.MIN_VALUE;
                if (canBuy == 1) {
                    int buyIt = -prices[index] + dp[index + 1][0];
                    int notbuyIt = 0 + dp[index + 1][1];
                    profit = Math.max(buyIt, notbuyIt);
                } else {
                    int sellIt = +prices[index] + dp[index + 1][1] - fee;
                    int notSellIt = 0 + dp[index + 1][0];
                    profit = Math.max(sellIt, notSellIt);
                }
                dp[index][canBuy] = profit;
            }
        }

        return dp[0][1];
    }

    public static int maxProfitSpaceOptimization(int[] prices, int fee) {
        int n = prices.length;
        int[] next = new int[2];
        next[0] = +prices[n - 1] - fee;
        next[1] = 0;

        for (int index = n - 1; index >= 0; index--) {
            int[] curr = new int[2];
            curr[1] = Math.max(-prices[index] + next[0], 0 + next[1]);
            curr[0] = Math.max(+prices[index] - fee + next[1], 0 + next[0]);
            next = curr;
        }

        return next[1];
    }
}

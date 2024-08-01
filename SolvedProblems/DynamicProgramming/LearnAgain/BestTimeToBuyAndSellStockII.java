import java.util.Arrays;

public class BestTimeToBuyAndSellStockII {
    public static void main(String[] args) {
        int[] prices = { 7, 1, 5, 3, 6, 4 };
        System.out.println(maxProfitRecursion(prices));
        System.out.println(maxProfitMemoization(prices));
        System.out.println(maxProfitDp(prices));
        System.out.println(maxProfitSpaceOptimization(prices));
        // space optimization 2 vars
        System.out.println(maxProfit2VariableSpaceOptimization(prices));
    }

    public static int maxProfitRecursion(int[] prices) {
        return helperRecursion(prices, 0, true);
    }

    public static int helperRecursion(int[] prices, int index, boolean canBuy) {
        if (index == prices.length - 1) {
            if (canBuy) {
                return 0;
            }
            return prices[index];
        }

        int profit = Integer.MIN_VALUE;
        if (canBuy) {
            int buyIt = -prices[index] + helperRecursion(prices, index + 1, !canBuy);
            int notBuyIt = 0 + helperRecursion(prices, index + 1, canBuy);
            profit = Math.max(buyIt, notBuyIt);
        } else {
            int sellIt = +prices[index] + helperRecursion(prices, index + 1, !canBuy);
            int notSellIt = 0 + helperRecursion(prices, index + 1, canBuy);
            profit = Math.max(sellIt, notSellIt);
        }

        return profit;
    }

    public static int maxProfitMemoization(int[] prices) {
        int[][] memo = new int[prices.length + 1][2 + 1];
        for (int[] is : memo) {
            Arrays.fill(is, -1);
        }

        return helperMemoization(prices, 0, 1, memo);
    }

    public static int helperMemoization(int[] prices, int index, int canBuy, int[][] memo) {
        if (index == prices.length - 1) {
            if (canBuy == 1) {
                return 0;
            }
            return prices[index];
        }

        if (memo[index][canBuy] != -1) {
            return memo[index][canBuy];
        }

        int profit = Integer.MIN_VALUE;
        if (canBuy == 1) {
            int buyIt = -prices[index] + helperMemoization(prices, index + 1, 0, memo);
            int notBuyIt = 0 + helperMemoization(prices, index + 1, canBuy, memo);
            profit = Math.max(notBuyIt, buyIt);
        } else {
            int sellIt = +prices[index] + helperMemoization(prices, index + 1, 1, memo);
            int notSellIt = 0 + helperMemoization(prices, index + 1, canBuy, memo);
            profit = Math.max(sellIt, notSellIt);
        }

        return memo[index][canBuy] = profit;
    }

    public static int maxProfitDp(int[] prices) {
        int n = prices.length - 1;
        int m = 2;
        int[][] dp = new int[n + 1][m];
        dp[prices.length - 1][0] = prices[n];
        dp[prices.length - 1][1] = 0;

        for (int index = n - 1; index >= 0; index--) {
            for (int canBuy = 0; canBuy < m; canBuy++) {
                int profit = Integer.MIN_VALUE;
                if (canBuy == 1) {
                    int buyIt = -prices[index] + dp[index + 1][0];
                    int notBuyIt = 0 + dp[index + 1][1];
                    profit = Math.max(buyIt, notBuyIt);
                } else {
                    int sellIt = +prices[index] + dp[index + 1][1];
                    int notSellIt = 0 + dp[index + 1][0];
                    profit = Math.max(sellIt, notSellIt);
                }
                dp[index][canBuy] = profit;
            }
        }

        for (int[] is : dp) {
            System.out.println(Arrays.toString(is));
        }

        return dp[1][1];
    }

    public static int maxProfitSpaceOptimization(int[] prices) {
        int n = prices.length - 1;
        int m = 2;
        int[] prev = new int[m];
        prev[0] = prices[n];
        prev[1] = 0;

        for (int index = n - 1; index >= 0; index--) {
            int[] curr = new int[m];
            for (int canBuy = 0; canBuy < m; canBuy++) {
                int profit = Integer.MIN_VALUE;
                if (canBuy == 1) {
                    int buyIt = -prices[index] + prev[0];
                    int notBuyIt = 0 + prev[1];
                    profit = Math.max(buyIt, notBuyIt);
                } else {
                    int sellIt = +prices[index] + prev[1];
                    int notSellIt = 0 + prev[0];
                    profit = Math.max(sellIt, notSellIt);
                }
                curr[canBuy] = profit;
            }
            prev = curr;
        }

        return prev[1];
    }

    public static int maxProfit2VariableSpaceOptimization(int[] prices) {
        int n = prices.length - 1;
        int m = 2;
        int canBuy = 0;
        int cannotBuy = prices[n];

        for (int index = n - 1; index >= 0; index--) {
            for (int buy = 0; buy < m; buy++) {
                int profit = Integer.MIN_VALUE;
                if (buy == 1) {
                    profit = Math.max(-prices[index] + cannotBuy, 0 + canBuy);
                    canBuy = profit;
                } else {
                    profit = Math.max(+prices[index] + canBuy, 0 + cannotBuy);
                    cannotBuy = profit;
                }
            }
        }

        return canBuy;
    }
}

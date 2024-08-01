import java.util.Arrays;

public class BestTimeToBuyAndSellStockIII {
    public static void main(String[] args) {
        int[] prices = { 3, 3, 5, 0, 0, 3, 1, 4 };
        System.out.println(maxProfitRecursion(prices));
        System.out.println(maxProfitMemoization(prices));
        System.out.println(maxProfitDp(prices));
        System.out.println(maxProfitSpaceOptimization(prices));
    }

    public static int maxProfitRecursion(int[] prices) {
        return helperRecursion(prices, 0, 1, 2);
    }

    public static int helperRecursion(int[] prices, int index, int canBuy, int transactions) {
        if (transactions == 0) {
            return 0;
        }

        if (index == prices.length - 1) {
            if (canBuy == 1) {
                return 0;
            }
            return prices[index];
        }

        int profit = Integer.MIN_VALUE;
        if (canBuy == 1) {
            int buyIt = -prices[index] + helperRecursion(prices, index + 1, 0, transactions);
            int notBuyIt = 0 + helperRecursion(prices, index + 1, canBuy, transactions);
            profit = Math.max(buyIt, notBuyIt);
        } else {
            int sellIt = +prices[index] + helperRecursion(prices, index + 1, 1, transactions - 1);
            int notSellIt = 0 + helperRecursion(prices, index + 1, canBuy, transactions);
            profit = Math.max(sellIt, notSellIt);
        }

        return profit;
    }

    public static int maxProfitMemoization(int[] prices) {
        int[][][] memo = new int[prices.length][2][3];
        for (int[][] is : memo) {
            for (int[] is2 : is) {
                Arrays.fill(is2, -1);
            }
        }

        return helperMemoization(prices, 0, 1, 2, memo);
    }

    public static int helperMemoization(int[] prices, int index, int canBuy, int transactions, int[][][] memo) {
        if (transactions == 0) {
            return 0;
        }

        if (index == prices.length - 1) {
            if (canBuy == 1) {
                return 0;
            }
            return prices[index];
        }

        if (memo[index][canBuy][transactions] != -1) {
            return memo[index][canBuy][transactions];
        }

        int profit = Integer.MIN_VALUE;
        if (canBuy == 1) {
            int buyIt = -prices[index] + helperMemoization(prices, index + 1, 0, transactions, memo);
            int notBuyIt = 0 + helperMemoization(prices, index + 1, canBuy, transactions, memo);
            profit = Math.max(buyIt, notBuyIt);
        } else {
            int sellIt = +prices[index] + helperMemoization(prices, index + 1, 1, transactions - 1, memo);
            int notSellIt = 0 + helperMemoization(prices, index + 1, canBuy, transactions, memo);
            profit = Math.max(sellIt, notSellIt);
        }

        return memo[index][canBuy][transactions] = profit;
    }

    public static int maxProfitDp(int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n + 1][2][3];

        for (int index = 0; index < dp.length; index++) {
            for (int canBuy = 0; canBuy < dp[index].length; canBuy++) {
                dp[index][canBuy][0] = 0;
            }
        }

        for (int canBuy = 0; canBuy < dp[0].length; canBuy++) {
            for (int transactions = 0; transactions < dp[0][canBuy].length; transactions++) {
                if (canBuy == 1) {
                    dp[n - 1][canBuy][transactions] = 0;
                } else {
                    dp[n - 1][canBuy][transactions] = prices[n - 1];
                }
            }
        }

        for (int index = n - 2; index >= 0; index--) {
            for (int canBuy = 0; canBuy < 2; canBuy++) {
                for (int transactions = 2; transactions > 0; transactions--) {
                    int profit = Integer.MIN_VALUE;
                    if (canBuy == 1) {
                        int buyIt = -prices[index] + dp[index + 1][0][transactions];
                        int notBuyIt = 0 + dp[index + 1][1][transactions];
                        profit = Math.max(buyIt, notBuyIt);
                    } else {
                        int sellIt = +prices[index] + dp[index + 1][1][transactions - 1];
                        int notSellIt = 0 + dp[index + 1][0][transactions];
                        profit = Math.max(sellIt, notSellIt);
                    }
                    dp[index][canBuy][transactions] = profit;
                }
            }
        }

        return dp[0][1][2];
    }

    public static int maxProfitSpaceOptimization(int[] prices) {
        int n = prices.length;
        int[][] next = new int[2][3];
        for (int canBuy = 0; canBuy < next.length; canBuy++) {
            next[canBuy][0] = 0;
        }

        for (int canBuy = 0; canBuy < next.length; canBuy++) {
            for (int transactions = 0; transactions < next[canBuy].length; transactions++) {
                if (canBuy == 1) {
                    next[canBuy][transactions] = 0;
                } else {
                    next[canBuy][transactions] = prices[n - 1];
                }
            }
        }

        for (int index = n - 2; index >= 0; index--) {
            int[][] curr = new int[2][3];
            for (int canBuy = 0; canBuy < 2; canBuy++) {
                for (int transactions = 2; transactions > 0; transactions--) {
                    int profit = Integer.MIN_VALUE;
                    if (canBuy == 1) {
                        int buyIt = -prices[index] + next[0][transactions];
                        int notBuyIt = 0 + next[1][transactions];
                        profit = Math.max(buyIt, notBuyIt);
                    } else {
                        int sellIt = +prices[index] + next[1][transactions - 1];
                        int notSellIt = 0 + next[0][transactions];
                        profit = Math.max(sellIt, notSellIt);
                    }
                    curr[canBuy][transactions] = profit;
                }
            }
            next = curr;
        }

        return next[1][2];
    }
}

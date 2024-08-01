import java.util.Arrays;

public class BestTimeToBuyAndSellStockWithCooldown {
    public static void main(String[] args) {
        int[] prices = { 1, 2, 3, 0, 2 };
        System.out.println(maxProfitRecursion(prices));
        System.out.println(maxProfitDp(prices));
        System.out.println(maxProfitSpaceOptimization(prices));
    }

    public static int maxProfitRecursion(int[] prices) {
        return helperRecursion(prices, 0, 1);
    }

    public static int helperRecursion(int[] prices, int index, int canBuy) {
        if (index == prices.length - 1) {
            if (canBuy == 1) {
                return 0;
            }
            return prices[index];
        }

        if (index > prices.length - 1) {
            return 0;
        }

        int profit = Integer.MIN_VALUE;
        if (canBuy == 1) {
            int buyIt = -prices[index] + helperRecursion(prices, index + 1, 0);
            int notBuyIt = 0 + helperRecursion(prices, index + 1, canBuy);
            profit = Math.max(buyIt, notBuyIt);
        } else {
            int sellIt = +prices[index] + helperRecursion(prices, index + 2, 1);
            int notSellIt = 0 + helperRecursion(prices, index + 1, canBuy);
            profit = Math.max(sellIt, notSellIt);
        }

        return profit;
    }

    public static int maxProfitDp(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n + 1][2];
        dp[prices.length - 1][0] = prices[prices.length - 1];
        dp[prices.length - 1][1] = 0;

        for (int index = n - 2; index >= 0; index--) {
            for (int canBuy = 1; canBuy >= 0; canBuy--) {
                int profit = Integer.MIN_VALUE;
                if (canBuy == 1) {
                    int buyIt = -prices[index] + dp[index + 1][0];
                    int notBuyIt = 0 + dp[index + 1][1];
                    profit = Math.max(buyIt, notBuyIt);
                } else {
                    int sellIt = +prices[index] + dp[index + 2][1];
                    int notSellIt = 0 + dp[index + 1][0];
                    profit = Math.max(sellIt, notSellIt);
                }
                dp[index][canBuy] = profit;
            }
        }

        return dp[0][1];
    }

    public static int maxProfitSpaceOptimization(int[] prices) {
        int n = prices.length;
        int[] front2 = new int[2];
        int[] front1 = new int[2];
        int[] curr = new int[2];

        for (int index = n - 1; index >= 0; index--) {
            curr[1] = Math.max(-prices[index] + front1[0], 0 + front1[1]);
            curr[0] = Math.max(+prices[index] + front2[1], 0 + front1[0]);

            front2 = Arrays.copyOf(front1, 2);
            front1 = Arrays.copyOf(curr, 2);
        }

        return curr[1];
    }
}

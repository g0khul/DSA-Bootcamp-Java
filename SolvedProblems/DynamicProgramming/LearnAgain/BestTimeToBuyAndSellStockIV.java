import java.util.Arrays;

public class BestTimeToBuyAndSellStockIV {
    public static void main(String[] args) {
        int[] prices = { 3, 3, 5, 0, 0, 3, 1, 4 };
        int k = 2;
        // Directly space optimized solution since it's similar to III
        System.out.println(maxProfitSpaceOptimization(k, prices));
    }

    public static int maxProfitSpaceOptimization(int k, int[] prices) {
        int n = prices.length;
        int[][] next = new int[2][k + 1];
        for (int canBuy = 0; canBuy < 2; canBuy++) {
            next[canBuy][0] = 0;
        }

        for (int canBuy = 0; canBuy < 2; canBuy++) {
            for (int transactions = 1; transactions <= k; transactions++) {
                if (canBuy != 1) {
                    next[canBuy][transactions] = prices[n - 1];
                }
            }
        }

        for (int index = n - 2; index >= 0; index--) {
            int[][] curr = new int[2][k + 1];
            for (int canBuy = 0; canBuy < 2; canBuy++) {
                for (int transactions = k; transactions > 0; transactions--) {
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

        return next[1][k];
    }
}

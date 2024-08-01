public class BestTimeToBuyAndSellStock {
    public static void main(String[] args) {
        int[] prices = { 7, 1, 5, 3, 6, 4 };
        System.out.println(maxProfit(prices));
    }

    public static int maxProfit(int[] prices) {
        int profit = 0;
        int min = prices[0];
        for (int i = 1; i < prices.length; i++) {
            int currProfit = prices[i] - min;
            profit = Math.max(currProfit, profit);
            min = Math.min(prices[i], min);
        }

        return profit;
    }
}

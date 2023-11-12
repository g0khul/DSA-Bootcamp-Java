package CPfor100Days.DynamicProgramming;

public class BestTimeToBuyAndSellStock {
    public static void main(String[] args) {
        int[] nums = { 1, 2, 4 };
        System.out.println(maxProfit(nums));
    }

    public static int maxProfit(int[] prices) {
        int max = findMax(prices, 0, prices.length - 1);

        int min = Integer.MAX_VALUE;
        if (max == 0) {
            min = findMin(prices, 1, prices.length - 1);
            if (min == prices.length - 1) {
                return 0;
            }
            max = findMax(prices, min + 1, prices.length - 1);
        } else {
            min = findMin(prices, 0, max - 1);
        }

        return prices[max] - prices[min];
    }

    public static int findMax(int[] prices, int start, int end) {
        if (start >= prices.length) {
            return 0;
        }

        int max = prices[start];
        int index = start;
        for (int i = start; i <= end; i++) {
            if (max < prices[i]) {
                max = prices[i];
                index = i;
            }
        }

        return index;
    }

    public static int findMin(int[] prices, int start, int end) {
        if (start >= prices.length) {
            return 0;
        }

        int min = prices[start];
        int index = start;
        for (int i = start; i <= end; i++) {
            if (min > prices[i]) {
                min = prices[i];
                index = i;
            }
        }

        return index;
    }
}

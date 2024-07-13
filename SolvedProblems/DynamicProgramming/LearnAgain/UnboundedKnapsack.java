import java.util.Arrays;

public class UnboundedKnapsack {
    public static void main(String[] args) {
        int[] weight = { 2, 4, 6 };
        int[] values = { 5, 11, 13 };
        int bagCapacity = 10;
        System.out.println(maxStealRecursion(weight, values, bagCapacity));
        System.out.println(maxStealMemoization(weight, values, bagCapacity));
        System.out.println(maxStealDp(weight, values, bagCapacity));
        System.out.println(maxStealSpaceOptimization(weight, values, bagCapacity));
        System.out.println(maxSteal1DSpaceOptimization(weight, values, bagCapacity));
    }

    public static int maxStealRecursion(int[] weight, int[] values, int bagCapacity) {
        return helperRecursion(weight, values, weight.length - 1, bagCapacity);
    }

    public static int helperRecursion(int[] weight, int[] values, int index, int bagCapacity) {
        if (index == 0) {
            return bagCapacity % weight[index] == 0 ? (bagCapacity / weight[index]) * values[index] : 0;
        }

        int leaveIt = helperRecursion(weight, values, index - 1, bagCapacity);
        int takeIt = Integer.MIN_VALUE;
        if (bagCapacity - weight[index] >= 0) {
            takeIt = values[index] + helperRecursion(weight, values, index, bagCapacity - weight[index]);
        }

        return Math.max(takeIt, leaveIt);
    }

    public static int maxStealMemoization(int[] weight, int[] values, int bagCapacity) {
        int[][] memo = new int[weight.length][bagCapacity + 1];
        for (int[] is : memo) {
            Arrays.fill(is, -1);
        }

        return helperMemoization(weight, values, weight.length - 1, bagCapacity, memo);
    }

    public static int helperMemoization(int[] weight, int[] values, int index, int bagCapacity, int[][] memo) {
        if (index == 0) {
            return bagCapacity % weight[index] == 0 ? (bagCapacity / weight[index]) * values[index] : 0;
        }

        if (memo[index][bagCapacity] != -1) {
            return memo[index][bagCapacity];
        }

        int leaveIt = helperMemoization(weight, values, index - 1, bagCapacity, memo);
        int takeIt = Integer.MIN_VALUE;
        if (bagCapacity - weight[index] >= 0) {
            takeIt = values[index] + helperMemoization(weight, values, index, bagCapacity - weight[index], memo);
        }

        return memo[index][bagCapacity] = Math.max(takeIt, leaveIt);
    }

    public static int maxStealDp(int[] weight, int[] values, int capacity) {
        int[][] dp = new int[weight.length][capacity + 1];
        for (int bagCapacity = 0; bagCapacity <= capacity; bagCapacity++) {
            dp[0][bagCapacity] = bagCapacity % weight[0] == 0 ? (bagCapacity / weight[0]) * values[0] : 0;
        }

        for (int index = 1; index < weight.length; index++) {
            for (int bagCapacity = 0; bagCapacity <= capacity; bagCapacity++) {
                int leaveIt = dp[index - 1][bagCapacity];
                int takeIt = Integer.MIN_VALUE;
                if (bagCapacity - weight[index] >= 0) {
                    takeIt = values[index] + dp[index][bagCapacity - weight[index]];
                }
                dp[index][bagCapacity] = Math.max(takeIt, leaveIt);
            }
        }

        return dp[weight.length - 1][capacity];
    }

    public static int maxStealSpaceOptimization(int[] weight, int[] values, int capacity) {
        int[] prev = new int[capacity + 1];
        for (int bagCapacity = 0; bagCapacity <= capacity; bagCapacity++) {
            prev[bagCapacity] = bagCapacity % weight[0] == 0 ? (bagCapacity / weight[0]) * values[0] : 0;
        }

        for (int index = 1; index < weight.length; index++) {
            int[] curr = new int[capacity + 1];
            for (int bagCapacity = 0; bagCapacity <= capacity; bagCapacity++) {
                int leaveIt = prev[bagCapacity];
                int takeIt = Integer.MIN_VALUE;
                if (bagCapacity - weight[index] >= 0) {
                    takeIt = values[index] + curr[bagCapacity - weight[index]];
                }
                curr[bagCapacity] = Math.max(takeIt, leaveIt);
            }
            prev = curr;
        }

        return prev[capacity];
    }

    public static int maxSteal1DSpaceOptimization(int[] weight, int[] values, int capacity) {
        int[] dp = new int[capacity + 1];
        for (int bagCapacity = 0; bagCapacity <= capacity; bagCapacity++) {
            dp[bagCapacity] = bagCapacity % weight[0] == 0 ? (bagCapacity / weight[0]) * values[0] : 0;
        }

        for (int index = 1; index < weight.length; index++) {
            for (int bagCapacity = 0; bagCapacity <= capacity; bagCapacity++) {
                int leaveIt = dp[bagCapacity];
                int takeIt = Integer.MIN_VALUE;
                if (bagCapacity - weight[index] >= 0) {
                    takeIt = values[index] + dp[bagCapacity - weight[index]];
                }
                dp[bagCapacity] = Math.max(takeIt, leaveIt);
            }
        }

        return dp[capacity];
    }
}

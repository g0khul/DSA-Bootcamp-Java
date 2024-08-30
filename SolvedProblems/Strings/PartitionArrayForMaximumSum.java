import java.util.Arrays;

public class PartitionArrayForMaximumSum {
    public static void main(String[] args) {
        int[] arr = { 1, 15, 7, 9, 2, 5, 10 };
        int k = 3;
        System.out.println(maxSumAfterPartitioningRecursion(arr, k));
        System.out.println(maxSumAfterPartitioningMemoization(arr, k));
        System.out.println(maxSumAfterPartitioningDp(arr, k));
    }

    public static int maxSumAfterPartitioningRecursion(int[] arr, int k) {
        return helperRecursion(arr, 0, k);
    }

    public static int helperRecursion(int[] nums, int index, int k) {
        if (index == nums.length) {
            return 0;
        }

        int len = 0;
        int maxValue = Integer.MIN_VALUE;
        int maxAns = Integer.MIN_VALUE;
        for (int j = index; j < Math.min(nums.length, index + k); j++) {
            len++;
            maxValue = Math.max(maxValue, nums[j]);
            int sum = (len * maxValue) + helperRecursion(nums, j + 1, k);
            maxAns = Math.max(maxAns, sum);
        }

        return maxAns;
    }

    public static int maxSumAfterPartitioningMemoization(int[] nums, int k) {
        int[] memo = new int[nums.length];
        Arrays.fill(memo, -1);
        return helperMemoization(nums, 0, k, memo);
    }

    public static int helperMemoization(int[] nums, int index, int k, int[] memo) {
        if (index == nums.length) {
            return 0;
        }

        if (memo[index] != -1) {
            return memo[index];
        }

        int len = 0;
        int maxValue = Integer.MIN_VALUE;
        int maxAns = Integer.MIN_VALUE;

        for (int j = index; j < Math.min(nums.length, index + k); j++) {
            len++;
            maxValue = Math.max(maxValue, nums[j]);
            int sum = (len * maxValue) + helperMemoization(nums, j + 1, k, memo);
            maxAns = Math.max(maxAns, sum);
        }

        return memo[index] = maxAns;
    }

    public static int maxSumAfterPartitioningDp(int[] nums, int k) {
        int[] dp = new int[nums.length + 1];

        for (int index = nums.length - 1; index >= 0; index--) {
            int len = 0;
            int maxValue = Integer.MIN_VALUE;
            int maxAns = Integer.MIN_VALUE;
            for (int j = index; j < Math.min(nums.length, index + k); j++) {
                len++;
                maxValue = Math.max(maxValue, nums[j]);
                int sum = (len * maxValue) + dp[j + 1];
                maxAns = Math.max(maxAns, sum);
            }
            dp[index] = maxAns;
        }

        return dp[0];
    }
}

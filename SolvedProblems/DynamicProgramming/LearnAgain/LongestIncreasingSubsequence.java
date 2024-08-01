import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        int[] nums = { 10, 9, 2, 5, 3, 7, 101, 18 };
        System.out.println(lengthOfLISRecursion(nums));
        System.out.println(lengthOfLISMemoization(nums));
        System.out.println(lengthOfLISDp(nums));
        System.out.println(lengthOfLISSpaceOptimization(nums));
    }

    public static int lengthOfLISRecursion(int[] nums) {
        return helperRecursion(nums, nums.length - 1, Integer.MAX_VALUE);
    }

    public static int helperRecursion(int[] nums, int index, int next) {
        if (index == 0) {
            return (nums[index] < next) ? 1 : 0;
        }

        int leaveIt = helperRecursion(nums, index - 1, next);
        int takeIt = Integer.MIN_VALUE;
        if (nums[index] < next) {
            takeIt = 1 + helperRecursion(nums, index - 1, nums[index]);
        }

        return Math.max(takeIt, leaveIt);
    }

    public static int lengthOfLISMemoization(int[] nums) {
        int[][] memo = new int[nums.length][nums.length + 1];
        for (int[] is : memo) {
            Arrays.fill(is, -1);
        }

        return helperMemoization(nums, 0, -1, memo);
    }

    public static int helperMemoization(int[] nums, int index, int prev, int[][] memo) {
        if (index == nums.length) {
            return 0;
        }

        if (memo[index][prev + 1] != -1) {
            return memo[index][prev + 1];
        }

        int leaveIt = 0 + helperMemoization(nums, index + 1, prev, memo);
        int takeIt = Integer.MIN_VALUE;
        if (prev == -1 || nums[index] > nums[prev]) {
            takeIt = 1 + helperMemoization(nums, index + 1, index, memo);
        }

        return memo[index][prev + 1] = Math.max(takeIt, leaveIt);
    }

    public static int lengthOfLISDp(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n + 1][n + 1];

        for (int i = 0; i < n; i++) {
            dp[i][n] = 0;
        }

        for (int index = n - 1; index >= 0; index--) {
            for (int prev = -1; prev < n; prev++) {
                int leaveIt = 0 + dp[index + 1][prev + 1];
                int takeIt = Integer.MIN_VALUE;
                if (prev == -1 || nums[index] > nums[prev]) {
                    takeIt = 1 + dp[index + 1][index + 1];
                }
                dp[index][prev + 1] = Math.max(takeIt, leaveIt);
            }
        }

        return dp[0][0];
    }

    public static int lengthOfLISSpaceOptimization(int[] nums) {
        int n = nums.length;
        int[] next = new int[n + 1];
        int[] curr = new int[n + 1];

        next[n] = 0;
        curr[n] = 0;

        for (int index = n - 1; index >= 0; index--) {
            for (int prev = -1; prev < n; prev++) {
                int leaveIt = 0 + next[prev + 1];
                int takeIt = Integer.MIN_VALUE;
                if (prev == -1 || nums[index] > nums[prev]) {
                    takeIt = 1 + next[index + 1];
                }
                curr[prev + 1] = Math.max(leaveIt, takeIt);
            }
            next = curr;
        }

        return curr[0];
    }
}

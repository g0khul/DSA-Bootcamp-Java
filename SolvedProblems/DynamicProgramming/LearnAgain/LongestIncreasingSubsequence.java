import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        int[] nums = { 5, 4, 11, 1, 16, 8 };
        System.out.println(lengthOfLISRecursion(nums));
        System.out.println(lengthOfLISMemoization(nums));
        System.out.println(lengthOfLISDp(nums));
        System.out.println(lengthOfLISSpaceOptimization(nums));
        System.out.println(lengthOfLIS1DArray(nums));
        System.out.println(Arrays.toString(lengthOfLISPrint(nums)));
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

    public static int lengthOfLIS1DArray(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int max = 1;

        for (int index = 1; index < nums.length; index++) {
            for (int prev = 0; prev < index; prev++) {
                if (nums[prev] < nums[index]) {
                    dp[index] = Math.max(dp[index], 1 + dp[prev]);
                }
            }
            max = Math.max(max, dp[index]);
        }

        return max;
    }

    public static int[] lengthOfLISPrint(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int[] hash = new int[nums.length];

        int maxVal = 1;
        int maxLength = 1;
        int maxIndex = 0;
        for (int index = 0; index < hash.length; index++) {
            hash[index] = index;
            for (int prev = 0; prev < index; prev++) {
                if (nums[prev] < nums[index] && 1 + dp[prev] > dp[index]) {
                    dp[index] = 1 + dp[prev];
                    hash[index] = prev;
                }
            }
            if (dp[index] > maxLength) {
                maxVal = nums[index];
                maxLength = dp[index];
                maxIndex = index;
            }
        }

        System.out.println(maxVal + " : " + maxIndex);

        int[] res = new int[maxLength];
        int index = maxIndex;
        int resi = res.length - 1;
        res[resi--] = maxVal;
        while (index != 0) {
            res[resi--] = nums[hash[index]];
            index = hash[index];
        }

        return res;
    }
}

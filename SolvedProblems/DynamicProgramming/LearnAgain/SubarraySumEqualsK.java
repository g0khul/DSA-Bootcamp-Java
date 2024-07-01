import java.util.Arrays;

public class SubarraySumEqualsK {
    public static void main(String[] args) {
        int[] nums = { 2, 3, 1, 1 };
        int k = 4;
        System.out.println(subarraySumRecursion(nums, k));
        System.out.println(subarraySumMemoization(nums, k));
        System.out.println(subArraySumDP(nums, k));
        System.out.println(subArraySumSpaceOptimization(nums, k));
    }

    public static boolean subarraySumRecursion(int[] nums, int k) {
        return helperRecursion(nums, k, nums.length - 1);
    }

    public static boolean helperRecursion(int[] nums, int target, int index) {
        if (target == 0) {
            return true;
        }

        if (index == 0) {
            return target == nums[index];
        }

        // Leave it
        boolean leaveIt = helperRecursion(nums, target, index - 1);

        // Take it
        boolean takeIt = false;
        if (target - nums[index] >= 0) {
            takeIt = helperRecursion(nums, target - nums[index], index - 1);
        }

        return takeIt || leaveIt;
    }

    public static boolean subarraySumMemoization(int[] nums, int k) {
        int[][] memo = new int[nums.length][k + 1];
        for (int[] is : memo) {
            Arrays.fill(is, -1);
        }
        return helperMemoization(nums, k, nums.length - 1, memo);
    }

    public static boolean helperMemoization(int[] nums, int target, int index, int[][] memo) {
        if (target == 0) {
            memo[index][target] = 1;
            return memo[index][target] == 1;
        }

        if (index == 0) {
            memo[index][target] = (target == nums[index]) ? 1 : 0;
            return memo[index][target] == 1;
        }

        if (memo[index][target] != -1) {
            return memo[index][target] == 1;
        }

        // Leave it
        boolean leaveIt = helperMemoization(nums, target, index - 1, memo);

        // Take it
        boolean takeIt = false;
        if (target - nums[index] >= 0) {
            takeIt = helperMemoization(nums, target - nums[index], index - 1, memo);
        }

        memo[index][target] = (takeIt || leaveIt) ? 1 : 0;
        return memo[index][target] == 1;
    }

    public static boolean subArraySumDP(int[] nums, int k) {
        boolean[][] dp = new boolean[nums.length][k + 1];
        for (boolean[] is : dp) {
            Arrays.fill(is, false);
        }

        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = true;
        }
        dp[0][nums[0]] = true;

        for (int i = 1; i < nums.length; i++) {
            for (int target = 1; target <= k; target++) {
                // Leave it
                boolean leaveIt = dp[i - 1][target];

                // Take it
                boolean takeIt = false;
                if (target - nums[i] >= 0) {
                    takeIt = dp[i - 1][target - nums[i]];
                }

                dp[i][target] = takeIt || leaveIt;
            }
        }

        return dp[nums.length - 1][k];
    }

    public static boolean subArraySumSpaceOptimization(int[] nums, int k) {
        boolean[] prev = new boolean[k + 1];
        prev[0] = true;
        prev[nums[0]] = true;

        for (int i = 0; i < nums.length; i++) {
            boolean[] curr = new boolean[k + 1];
            curr[0] = true;
            for (int target = 1; target <= k; target++) {
                boolean leaveIt = prev[target];
                boolean takeIt = false;
                if (target - nums[i] >= 0) {
                    takeIt = prev[target - nums[i]];
                }

                curr[target] = takeIt || leaveIt;
            }
            prev = curr;
        }

        return prev[k];
    }
}

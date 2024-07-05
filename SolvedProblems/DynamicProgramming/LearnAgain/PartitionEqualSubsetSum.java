import java.util.Arrays;

public class PartitionEqualSubsetSum {
    public static void main(String[] args) {
        int[] nums = { 2, 3, 3, 4, 3, 5 };
        System.out.println(canPartitionRecursion(nums));
        System.out.println(canPartitionMemoization(nums));
        System.out.println(canPartitionDp(nums));
        System.out.println(canPartitionSpaceOptimization(nums));
    }

    public static boolean canPartitionRecursion(int[] nums) {
        int target = 0;
        for (int n : nums) {
            target += n;
        }

        return (target % 2 != 0) ? false : helperRecursion(nums, nums.length - 1, target / 2);
    }

    public static boolean helperRecursion(int[] nums, int index, int target) {
        if (target == 0) {
            return true;
        }

        if (index == 0) {
            return nums[0] == target;
        }

        boolean leaveIt = helperRecursion(nums, index - 1, target);
        boolean takeIt = false;
        if (target - nums[index] >= 0) {
            takeIt = helperRecursion(nums, index - 1, target - nums[index]);
        }

        return takeIt || leaveIt;
    }

    public static boolean canPartitionMemoization(int[] nums) {
        int target = 0;
        for (int n : nums) {
            target += n;
        }

        if (target % 2 != 0) {
            return false;
        }

        target = target / 2;
        int[][] memo = new int[nums.length][target + 1];
        for (int[] is : memo) {
            Arrays.fill(is, -1);
        }

        return helperMemoization(nums, nums.length - 1, target, memo);
    }

    public static boolean helperMemoization(int[] nums, int index, int target, int[][] memo) {
        if (target == 0) {
            return true;
        }

        if (index == 0) {
            memo[index][target] = (target == nums[index]) ? 1 : 0;
            return memo[index][target] == 1;
        }

        if (memo[index][target] != -1) {
            return memo[index][target] == 1;
        }

        boolean leaveIt = helperMemoization(nums, index - 1, target, memo);
        boolean takeIt = false;
        if (target - nums[index] >= 0) {
            takeIt = helperMemoization(nums, index - 1, target - nums[index], memo);
        }

        memo[index][target] = (takeIt || leaveIt) ? 1 : 0;
        return memo[index][target] == 1;
    }

    public static boolean canPartitionDp(int[] nums) {
        int k = 0;
        for (int n : nums) {
            k += n;
        }

        if (k % 2 != 0) {
            return false;
        }

        k = k / 2;
        boolean[][] dp = new boolean[nums.length][k + 1];
        for (boolean[] is : dp) {
            Arrays.fill(is, false);
        }

        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = true;
        }
        // Not mandatory
        // dp[0][nums[0]] = true;

        for (int index = 1; index < nums.length; index++) {
            for (int target = 1; target <= k; target++) {
                boolean leaveIt = dp[index - 1][target];
                boolean takeIt = false;
                if (target - nums[index] >= 0) {
                    takeIt = dp[index - 1][target - nums[index]];
                }
                dp[index][target] = takeIt || leaveIt;
            }
        }

        return dp[nums.length - 1][k];
    }

    public static boolean canPartitionSpaceOptimization(int[] nums) {
        int k = 0;
        for (int n : nums) {
            k += n;
        }

        if (k % 2 != 0) {
            return false;
        }

        boolean[] prev = new boolean[k + 1];
        prev[0] = true;
        k = k / 2;

        for (int index = 0; index < nums.length; index++) {
            boolean[] curr = new boolean[k + 1];
            curr[0] = true;
            for (int target = 1; target <= k; target++) {
                boolean leaveIt = prev[target];
                boolean takeIt = false;
                if (target - nums[index] >= 0) {
                    takeIt = prev[target - nums[index]];
                }
                curr[target] = takeIt || leaveIt;
            }
            prev = curr;
        }

        return prev[k];
    }
}

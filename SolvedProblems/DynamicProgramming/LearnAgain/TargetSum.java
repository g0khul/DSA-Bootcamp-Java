import java.util.Arrays;

public class TargetSum {
    public static void main(String[] args) {
        int[] nums = { 0, 0, 0, 0, 1000 };
        int target = -1000;
        System.out.println(findTargetSumWaysRecursion(nums, target));
        System.out.println(findTargetSumWaysMemoization(nums, target));
        System.out.println(findTargetSumWaysDp(nums, target));
    }

    public static int findTargetSumWaysRecursion(int[] nums, int target) {
        return helperRecursion(nums, target, 0);
    }

    public static int helperRecursion(int[] nums, int target, int index) {
        if (nums.length == index) {
            return target == 0 ? 1 : 0;
        }

        int addIt = helperRecursion(nums, target + nums[index], index + 1);
        int subtractIt = helperRecursion(nums, target - nums[index], index + 1);

        return addIt + subtractIt;
    }

    public static int findTargetSumWaysMemoization(int[] nums, int target) {
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }

        if (Math.abs(target) > sum) {
            return 0;
        }

        int[][] memo = new int[nums.length][2 * sum + 1];
        for (int[] is : memo) {
            Arrays.fill(is, -1);
        }

        return helperMemoization(nums, target, sum, nums.length - 1, memo);
    }

    public static int helperMemoization(int[] nums, int target, int sum, int index, int[][] memo) {
        if (index == -1) {
            return target == 0 ? 1 : 0;
        }

        if (target + sum < 0 || target + sum >= memo[0].length) {
            return 0;
        }

        if (memo[index][target + sum] != -1) {
            return memo[index][target + sum];
        }

        int addIt = helperMemoization(nums, target + nums[index], sum, index - 1, memo);
        int subtractIt = helperMemoization(nums, target - nums[index], sum, index - 1, memo);

        return memo[index][target + sum] = addIt + subtractIt;
    }

    public static int findTargetSumWaysDp(int[] nums, int target) {
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }

        if (Math.abs(target) > sum) {
            return 0;
        }

        int[][] dp = new int[nums.length][2 * sum + 1];
        dp[0][nums[0] + sum] = 1;
        dp[0][-nums[0] + sum] += 1;

        for (int index = 1; index < nums.length; index++) {
            for (int findingTarget = -sum; findingTarget <= sum; findingTarget++) {
                if (dp[index - 1][findingTarget + sum] > 0) {
                    dp[index][findingTarget + nums[index] + sum] += dp[index - 1][findingTarget + sum];
                    dp[index][findingTarget - nums[index] + sum] += dp[index - 1][findingTarget + sum];
                }
            }
        }

        return dp[nums.length - 1][target + sum];
    }
}

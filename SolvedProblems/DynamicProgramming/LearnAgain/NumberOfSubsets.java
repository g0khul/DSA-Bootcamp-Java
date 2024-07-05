import java.util.Arrays;

// https://www.naukri.com/code360/problems/number-of-subsets_3952532?source=youtube&campaign=striver_dp_videos&utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_dp_videos
public class NumberOfSubsets {
    public static void main(String[] args) {
        int[] nums = { 1, 1, 4, 5 };
        int target = 5;
        System.out.println(findWaysRecursion(nums, target));
        System.out.println(findWaysMemoization(nums, target));
        System.out.println(findWaysDp(nums, target));
        System.out.println(findWaysSpaceOptimization(nums, target));
    }

    public static int findWaysRecursion(int[] nums, int target) {
        return helperRecursion(nums, nums.length - 1, target);
    }

    public static int helperRecursion(int[] nums, int index, int target) {
        if (index == 0) {
            if (target == 0 && nums[index] == 0) {
                return 2;
            }
            if (target == 0 || target == nums[index]) {
                return 1;
            }
            return 0;
        }

        int leaveIt = helperRecursion(nums, index - 1, target);
        int takeIt = 0;
        if (target - nums[index] >= 0) {
            takeIt = helperRecursion(nums, index - 1, target - nums[index]);
        }

        return takeIt + leaveIt;
    }

    public static int findWaysMemoization(int[] nums, int target) {
        int[][] memo = new int[nums.length][target + 1];
        for (int[] is : memo) {
            Arrays.fill(is, -1);
        }
        return helperMemoization(nums, nums.length - 1, target, memo);
    }

    public static int helperMemoization(int[] nums, int index, int target, int[][] memo) {
        if (index == 0) {
            if (target == 0 && nums[index] == 0) {
                return 2;
            }
            if (target == 0 || target == nums[index]) {
                return 1;
            }
            return 0;
        }

        if (memo[index][target] != -1) {
            return memo[index][target];
        }
        int leaveIt = helperMemoization(nums, index - 1, target, memo);
        int takeIt = 0;
        if (target - nums[index] >= 0) {
            takeIt = helperMemoization(nums, index - 1, target - nums[index], memo);
        }

        return memo[index][target] = takeIt + leaveIt;
    }

    public static int findWaysDp(int[] nums, int t) {
        int[][] dp = new int[nums.length][t + 1];
        for (int i = 0; i < nums.length; i++) {
            dp[i][0] = (nums[i] == 0) ? 2 : 1;
        }

        if (nums[0] <= t) {
            dp[0][nums[0]] = (nums[0] == 0) ? 2 : 1;
        }

        for (int index = 1; index < nums.length; index++) {
            for (int target = 0; target <= t; target++) {
                int leaveIt = dp[index - 1][target];
                int takeIt = 0;
                if (target - nums[index] >= 0) {
                    takeIt = dp[index - 1][target - nums[index]];
                }
                dp[index][target] = takeIt + leaveIt;
            }
        }

        return dp[nums.length - 1][t];
    }

    public static int findWaysSpaceOptimization(int[] nums, int t) {
        int[] prev = new int[t + 1];
        prev[0] = (nums[0] == 0) ? 2 : 1;

        if (prev[nums[0]] <= t) {
            prev[nums[0]] = (nums[0] == 0) ? 2 : 1;
        }

        for (int index = 1; index < nums.length; index++) {
            int[] curr = new int[t + 1];
            curr[0] = (nums[index] == 0) ? 2 : 1;
            for (int target = 0; target <= t; target++) {
                int leaveIt = prev[target];
                int takeIt = 0;
                if (target - nums[index] >= 0) {
                    takeIt = prev[target - nums[index]];
                }
                curr[target] = takeIt + leaveIt;
            }
            prev = curr;
        }

        return prev[t];
    }
}

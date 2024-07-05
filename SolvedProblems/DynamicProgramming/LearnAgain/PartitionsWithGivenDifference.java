
// https://www.geeksforgeeks.org/problems/partitions-with-given-difference/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=partitions-with-given-difference

import java.util.Arrays;

public class PartitionsWithGivenDifference {
    public static void main(String[] args) {
        int[] nums = { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
                1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
                1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 };
        int d = 24;
        // System.out.println(countPartitionsRecursion(nums.length, d, nums));
        System.out.println(countPartitionsMemoization(nums.length, d, nums));
        System.out.println(countPartitionsDp(nums.length, d, nums));
        System.out.println(countPartitionsSpaceOptimization(nums.length, d, nums));
    }

    public static int countPartitionsRecursion(int n, int d, int[] nums) {
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }

        if ((sum - d) % 2 != 0) {
            return 0;
        }

        int target = (sum - d) / 2;
        return helperRecursion(nums, nums.length - 1, target);
    }

    public static int helperRecursion(int[] nums, int index, int target) {
        if (index == 0) {
            if (target == 0 && nums[index] == 0) {
                return 2;
            }
            if (target == 0 || nums[index] == target) {
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

    public static int countPartitionsMemoization(int n, int d, int[] nums) {
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }

        if (sum - d < 0 || (sum - d) % 2 != 0) {
            return 0;
        }

        int target = (sum - d) / 2;
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
            if (target == 0 || nums[index] == target) {
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

        final int mod = 1000000007;
        return memo[index][target] = (takeIt + leaveIt) % mod;
    }

    public static int countPartitionsDp(int n, int d, int[] nums) {
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }

        if (sum - d < 0 || (sum - d) % 2 != 0) {
            return 0;
        }

        int t = (sum - d) / 2;
        int[][] dp = new int[nums.length][t + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = (nums[0] == 0) ? 2 : 1;
        }

        if (nums[0] <= t) {
            dp[0][nums[0]] = (nums[0] == 0) ? 2 : 1;
        }

        for (int index = 1; index < dp.length; index++) {
            for (int target = 0; target <= t; target++) {
                int leaveIt = dp[index - 1][target];
                int takeIt = 0;
                if (target - nums[index] >= 0) {
                    takeIt = dp[index - 1][target - nums[index]];
                }
                final int mod = 1000000007;
                dp[index][target] = (takeIt + leaveIt) % mod;
            }
        }

        return dp[dp.length - 1][t];
    }

    public static int countPartitionsSpaceOptimization(int n, int d, int[] nums) {
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }

        if ((sum - d) < 0 || (sum - d) % 2 != 0) {
            return 0;
        }

        int t = (sum - d) / 2;
        int[] prev = new int[t + 1];
        prev[0] = (nums[0] == 0) ? 2 : 1;
        if (nums[0] <= t) {
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
                final int mod = 1000000007;
                curr[target] = (takeIt + leaveIt) % mod;
            }
            prev = curr;
        }

        return prev[t];
    }
}

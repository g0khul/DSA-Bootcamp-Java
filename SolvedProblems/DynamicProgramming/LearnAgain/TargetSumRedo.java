import java.util.Arrays;

public class TargetSumRedo {
    public static void main(String[] args) {
        int[] nums = { 1, 1, 1, 1, 1 };
        int target = 3;
        System.out.println(findTargetSumWaysMemoization(nums, target));
        System.out.println(findTargetSumWaysSpaceOptimization(nums, target));
    }

    public static int findTargetSumWaysMemoization(int[] nums, int t) {
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }

        if (sum - t < 0 || (sum - t) % 2 != 0) {
            return 0;
        }

        int target = (sum - t) / 2;
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

        return memo[index][target] = takeIt + leaveIt;
    }

    public static int findTargetSumWaysSpaceOptimization(int[] nums, int d) {
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }

        if ((sum - d) < 0 || (sum - d) % 2 != 0) {
            return 0;
        }

        int T = (sum - d) / 2;
        int[] prev = new int[T + 1];

        prev[0] = (nums[0] == 0) ? 2 : 1;
        if (nums[0] <= T) {
            prev[nums[0]] = nums[0] == 0 ? 2 : 1;
        }

        for (int index = 1; index < nums.length; index++) {
            int[] curr = new int[T + 1];
            curr[0] = nums[index] == 0 ? 2 : 1;
            for (int target = 0; target <= T; target++) {
                int leaveIt = prev[target];
                int takeIt = 0;
                if (target - nums[index] >= 0) {
                    takeIt = prev[target - nums[index]];
                }
                curr[target] = takeIt + leaveIt;
            }
            prev = curr;
        }

        return prev[T];
    }
}

package Recursion;

public class TargetSum {
    public static int findTargettargetWays(int[] nums, int target) {
        return helper(nums, target, 0, 0);
    }

    private static int helper(int[] nums, int target, int sum, int index) {
        if (index == nums.length) {
            if (target == sum) {
                return 1;
            } else {
                return 0;
            }
        }

        return helper(nums, target, sum + nums[index], index + 1) + helper(nums, target, sum - nums[index], index + 1);
    }

    public static void main(String[] args) {
        int[] nums = { 1, 0 };
        int target = 1;
        System.out.println(findTargettargetWays(nums, target));
    }
}

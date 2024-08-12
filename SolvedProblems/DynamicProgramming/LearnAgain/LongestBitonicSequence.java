public class LongestBitonicSequence {
    public static void main(String[] args) {
        int[] nums = { 2, 1, 1, 5, 6, 2, 3, 1 };
        // Refer LIS for recursion and memoization etc.
        System.out.println(LBSDp(nums));
    }

    public static int LBSDp(int[] nums) {
        int[] dp1 = new int[nums.length];
        int[] dp2 = new int[nums.length];

        for (int index = 0; index < nums.length; index++) {
            dp1[index] = 1;
            for (int prev = 0; prev < nums.length; prev++) {
                if (nums[index] > nums[prev] && dp1[index] < 1 + dp1[prev]) {
                    dp1[index] = 1 + dp1[prev];
                }
            }
        }

        for (int index = nums.length - 1; index >= 0; index--) {
            dp2[index] = 1;
            for (int prev = nums.length - 1; prev > index; prev--) {
                if (nums[index] > nums[prev] && dp2[index] < 1 + dp2[prev]) {
                    dp2[index] = 1 + dp2[prev];
                }
            }
        }

        int max = 1;
        for (int index = 0; index < nums.length; index++) {
            max = Math.max(max, Math.abs(dp1[index] + dp2[index] - 1));
        }

        return max;
    }
}

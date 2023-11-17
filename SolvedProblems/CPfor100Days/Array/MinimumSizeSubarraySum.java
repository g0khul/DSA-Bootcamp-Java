package CPfor100Days.Array;

public class MinimumSizeSubarraySum {
    public static void main(String[] args) {
        int[] nums = { 1, 1, 1, 1, 1, 1, 1, 1 };
        int target = 11;
        System.out.println(minSubArrayLen(target, nums));
    }

    public static int minSubArrayLen(int target, int[] nums) {
        int start = 0;
        int end = 0;

        int sum = 0;
        int length = 0;
        int result = Integer.MAX_VALUE;

        while (start < nums.length && end < nums.length) {
            // Move end till sum >= target
            while (end < nums.length && sum < target) {
                sum = sum + nums[end++];
                length++;
            }

            result = (sum >= target && length < result) ? length : result;

            // Move start till sum < target
            while (start < nums.length && sum >= target) {
                result = (length < result) ? length : result;
                sum = sum - nums[start++];
                length--;
            }
        }

        return (result == Integer.MAX_VALUE) ? 0 : result;
    }
}

package SlidingWindow;

// Find minimum length sub array where the length is greater than or equal to k

public class MinLengthSubArray {
    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 14, 5, 6 };
        int k = 7;
        getSubArray(nums, k);
    }

    private static void getSubArray(int[] nums, int k) {
        int start = 0;
        int end = 0;

        int sum = 0;
        int minLength = Integer.MAX_VALUE;
        while (end < nums.length) {
            sum = sum + nums[end];
            end = end + 1;

            while (start < end && sum >= k) {
                sum = sum - nums[start];
                start = start + 1;
                minLength = (minLength < end - start + 1)? minLength : end - start + 1;
            }

        }

        System.out.println(minLength);
    }
}

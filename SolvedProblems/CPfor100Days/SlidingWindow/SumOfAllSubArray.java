package CPfor100Days.SlidingWindow;

// Find sum of all the sub array with length k

public class SumOfAllSubArray {
    private static void findSubArray(int[] nums, int k) {
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        System.out.println(sum);

        for (int i = k; i < nums.length; i++) {
            sum = sum - nums[i - 1];
            sum = sum + nums[i];
            System.out.println(sum);
        }
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4, 5 };
        int k = 3;
        findSubArray(nums, k);
    }
}

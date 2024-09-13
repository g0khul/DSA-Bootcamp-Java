import java.util.*;

public class LeftAndRightSumDifferences {
    public static void main(String[] args) {
        int[] nums = { 10, 4, 8, 3 };
        System.out.println(Arrays.toString(leftRightDifference(nums)));
    }

    public static int[] leftRightDifference(int[] nums) {
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];

        // Left
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            left[i] = sum;
        }

        // Right
        sum = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            sum += nums[i];
            right[i] = sum;
        }

        for (int i = 0; i < nums.length; i++) {
            nums[i] = Math.abs(left[i] - right[i]);
        }

        return nums;
    }
}

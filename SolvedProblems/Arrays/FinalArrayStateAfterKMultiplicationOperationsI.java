import java.util.*;

public class FinalArrayStateAfterKMultiplicationOperationsI {
    public static void main(String[] args) {
        int[] nums = { 2, 1, 3, 5, 6 };
        int k = 5;
        int multiplier = 2;
        System.out.println(Arrays.toString(getFinalState(nums, k, multiplier)));
    }

    public static int[] getFinalState(int[] nums, int k, int multiplier) {
        int minValue = nums[0];
        int minIndex = 0;

        for (int i = 1; i < nums.length; i++) {
            if (minValue > nums[i]) {
                minValue = nums[i];
                minIndex = i;
            }
        }

        for (int i = 0; i < k; i++) {
            nums[minIndex] = nums[minIndex] * multiplier;
            minValue = nums[0];
            minIndex = 0;
            for (int j = 0; j < nums.length; j++) {
                if (minValue > nums[j]) {
                    minValue = nums[j];
                    minIndex = j;
                }
            }
        }

        return nums;
    }
}

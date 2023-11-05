package Array;

import java.util.Arrays;

public class RemoveElement {
    public static void main(String[] args) {
        int[] nums = { 3 };
        int val = 3;
        System.out.println(removeElement(nums, val));
        System.out.println(Arrays.toString(nums));
    }

    public static int removeElement(int[] nums, int val) {
        int k = 0;
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            // Move start
            while (start < nums.length && nums[start] != val) {
                start++;
            }

            // Move end
            while (end >= 0 && nums[end] == val) {
                end--;
                k++;
            }

            if (start > end) {
                break;
            }

            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
        }

        return nums.length - k;
    }
}

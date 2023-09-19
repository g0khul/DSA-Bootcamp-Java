package Array;

public class RotateArray {
    public static void rotate(int[] nums, int k) {
        if (nums.length <= 1) {
            return;
        }

        k = k % nums.length;

        // Good way
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);

        // Bad way of solving it
        // for (int i = 0; i < k; i++) {
        //     int temp = nums[nums.length - 1];
        //     for (int j = nums.length - 1; j > 0; j--) {
        //         nums[j] = nums[j - 1];
        //     }
        //     nums[0] = temp;
        // }
    }

    private static void reverse(int[] nums, int start, int end) {
        while (start <= end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 6, 7 };
        rotate(arr, 4);
    }
}

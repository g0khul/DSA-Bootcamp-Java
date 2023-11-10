import java.util.Arrays;

public class ProductOfArrayExceptSelf {
    public static void main(String[] args) {
        int[] nums = { -1, 1, 0, -3, 3 };
        System.out.println(Arrays.toString(productExceptSelf(nums)));
    }

    public static int[] productExceptSelf(int[] nums) {
        // int[] result = new int[nums.length];
        // int[] left = new int[nums.length];
        // int[] right = new int[nums.length];

        // left[0] = 1;

        // for (int i = 1; i < left.length; i++) {
        // left[i] = left[i - 1] * nums[i - 1];
        // }

        // right[nums.length - 1] = 1;
        // for (int i = right.length - 2; i >= 0; i--) {
        // right[i] = right[i + 1] * nums[i + 1];
        // }

        // for (int i = 0; i < right.length; i++) {
        // result[i] = left[i] * right[i];
        // }

        // O(1) space
        int[] result = new int[nums.length];

        int leftProduct = 1;
        for (int i = 0; i < nums.length; i++) {
            result[i] = leftProduct;
            leftProduct = leftProduct * nums[i];
        }

        int rightProduct = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            result[i] *= rightProduct;
            rightProduct = rightProduct * nums[i];
        }

        return result;
    }
}

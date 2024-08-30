import java.util.Arrays;

public class FindThePowerOfKSizeSubarraysI {
    public static void main(String[] args) {
        int[] nums = { 3, 2, 43, 44, 45 };
        int k = 3;
        System.out.println(Arrays.toString(resultsArray(nums, k)));
    }

    public static int[] resultsArray(int[] nums, int k) {
        if (nums.length <= 1 || k == 1) {
            return nums;
        }

        int[] result = new int[nums.length - k + 1];
        int r = 0;

        for (int i = 0; i < result.length; i++) {
            int j = i + k - 1;
            if (j - i + 1 == k && isIncreasing(nums, i, j)) {
                result[r++] = nums[j];
            } else if (j - i + 1 == k) {
                result[r++] = -1;
            }
        }

        return result;
    }

    public static boolean isIncreasing(int[] nums, int i, int j) {
        while (i <= j) {
            if (i + 1 <= j && nums[i] + 1 != nums[i + 1]) {
                return false;
            }
            i++;
        }

        return true;
    }
}

package CPfor100Days.BinarySearch;

public class FindMinimumInRotatedSortedArray {
    public static void main(String[] args) {
        int[] nums = { 2 };
        System.out.println(findMin(nums));
    }

    public static int findMin(int[] nums) {
        if (nums[0] < nums[nums.length - 1]) {
            return nums[0];
        }

        return helper(nums, 0, nums.length - 1);
    }

    private static int helper(int[] nums, int start, int end) {
        if (start > end) {
            return nums[0];
        }

        int mid = start + (end - start) / 2;

        if (mid != 0 && nums[mid - 1] > nums[mid]) {
            return nums[mid];
        }

        // Increasing part
        if (nums[0] > nums[mid]) {
            // Move left
            return helper(nums, start, mid - 1);
        } else { // Decreasing part
            // Move right
            return helper(nums, mid + 1, end);
        }
    }
}

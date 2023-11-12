package CPfor100Days.BinarySearch;

public class SearchInRotatedArrayII {
    public static void main(String[] args) {
        int[] nums = { 3, 5, 1 };
        int target = 1;
        System.out.println(search(nums, target));
    }

    public static boolean search(int[] nums, int target) {
        return helper(nums, 0, nums.length - 1, target);
    }

    private static boolean helper(int[] nums, int start, int end, int target) {
        if (start > end) {
            return false;
        }

        int mid = start + (end - start) / 2;
        if (nums[mid] == target) {
            return true;
        }

        // Increasing part
        if (nums[start] > nums[mid]) {
            if (nums[mid] < target && target <= nums[end]) {
                // Move right
                return helper(nums, mid + 1, end, target);
            } else {
                // Move left
                return helper(nums, start, mid - 1, target);
            }
        }

        // Decreasing part
        else if (nums[start] < nums[mid]) {
            if (nums[start] <= target && target < nums[mid]) {
                // Move left
                return helper(nums, start, mid - 1, target);
            } else {
                // Move right
                return helper(nums, mid + 1, end, target);
            }
        }

        // Handling duplicates
        else {
            // It can be either in left or right
            return helper(nums, start, mid - 1, target) || helper(nums, mid + 1, end, target);
        }
    }
}

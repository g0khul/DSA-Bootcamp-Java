import java.util.Arrays;

public class PartitionArrayAccordingToGivenPivot {
    public static void main(String[] args) {
        int[] nums = { 9, 12, 5, 10, 14, 3, 10 };
        int pivot = 10;
        nums = pivotArray(nums, pivot);
        System.out.println(Arrays.toString(nums));
    }

    public static int[] pivotArray(int[] nums, int pivot) {
        int[] result = new int[nums.length];
        int equal = 0;
        int index = 0;

        // Lower
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < pivot) {
                result[index++] = nums[i];
            }

            if (nums[i] == pivot) {
                equal++;
            }
        }

        // Equal
        while (equal != 0) {
            result[index++] = pivot;
            equal--;
        }

        // Greater
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > pivot) {
                result[index++] = nums[i];
            }
        }

        return result;
    }
}

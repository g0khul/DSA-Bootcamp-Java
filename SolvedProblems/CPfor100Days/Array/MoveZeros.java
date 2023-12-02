package CPfor100Days.Array;
import java.util.Arrays;

public class MoveZeros {
    public static void moveZeroes(int[] nums) {
        if (nums.length <= 1) {
            return;
        }

        for (int i = 0, j = i + 1; j < nums.length; j++) {
            if (nums[j] != 0 && nums[i] == 0) {
                nums[i] = nums[j];
                nums[j] = 0;
                i++;
            }
            if (nums[i] != 0) {
                i++;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = { 0, 1, 0, 3, 12 };
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }
}

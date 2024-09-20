import java.util.*;;

public class TheTwoSneakyNumbersOfDigitville {
    public static void main(String[] args) {
        int[] nums = { 0, 3, 2, 1, 3, 2 };
        System.out.println(Arrays.toString(getSneakyNumbers(nums)));
    }

    public static int[] getSneakyNumbers(int[] nums) {
        for (int i = 0; i < nums.length;) {
            int correctIndex = nums[i];
            if (i != nums[i] && nums[i] != nums[correctIndex]) {
                // Swap
                int temp = nums[i];
                nums[i] = nums[correctIndex];
                nums[correctIndex] = temp;
            } else {
                i++;
            }
        }

        int[] result = new int[2];
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i) {
                result[k++] = nums[i];
            }
        }

        return result;
    }
}

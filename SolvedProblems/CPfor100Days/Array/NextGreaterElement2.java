package CPfor100Days.Array;

import java.util.Arrays;

public class NextGreaterElement2 {
    public static int[] nextGreaterElements(int[] nums) {
        int[] result = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            boolean flag = false;
            int stopIndex = i;
            int j = (i + 1) % nums.length;
            while (j != stopIndex) {
                if (nums[stopIndex] < nums[j]) {
                    result[i] = nums[j];
                    flag = true;
                    break;
                }
                j = (j + 1) % nums.length;
            }
            if (!flag) {
                result[i] = -1;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,1};
        int[] result = nextGreaterElements(nums);
        System.out.println(Arrays.toString(result));
    }
}

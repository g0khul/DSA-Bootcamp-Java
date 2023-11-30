package CPfor100Days.Array;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSumII {
    public static int[] twoSum(int[] nums, int target) {
        // for (int i = 0; i < nums.length; i++) {
        // for (int j = i; j < nums.length; j++) {
        // if (nums[i] + nums[j] == target) {
        // return new int[] { i + 1, j + 1 };
        // }
        // }
        // }
        // return new int[] { -1, -1 };

        HashMap<Integer, Integer> map = new HashMap<>();
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int complementLeft = target - nums[left];
            if (map.containsKey(complementLeft)) {
                return new int[] { map.get(complementLeft), left };
            }
            map.put(nums[left], left);

            int complementRight = target - nums[right];
            if (map.containsKey(complementRight)) {
                return new int[] { map.get(complementRight), right };
            }
            map.put(nums[right], right);

            left++;
            right--;
        }

        return new int[] { -1, -1 };
    }

    public static void main(String[] args) {
        int[] nums = { 2, 7, 11, 15 };
        int target = 9;
        System.out.println(Arrays.toString(twoSum(nums, target)));
    }
}

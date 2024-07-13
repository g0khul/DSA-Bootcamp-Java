import java.util.HashMap;
import java.util.Map;

public class ContinuousSubarraySum {
    public static void main(String[] args) {
        int[] nums = { 23, 2, 6, 4, 7 };
        int k = 6;
        System.out.println(checkSubarraySum(nums, k));
    }

    public static boolean checkSubarraySum(int[] nums, int k) {
        // for (int i = 0; i < nums.length; i++) {
        // int sum = 0;
        // for (int j = i; j < nums.length; j++) {
        // sum += nums[j];
        // if (j - i >= 1 && sum % k == 0) {
        // return true;
        // }
        // }
        // }

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];
            int remainder = sum % k;
            if (!map.containsKey(remainder)) {
                map.put(remainder, i);
            } else if (i - map.get(remainder) > 1) {
                return true;
            }
        }

        return false;
    }
}

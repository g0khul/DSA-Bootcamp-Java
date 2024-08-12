import java.lang.reflect.Array;
import java.util.Arrays;

public class NumberOfLongestIncreasingSubsequence {
    public static void main(String[] args) {
        int[] nums = { 1, 3, 5, 4, 7 };
        System.out.println(findNumberOfLIS(nums));
    }

    public static int findNumberOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int[] count = new int[nums.length];
        int max = 1;
        int cnt = 0;
        for (int index = 0; index < nums.length; index++) {
            dp[index] = 1;
            count[index] = 1;
            for (int prev = 0; prev < index; prev++) {
                if (nums[index] > nums[prev] && dp[index] < 1 + dp[prev]) {
                    dp[index] = 1 + dp[prev];
                    count[index] = count[prev];
                } else if (nums[index] > nums[prev] && dp[index] == 1 + dp[prev]) {
                    count[index] += count[prev];
                }
            }
            max = Math.max(max, dp[index]);
        }

        for (int i = 0; i < count.length; i++) {
            if (max == dp[i]) {
                cnt += count[i];
            }
        }

        return cnt;
    }
}

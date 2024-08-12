import java.util.Arrays;

public class BurstBalloons {
    public static void main(String[] args) {
        int[] nums = { 3, 1, 5, 8 };
        System.out.println(maxCoinsMemoization(nums));
        System.out.println(maxCoins(nums));
    }

    public static int maxCoins(int[] nums) {
        int n = nums.length;

        // Add 1 in the beginning and end of the array
        int[] extendedNums = new int[n + 2];
        extendedNums[0] = 1;
        extendedNums[extendedNums.length - 1] = 1;
        System.arraycopy(nums, 0, extendedNums, 1, n);
        nums = extendedNums;

        int[][] dp = new int[n + 2][n + 2];
        for (int i = n; i >= 1; i--) {
            for (int j = i; j <= n; j++) {
                int max = Integer.MIN_VALUE;
                for (int k = i; k <= j; k++) {
                    int prev = dp[i][k - 1];
                    int next = dp[k + 1][j];
                    int steps = (nums[i - 1] * nums[k] * nums[j + 1]) + prev + next;
                    max = Math.max(max, steps);
                }
                dp[i][j] = max;
            }
        }

        return dp[1][n];
    }

    public static int maxCoinsMemoization(int[] nums) {
        int n = nums.length;
        int[] extendedNums = new int[n + 2];
        extendedNums[0] = 1;
        extendedNums[n + 1] = 1;
        System.arraycopy(nums, 0, extendedNums, 1, n);

        int[][] memo = new int[n + 1][n + 1];
        for (int[] is : memo) {
            Arrays.fill(is, -1);
        }

        return helperMemoization(extendedNums, 1, n, memo);
    }

    public static int helperMemoization(int[] nums, int i, int j, int[][] memo) {
        if (i > j) {
            return 0;
        }

        if (memo[i][j] != -1) {
            return memo[i][j];
        }

        int max = Integer.MIN_VALUE;
        for (int k = i; k <= j; k++) {
            int left = helperMemoization(nums, i, k - 1, memo);
            int right = helperMemoization(nums, k + 1, j, memo);
            int steps = (nums[i - 1] * nums[k] * nums[j + 1]) + left + right;
            max = Math.max(max, steps);
        }

        return memo[i][j] = max;
    }
}

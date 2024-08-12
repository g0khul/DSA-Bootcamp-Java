import java.lang.reflect.Array;
import java.util.Arrays;

public class MatrixChainMultiplication {
    public static void main(String[] args) {
        int[] nums = { 10, 20, 30, 40, 50 };
        System.out.println(matrixMultiplicationRecursion(nums));
        System.out.println(matrixMultiplicationMemoization(nums));
        System.out.println(matrixMultiplicationDp(nums));
    }

    public static int matrixMultiplicationRecursion(int[] nums) {
        return helperRecursion(nums, 1, nums.length - 1);
    }

    public static int helperRecursion(int[] nums, int i, int j) {
        if (i == j) {
            return 0;
        }

        int min = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            int left = helperRecursion(nums, i, k);
            int right = helperRecursion(nums, k + 1, j);
            int steps = (nums[i - 1] * nums[k] * nums[j]) + left + right;
            min = Math.min(min, steps);
        }

        return min;
    }

    public static int matrixMultiplicationMemoization(int[] nums) {
        int[][] memo = new int[nums.length][nums.length];
        for (int[] is : memo) {
            Arrays.fill(is, -1);
        }

        return helperMemoization(nums, 1, nums.length - 1, memo);
    }

    public static int helperMemoization(int[] nums, int i, int j, int[][] memo) {
        if (i == j) {
            return 0;
        }

        if (memo[i][j] != -1) {
            return memo[i][j];
        }

        int min = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            int left = helperMemoization(nums, i, k, memo);
            int right = helperMemoization(nums, k + 1, j, memo);
            int steps = (nums[i - 1] * nums[k] * nums[j]) + left + right;
            min = Math.min(min, steps);
        }

        return memo[i][j] = min;
    }

    public static int matrixMultiplicationDp(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n + 1][n + 1];

        for (int i = n - 1; i >= 1; i--) {
            for (int j = i + 1; j < n; j++) {
                int min = Integer.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    int left = dp[i][k];
                    int right = dp[k + 1][j];
                    int steps = (nums[i - 1] * nums[k] * nums[j]) + left + right;
                    min = Math.min(min, steps);
                }
                dp[i][j] = min;
            }
        }

        return dp[1][n - 1];
    }
}

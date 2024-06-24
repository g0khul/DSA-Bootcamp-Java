import java.util.Arrays;

public class NWaysToReachStair {
    public static void main(String[] args) {
        int n = 5;
        System.out.println(countDistinctWaysToClimbStair(n));

        // With memoization
        if (n <= 2) {
            System.out.println(n);
            return;
        }
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i < n + 1; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        System.out.println(Arrays.toString(dp));
        System.out.println(dp[dp.length - 1]);

        // With space optimization
        if (n <= 2) {
            System.out.println(n);
            return;
        }
        int prev = 2;
        int secPrev = 1;
        int result = 0;
        for (int i = 3; i < n + 1; i++) {
            result = prev + secPrev;
            secPrev = prev;
            prev = result;
        }
        System.out.println(result);
    }

    public static int countDistinctWaysToClimbStair(int n) {
        if (n == 0) {
            return 1;
        }

        int left = countDistinctWaysToClimbStair(n - 1);
        int right = 0;
        if (n > 1) {
            right = countDistinctWaysToClimbStair(n - 2);
        }

        return left + right;
    }
}

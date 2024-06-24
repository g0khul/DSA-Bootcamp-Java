import java.util.Arrays;
import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the nth number for Fibonacci");
        int n = sc.nextInt();
        sc.close();

        // Approach 1 - memoization recursive method
        // int[] dp = new int[n + 1];
        // Arrays.fill(dp, -1);
        // int result = fibonacci(n, dp);
        // System.out.println(result);
        // System.out.println(Arrays.toString(dp));

        // Approach 2 - dp looping
        // if (n <= 1) {
        // System.out.println(n);
        // return;
        // }
        // int[] dp = new int[n + 1];
        // dp[0] = 0;
        // dp[1] = 1;
        // for (int i = 2; i <= n; i++) {
        // dp[i] = dp[i - 1] + dp[i - 2];
        // }
        // System.out.println(dp[n]);
        // System.out.println(Arrays.toString(dp));

        // Approach 3 - constant space
        if (n <= 1) {
            System.out.println(n);
            return;
        }
        int prev = 1;
        int secPrev = 0;
        int result = -1;
        for (int i = 2; i < n + 1; i++) {
            result = prev + secPrev;
            secPrev = prev;
            prev = result;
        }
        System.out.println(result);
    }

    public static int fibonacci(int n, int[] dp) {
        if (n <= 1) {
            return n;
        }

        if (dp[n] != -1) {
            return dp[n];
        }

        dp[n] = fibonacci(n - 1, dp) + fibonacci(n - 2, dp);
        return dp[n];
    }
}

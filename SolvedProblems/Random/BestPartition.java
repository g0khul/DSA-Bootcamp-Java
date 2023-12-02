package Random;

import java.util.*;

public class BestPartition {

    public static int bestPartition(int[] array, int n, int k) {
        // Check if the number of elements is valid.
        if (n < 0) {
            return -1;
        }

        // Initialize the best sum.
        int bestSum = Integer.MIN_VALUE;

        // Create a 2D array to store the maximum sum of a subarray of length `i` that can be partitioned into `j` segments.
        int[][] dp = new int[n + 1][k + 1];

        // Fill in the dp array in a bottom-up manner.
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= k; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1] + array[i - 1]);
                }
            }
        }

        // Find the maximum sum of all possible partitions of the array.
        for (int i = 1; i <= k; i++) {
            bestSum = Math.max(bestSum, dp[n][i]);
        }

        return bestSum;
    }

    public static void main(String[] args) {
        // Read the input from the user.
        Scanner scanner = new Scanner(System.in);
        int[] array = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = array.length;
        int k = Integer.parseInt(scanner.nextLine());

        // Print the output.
        System.out.println(bestPartition(array, n, k));
        scanner.close();
    }
}

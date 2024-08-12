import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinimumCostToCutAStick {
    public static void main(String[] args) {
        int[] cuts = { 5, 6, 1, 4, 2 };
        int n = 9;
        System.out.println(minCostRecursion(n, cuts));
        System.out.println(minCostMemoization(n, cuts));
        System.out.println(minCostDp(n, cuts));
    }

    public static int minCostRecursion(int n, int[] cuts) {
        Arrays.sort(cuts);
        int[] extendedArray = new int[cuts.length + 2];
        for (int i = 0; i < cuts.length; i++) {
            extendedArray[i + 1] = cuts[i];
        }
        extendedArray[0] = 0;
        extendedArray[extendedArray.length - 1] = n;
        return helperRecursion(extendedArray, 1, cuts.length);
    }

    public static int helperRecursion(int[] cuts, int i, int j) {
        if (i > j) {
            return 0;
        }

        int min = Integer.MAX_VALUE;
        for (int k = i; k <= j; k++) {
            int left = helperRecursion(cuts, i, k - 1);
            int right = helperRecursion(cuts, k + 1, j);

            int currCut = cuts[j + 1] - cuts[i - 1] + left + right;

            min = Math.min(currCut, min);
        }

        return min;
    }

    public static int minCostMemoization(int n, int[] cuts) {
        Arrays.sort(cuts);
        int[] extendedArray = new int[cuts.length + 2];
        for (int i = 0; i < cuts.length; i++) {
            extendedArray[i + 1] = cuts[i];
        }
        extendedArray[0] = 0;
        extendedArray[extendedArray.length - 1] = n;

        int[][] memo = new int[cuts.length + 1][cuts.length + 1];
        for (int[] is : memo) {
            Arrays.fill(is, -1);
        }

        return helperMemoization(extendedArray, 1, cuts.length, memo);
    }

    public static int helperMemoization(int[] cuts, int i, int j, int[][] memo) {
        if (i > j) {
            return 0;
        }

        if (memo[i][j] != -1) {
            return memo[i][j];
        }

        int min = Integer.MAX_VALUE;
        for (int k = i; k <= j; k++) {
            int left = helperMemoization(cuts, i, k - 1, memo);
            int right = helperMemoization(cuts, k + 1, j, memo);
            int currCuts = cuts[j + 1] - cuts[i - 1] + left + right;
            min = Math.min(min, currCuts);
        }

        return memo[i][j] = min;
    }

    public static int minCostDp(int n, int[] cuts) {
        Arrays.sort(cuts);
        int c = cuts.length;
        int[] extendedArray = new int[c + 2];
        extendedArray[0] = 0;
        extendedArray[extendedArray.length - 1] = n;
        for (int i = 0; i < c; i++) {
            extendedArray[i + 1] = cuts[i];
        }
        cuts = extendedArray;
        int[][] dp = new int[c + 2][c + 2];

        for (int i = c; i >= 1; i--) {
            for (int j = i; j <= c; j++) {
                int min = Integer.MAX_VALUE;
                for (int k = i; k <= j; k++) {
                    int left = dp[i][k - 1];
                    int right = dp[k + 1][j];
                    int currCuts = cuts[j + 1] - cuts[i - 1] + left + right;
                    min = Math.min(min, currCuts);
                }
                dp[i][j] = min;
            }
        }

        for (int[] is : dp) {
            System.out.println(Arrays.toString(is));
        }

        return dp[1][c];
    }
}

import java.util.Arrays;

public class EditDistance {
    public static void main(String[] args) {
        String s1 = "horse";
        String s2 = "ros";
        System.out.println(minDistanceRecursion(s1, s2));
        System.out.println(minDistanceMemoization(s1, s2));
        // -1 based indexing
        System.out.println(minDistanceDp(s1, s2));
        System.out.println(minDistanceSpaceOptimization(s1, s2));
    }

    public static int minDistanceRecursion(String s1, String s2) {
        return helperRecursion(s1, s1.length() - 1, s2, s2.length() - 1);
    }

    public static int helperRecursion(String s1, int index1, String s2, int index2) {
        if (index2 < 0) {
            return index1 + 1;
        }

        if (index1 < 0) {
            return index2 + 1;
        }

        if (s1.charAt(index1) == s2.charAt(index2)) {
            return 0 + helperRecursion(s1, index1 - 1, s2, index2 - 1);
        }

        int insert = helperRecursion(s1, index1, s2, index2 - 1);
        int delete = helperRecursion(s1, index1 - 1, s2, index2);
        int replace = helperRecursion(s1, index1 - 1, s2, index2 - 1);

        return 1 + Math.min(delete, Math.min(replace, insert));
    }

    public static int minDistanceMemoization(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int[][] memo = new int[n][m];
        for (int[] is : memo) {
            Arrays.fill(is, -1);
        }

        return helperMemoization(s1, s1.length() - 1, s2, s2.length() - 1, memo);
    }

    public static int helperMemoization(String s1, int index1, String s2, int index2, int[][] memo) {
        if (index2 < 0) {
            return index1 + 1;
        }

        if (index1 < 0) {
            return index2 + 1;
        }

        if (memo[index1][index2] != -1) {
            return memo[index1][index2];
        }

        if (s1.charAt(index1) == s2.charAt(index2)) {
            return memo[index1][index2] = 0 + helperMemoization(s1, index1 - 1, s2, index2 - 1, memo);
        }

        int insert = helperMemoization(s1, index1, s2, index2 - 1, memo);
        int delete = helperMemoization(s1, index1 - 1, s2, index2, memo);
        int replace = helperMemoization(s1, index1 - 1, s2, index2 - 1, memo);

        return memo[index1][index2] = 1 + Math.min(insert, Math.min(delete, replace));
    }

    public static int minDistanceDp(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int[][] dp = new int[n + 1][m + 1];
        for (int index1 = 0; index1 <= n; index1++) {
            dp[index1][0] = index1;
        }

        for (int index2 = 0; index2 <= m; index2++) {
            dp[0][index2] = index2;
        }

        for (int index1 = 1; index1 <= n; index1++) {
            for (int index2 = 1; index2 <= m; index2++) {
                if (s1.charAt(index1 - 1) == s2.charAt(index2 - 1)) {
                    dp[index1][index2] = 0 + dp[index1 - 1][index2 - 1];
                } else {
                    int insert = dp[index1][index2 - 1];
                    int delete = dp[index1 - 1][index2];
                    int replace = dp[index1 - 1][index2 - 1];
                    dp[index1][index2] = 1 + Math.min(insert, Math.min(delete, replace));
                }
            }
        }

        return dp[n][m];
    }

    public static int minDistanceSpaceOptimization(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int[] prev = new int[m + 1];

        for (int index2 = 0; index2 <= m; index2++) {
            prev[index2] = index2;
        }

        for (int index1 = 1; index1 <= n; index1++) {
            int[] curr = new int[m + 1];
            curr[0] = index1;
            for (int index2 = 1; index2 <= m; index2++) {
                if (s1.charAt(index1 - 1) == s2.charAt(index2 - 1)) {
                    curr[index2] = 0 + prev[index2 - 1];
                } else {
                    int insert = curr[index2 - 1];
                    int delete = prev[index2];
                    int replace = prev[index2 - 1];
                    curr[index2] = 1 + Math.min(insert, Math.min(delete, replace));
                }
            }
            prev = curr;
        }

        return prev[m];
    }
}

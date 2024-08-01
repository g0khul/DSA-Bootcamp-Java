import java.util.Arrays;

public class DistinctSubsequences {
    public static void main(String[] args) {
        String s1 = "babgbag";
        String s2 = "bag";
        System.out.println(numDistinctRecursion(s1, s2));
        System.out.println(numDistinctMemoization(s1, s2));
        // 1 based indexing to handle -1 also
        System.out.println(numDistinctDp(s1, s2));
        System.out.println(numDistinctSpaceOptimization(s1, s2));
        System.out.println(numDistinct1DSpaceOPtimization(s1, s2));
    }

    public static int numDistinctRecursion(String s1, String s2) {
        return helperRecursion(s1, s1.length() - 1, s2, s2.length() - 1);
    }

    public static int helperRecursion(String s1, int n, String s2, int m) {
        // if (m == 0) {
        // if (n > 0) {
        // int leaveIt = helperRecursion(s1, n - 1, s2, m);
        // int takeIt = 0;
        // if (s1.charAt(n) == s2.charAt(m)) {
        // takeIt = 1;
        // }
        // return takeIt + leaveIt;
        // }
        // return s1.charAt(0) == s2.charAt(0) ? 1 : 0;
        // }

        // if (n == 0) {
        // return 0;
        // }

        if (m < 0) {
            return 1;
        }

        if (n < 0) {
            return 0;
        }

        int leaveIt = helperRecursion(s1, n - 1, s2, m);
        int takeIt = 0;
        if (s1.charAt(n) == s2.charAt(m)) {
            takeIt = helperRecursion(s1, n - 1, s2, m - 1);
        }

        return takeIt + leaveIt;
    }

    public static int numDistinctMemoization(String s1, String s2) {
        int[][] memo = new int[s1.length()][s2.length()];
        for (int[] is : memo) {
            Arrays.fill(is, -1);
        }

        return helperMemoization(s1, s1.length() - 1, s2, s2.length() - 1, memo);
    }

    public static int helperMemoization(String s1, int n, String s2, int m, int[][] memo) {
        if (m < 0) {
            return 1;
        }

        if (n < 0) {
            return 0;
        }

        if (memo[n][m] != -1) {
            return memo[n][m];
        }

        int leaveIt = helperMemoization(s1, n - 1, s2, m, memo);
        int takeIt = 0;
        if (s1.charAt(n) == s2.charAt(m)) {
            takeIt = helperMemoization(s1, n - 1, s2, m - 1, memo);
        }

        return memo[n][m] = leaveIt + takeIt;
    }

    public static int numDistinctDp(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int[][] dp = new int[n + 1][m + 1];

        for (int j = 0; j < m; j++) {
            dp[0][j] = 0;
        }

        for (int i = 0; i < n; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                int leaveIt = dp[i - 1][j];
                int takeIt = 0;
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    takeIt = dp[i - 1][j - 1];
                }
                dp[i][j] = takeIt + leaveIt;
            }
        }

        return dp[n][m];
    }

    public static int numDistinctSpaceOptimization(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        int[] prev = new int[m + 1];
        prev[0] = 1;

        for (int i = 1; i <= n; i++) {
            int[] curr = new int[m + 1];
            curr[0] = 1;
            for (int j = 1; j <= m; j++) {
                int leaveIt = prev[j];
                int takeIt = 0;
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    takeIt = prev[j - 1];
                }
                curr[j] = takeIt + leaveIt;
            }
            prev = curr;
        }

        return prev[m];
    }

    public static int numDistinct1DSpaceOPtimization(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int[] dp = new int[m + 1];
        dp[0] = 1;

        for (int i = 1; i <= n; i++) {
            dp[0] = 1;
            for (int j = 1; j <= m; j++) {
                int leaveIt = dp[j];
                int takeIt = 0;
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    takeIt = dp[j - 1];
                }
                dp[j] = takeIt + leaveIt;
            }
        }

        return dp[m];
    }
}

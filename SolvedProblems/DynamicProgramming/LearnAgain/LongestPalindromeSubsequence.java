import java.util.Arrays;

public class LongestPalindromeSubsequence {
    public static void main(String[] args) {
        // Solution: find Longest Common Subsequence of s and reverse(s) to get
        // palindrome subsequence
        String s = "bbabcbcab";
        System.out.println(longestPalindromeSubseqRecursion(s));
        System.out.println(longestPalindromeSubseqMemoization(s));
        System.out.println(longestPalindromeSubseqDp(s));
        System.out.println(longestPalindromeSubseqSpaceOptimization(s));
        // Print palindrome
        System.out.println(longestPalindromeSubseqPrint(s));
    }

    public static int longestPalindromeSubseqRecursion(String s) {
        return helperRecursion(s, s.length() - 1, new StringBuilder(s).reverse().toString(), s.length() - 1);
    }

    public static int helperRecursion(String s1, int index1, String s2, int index2) {
        if (index1 < 0 || index2 < 0) {
            return 0;
        }

        if (s1.charAt(index1) == s2.charAt(index2)) {
            return 1 + helperRecursion(s1, index1 - 1, s2, index2 - 1);
        }

        return 0 + Math.max(helperRecursion(s1, index1 - 1, s2, index2), helperRecursion(s1, index1, s2, index2 - 1));
    }

    public static int longestPalindromeSubseqMemoization(String s) {
        String rev = new StringBuilder(s).reverse().toString();
        int[][] memo = new int[s.length()][rev.length()];
        for (int[] is : memo) {
            Arrays.fill(is, -1);
        }

        return helperMemoization(s, s.length() - 1, rev, rev.length() - 1, memo);
    }

    public static int helperMemoization(String s1, int index1, String s2, int index2, int[][] memo) {
        if (index1 < 0 || index2 < 0) {
            return 0;
        }

        if (memo[index1][index2] != -1) {
            return memo[index1][index2];
        }

        if (s1.charAt(index1) == s2.charAt(index2)) {
            return memo[index1][index2] = 1 + helperMemoization(s1, index1 - 1, s2, index2 - 1, memo);
        }

        return memo[index1][index2] = 0 + Math.max(helperMemoization(s1, index1 - 1, s2, index2, memo),
                helperMemoization(s1, index1, s2, index2 - 1, memo));
    }

    public static int longestPalindromeSubseqDp(String s) {
        String s1 = s;
        String s2 = new StringBuilder(s).reverse().toString();

        int n = s1.length();
        int m = s2.length();
        int[][] dp = new int[n + 1][m + 1];

        for (int index1 = 1; index1 <= n; index1++) {
            for (int index2 = 1; index2 <= m; index2++) {
                if (s1.charAt(index1 - 1) == s2.charAt(index2 - 1)) {
                    dp[index1][index2] = 1 + dp[index1 - 1][index2 - 1];
                } else {
                    dp[index1][index2] = 0 + Math.max(dp[index1 - 1][index2], dp[index1][index2 - 1]);
                }
            }
        }

        return dp[n][m];
    }

    public static int longestPalindromeSubseqSpaceOptimization(String s) {
        String s1 = s;
        String s2 = new StringBuilder(s).reverse().toString();
        int n = s1.length();
        int m = s2.length();
        int[] prev = new int[m + 1];

        for (int index1 = 1; index1 <= n; index1++) {
            int[] curr = new int[m + 1];
            for (int index2 = 1; index2 <= m; index2++) {
                if (s1.charAt(index1 - 1) == s2.charAt(index2 - 1)) {
                    curr[index2] = 1 + prev[index2 - 1];
                } else {
                    curr[index2] = 0 + Math.max(prev[index2], curr[index2 - 1]);
                }
            }
            prev = curr;
        }

        return prev[m];
    }

    public static String longestPalindromeSubseqPrint(String s) {
        String s1 = s;
        String s2 = new StringBuilder(s).reverse().toString();
        int n = s1.length();
        int m = s2.length();
        int[][] dp = new int[n + 1][m + 1];

        for (int index1 = 1; index1 <= n; index1++) {
            for (int index2 = 1; index2 <= m; index2++) {
                if (s1.charAt(index1 - 1) == s2.charAt(index2 - 1)) {
                    dp[index1][index2] = 1 + dp[index1 - 1][index2 - 1];
                } else {
                    dp[index1][index2] = 0 + Math.max(dp[index1 - 1][index2], dp[index1][index2 - 1]);
                }
            }
        }

        String palindromeSubsequence = "";
        int palindromeSubsequenceLength = dp[n][m];
        int i = n;
        int j = m;
        while (palindromeSubsequence.length() < palindromeSubsequenceLength || (i > 0 && j > 0)) {
            if (dp[i - 1][j - 1] != 0) {
                palindromeSubsequence = s1.charAt(i - 1) + palindromeSubsequence;
                i--;
                j--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                i--;
            } else {
                j--;
            }
        }

        return palindromeSubsequence;
    }
}

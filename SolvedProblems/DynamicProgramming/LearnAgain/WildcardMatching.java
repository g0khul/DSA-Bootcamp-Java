import java.util.Arrays;

public class WildcardMatching {
    public static void main(String[] args) {
        String s1 = "aa";
        String s2 = "*";
        System.out.println(isMatchRecursion(s1, s2));
        System.out.println(isMatchMemoization(s1, s2));
        // -1 based indexing
        System.out.println(isMatchDp(s1, s2));
        System.out.println(isMatchSpaceOptimization(s1, s2));
    }

    public static boolean isMatchRecursion(String s1, String s2) {
        return helperRecursion(s1, s1.length() - 1, s2, s2.length() - 1);
    }

    public static boolean helperRecursion(String s1, int index1, String s2, int index2) {
        if (index1 < 0 && index2 < 0) {
            return true;
        }

        if (index2 < 0) {
            return false;
        }

        if (index1 < 0) {
            while (index2 >= 0) {
                if (s2.charAt(index2) != '*') {
                    return false;
                }
                index2--;
            }
            return true;
        }

        if (s2.charAt(index2) == '?' || s1.charAt(index1) == s2.charAt(index2)) {
            return helperRecursion(s1, index1 - 1, s2, index2 - 1);
        }

        if (s2.charAt(index2) == '*') {
            boolean followStar = helperRecursion(s1, index1 - 1, s2, index2);
            boolean notFollowStar = helperRecursion(s1, index1, s2, index2 - 1);
            return followStar || notFollowStar;
        }

        return false;
    }

    public static boolean isMatchMemoization(String s1, String s2) {
        int[][] memo = new int[s1.length()][s2.length()];
        for (int[] is : memo) {
            Arrays.fill(is, -1);
        }

        return helperMemoization(s1, s1.length() - 1, s2, s2.length() - 1, memo) == 1;
    }

    public static int helperMemoization(String s1, int index1, String s2, int index2, int[][] memo) {
        if (index1 < 0 && index2 < 0) {
            return 1;
        }

        if (index2 < 0) {
            return -1;
        }

        if (index1 < 0) {
            while (index2 >= 0) {
                if (s2.charAt(index2) != '*') {
                    return 0;
                }
                index2--;
            }
            return 1;
        }

        if (memo[index1][index2] != -1) {
            return memo[index1][index2];
        }

        if (s2.charAt(index2) == '?' || s1.charAt(index1) == s2.charAt(index2)) {
            return memo[index1][index2] = helperMemoization(s1, index1 - 1, s2, index2 - 1, memo);
        }

        if (s2.charAt(index2) == '*') {
            int useStar = helperMemoization(s1, index1, s2, index2 - 1, memo);
            int notUseStar = helperMemoization(s1, index1 - 1, s2, index2, memo);
            return memo[index1][index2] = (useStar == 1 || notUseStar == 1) ? 1 : 0;
        }

        return 0;
    }

    public static boolean isMatchDp(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int[][] dp = new int[n + 1][m + 1];
        dp[0][0] = 1;
        for (int index1 = 1; index1 <= n; index1++) {
            dp[index1][0] = 0;
        }

        for (int index2 = 1; index2 <= m; index2++) {
            if (s2.charAt(index2 - 1) == '*') {
                dp[0][index2] = 1;
            } else {
                dp[0][index2] = 0;
                break;
            }
        }

        for (int index1 = 1; index1 <= n; index1++) {
            for (int index2 = 1; index2 <= m; index2++) {
                if (s1.charAt(index1 - 1) == s2.charAt(index2 - 1) || s2.charAt(index2 - 1) == '?') {
                    dp[index1][index2] = dp[index1 - 1][index2 - 1];
                } else if (s2.charAt(index2 - 1) == '*') {
                    int useStar = dp[index1][index2 - 1];
                    int notUseStar = dp[index1 - 1][index2];
                    dp[index1][index2] = (useStar == 1 || notUseStar == 1) ? 1 : 0;
                } else {
                    dp[index1][index2] = 0;
                }
            }
        }

        return dp[n][m] == 1;
    }

    public static boolean isMatchSpaceOptimization(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int[] prev = new int[m + 1];
        prev[0] = 1;
        for (int index2 = 1; index2 <= m; index2++) {
            if (s2.charAt(index2 - 1) == '*') {
                prev[index2] = 1;
            } else {
                prev[index2] = 0;
                break;
            }
        }

        for (int index1 = 1; index1 <= n; index1++) {
            int[] curr = new int[m + 1];
            for (int index2 = 1; index2 <= m; index2++) {
                if (s1.charAt(index1 - 1) == s2.charAt(index2 - 1) || s2.charAt(index2 - 1) == '?') {
                    curr[index2] = prev[index2 - 1];
                } else if (s2.charAt(index2 - 1) == '*') {
                    int useStar = curr[index2 - 1];
                    int notUseStar = prev[index2];
                    curr[index2] = (useStar == 1 || notUseStar == 1) ? 1 : 0;
                }
            }
            prev = curr;
        }

        return prev[m] == 1;
    }
}

import java.util.Arrays;

public class LongestCommonSubsequence {
    public static void main(String[] args) {
        String text1 = "abcde";
        String text2 = "ace";
        System.out.println(longestCommonSubsequenceRecursion(text1, text2));
        System.out.println(longestCommonSubsequenceRecursion2(text1, text2));
        System.out.println(longestCommonSubsequenceMemoization(text1, text2));
        // With shifting index
        System.out.println(longestCommonSubsequenceDp(text1, text2));
        System.out.println(longestCommonSubsequenceSpaceOptimization(text1, text2));
        // Print subsequence
        System.out.println(longestCommonSubsequenceDpPrint(text1, text2));
    }

    public static int longestCommonSubsequenceRecursion(String text1, String text2) {
        if (text1.isEmpty() || text2.isEmpty()) {
            return 0;
        }

        if (text1.charAt(text1.length() - 1) == text2.charAt(text2.length() - 1)) {
            return 1 + longestCommonSubsequenceRecursion(text1.substring(0, text1.length() - 1),
                    text2.substring(0, text2.length() - 1));
        }

        int moveText1 = longestCommonSubsequenceRecursion(text1.substring(0, text1.length() - 1), text2);
        int moveText2 = longestCommonSubsequenceRecursion(text1, text2.substring(0, text2.length() - 1));

        return 0 + Math.max(moveText1, moveText2);
    }

    public static int longestCommonSubsequenceRecursion2(String text1, String text2) {
        return helperRecursion2(text1, text1.length() - 1, text2, text2.length() - 1);
    }

    public static int helperRecursion2(String text1, int index1, String text2, int index2) {
        if (index1 < 0 || index2 < 0) {
            return 0;
        }

        if (text1.charAt(index1) == text2.charAt(index2)) {
            return 1 + helperRecursion2(text1, index1 - 1, text2, index2 - 1);
        }

        return Math.max(helperRecursion2(text1, index1 - 1, text2, index2),
                helperRecursion2(text1, index1, text2, index2 - 1));
    }

    public static int longestCommonSubsequenceMemoization(String text1, String text2) {
        int[][] memo = new int[text1.length()][text2.length()];
        for (int[] is : memo) {
            Arrays.fill(is, -1);
        }

        return helperMemoization(text1, text1.length() - 1, text2, text2.length() - 1, memo);
    }

    public static int helperMemoization(String text1, int index1, String text2, int index2, int[][] memo) {
        if (index1 < 0 || index2 < 0) {
            return 0;
        }

        if (memo[index1][index2] != -1) {
            return memo[index1][index2];
        }

        if (text1.charAt(index1) == text2.charAt(index2)) {
            return memo[index1][index2] = 1 + helperMemoization(text1, index1 - 1, text2, index2 - 1, memo);
        }

        return memo[index1][index2] = 0 + Math.max(helperMemoization(text1, index1 - 1, text2, index2, memo),
                helperMemoization(text1, index1, text2, index2 - 1, memo));
    }

    public static int longestCommonSubsequenceDp(String text1, String text2) {
        // treating -1 index as 0 and 1st index as 0 and so on
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];
        for (int[] is : dp) {
            Arrays.fill(is, -1);
        }

        for (int j = 0; j <= text2.length(); j++) {
            dp[0][j] = 0;
        }

        for (int i = 0; i <= text1.length(); i++) {
            dp[i][0] = 0;
        }

        for (int i = 1; i <= text1.length(); i++) {
            for (int j = 1; j <= text2.length(); j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 0 + Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[text1.length()][text2.length()];
    }

    public static int longestCommonSubsequenceSpaceOptimization(String text1, String text2) {
        int[] prev = new int[text2.length() + 1];

        for (int i = 1; i <= text1.length(); i++) {
            int[] curr = new int[text2.length() + 1];
            for (int j = 1; j <= text2.length(); j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    curr[j] = 1 + prev[j - 1];
                } else {
                    curr[j] = 0 + Math.max(prev[j], curr[j - 1]);
                }
            }
            prev = curr;
        }

        return prev[text2.length()];
    }

    public static String longestCommonSubsequenceDpPrint(String text1, String text2) {
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];

        for (int index1 = 1; index1 <= text1.length(); index1++) {
            for (int index2 = 1; index2 <= text2.length(); index2++) {
                if (text1.charAt(index1 - 1) == text2.charAt(index2 - 1)) {
                    dp[index1][index2] = 1 + dp[index1 - 1][index2 - 1];
                } else {
                    dp[index1][index2] = 0 + Math.max(dp[index1 - 1][index2], dp[index1][index2 - 1]);
                }
            }
        }

        String lcs = "";
        int lcsLength = dp[text1.length()][text2.length()];
        int index1 = text1.length();
        int index2 = text2.length();
        while (lcs.length() < lcsLength || (index1 > 0 && index2 > 0)) {
            if (text1.charAt(index1 - 1) == text2.charAt(index2 - 1)) {
                lcs = text1.charAt(index1 - 1) + lcs;
                index1--;
                index2--;
            } else if (dp[index1 - 1][index2] > dp[index1][index2 - 1]) {
                index1--;
            } else {
                index2--;
            }
        }

        return lcs;
    }
}

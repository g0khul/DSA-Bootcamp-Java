public class LongestCommonSubstring {
    public static void main(String[] args) {
        // Refer LongestCommonSubsequence to know how this works
        String s1 = "ABCDGH";
        String s2 = "ACDGHR";
        System.out.println(longestCommonSubstr(s1, s2, s1.length(), s2.length()));
    }

    public static int longestCommonSubstr(String s1, String s2, int n, int m) {
        int[][] dp = new int[n + 1][m + 1];
        int max = 0;
        for (int index1 = 1; index1 <= n; index1++) {
            for (int index2 = 1; index2 <= m; index2++) {
                if (s1.charAt(index1 - 1) == s2.charAt(index2 - 1)) {
                    dp[index1][index2] = 1 + dp[index1 - 1][index2 - 1];
                    max = Math.max(max, dp[index1][index2]);
                }
            }
        }
        return max;
    }
}

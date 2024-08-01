public class ShortestCommonSupersequence {
    public static void main(String[] args) {
        String s1 = "bleed";
        String s2 = "blue";
        System.out.println(shortestCommonSupersequenceDp(s1, s2));
    }

    public static String shortestCommonSupersequenceDp(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();
        int[][] dp = new int[n + 1][m + 1];

        for (int index1 = 1; index1 <= n; index1++) {
            for (int index2 = 1; index2 <= m; index2++) {
                if (str1.charAt(index1 - 1) == str2.charAt(index2 - 1)) {
                    dp[index1][index2] = 1 + dp[index1 - 1][index2 - 1];
                } else {
                    dp[index1][index2] = 0 + Math.max(dp[index1 - 1][index2], dp[index1][index2 - 1]);
                }
            }
        }

        StringBuilder result = new StringBuilder();
        int i = n;
        int j = m;
        while (i > 0 && j > 0) {
            if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                result.insert(0, str1.charAt(i - 1));
                i--;
                j--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                result.insert(0, str1.charAt(i - 1));
                i--;
            } else {
                result.insert(0, str2.charAt(j - 1));
                j--;
            }
        }

        while (i != 0) {
            result.insert(0, str1.charAt(i - 1));
            i--;
        }

        while (j != 0) {
            result.insert(0, str2.charAt(j - 1));
            j--;
        }

        return result.toString();
    }
}

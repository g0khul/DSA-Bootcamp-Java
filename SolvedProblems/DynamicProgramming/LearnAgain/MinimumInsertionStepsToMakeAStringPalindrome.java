public class MinimumInsertionStepsToMakeAStringPalindrome {
    public static void main(String[] args) {
        // Intuition : max is to repeat the String twice i.e. n intertions min will be
        // n - longest palindromic subsequence
        // Refer LPS for recursion, memoization and Dp
        String s = "leetcode";
        System.out.println(minInsertionsSpaceOptimization(s));
    }

    public static int minInsertionsSpaceOptimization(String s) {
        String s1 = s;
        String s2 = new StringBuilder(s).reverse().toString();
        int n = s1.length();
        int m = s2.length();

        int[] prev = new int[m + 1];
        for (int j = 0; j < prev.length; j++) {
            prev[j] = 0;
        }

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

        return n - prev[m];
    }
}

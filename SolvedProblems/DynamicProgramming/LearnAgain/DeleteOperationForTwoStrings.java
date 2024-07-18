public class DeleteOperationForTwoStrings {
    public static void main(String[] args) {
        // Intuition, delete few and add few chars so
        // how much chars to be deleted? word1.length() - LCS(word1, word2)
        // how much chars to be inserted? word2.length() - LCS(word1, word2)
        String word1 = "sea";
        String word2 = "eat";
        System.out.println(minDistanceSpaceOptimization(word1, word2));
    }

    public static int minDistanceSpaceOptimization(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int[] prev = new int[m + 1];

        for (int j = 0; j < prev.length; j++) {
            prev[j] = 0;
        }

        for (int index1 = 1; index1 <= n; index1++) {
            int[] curr = new int[m + 1];
            for (int index2 = 1; index2 <= m; index2++) {
                if (word1.charAt(index1 - 1) == word2.charAt(index2 - 1)) {
                    curr[index2] = 1 + prev[index2 - 1];
                } else {
                    curr[index2] = 0 + Math.max(prev[index2], curr[index2 - 1]);
                }
            }
            prev = curr;
        }

        int deletions = n - prev[m];
        int insertions = m - prev[m];
        return deletions + insertions;
    }
}

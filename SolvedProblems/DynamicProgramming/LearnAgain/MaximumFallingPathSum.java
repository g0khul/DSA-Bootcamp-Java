import java.lang.classfile.constantpool.IntegerEntry;
import java.util.Arrays;

public class MaximumFallingPathSum {
    static int count = 1;

    public static void main(String[] args) {
        int[][] matrix = {
                { 1, 2, 10, 4 },
                { 100, 3, 2, 1 },
                { 1, 1, 20, 2 },
                { 1, 2, 2, 1 }
        };

        System.out.println(getMaxPathSumRecursion(matrix));
        System.out.println(getMaxPathSumMemoization(matrix));
        System.out.println(getMaxPathDp(matrix));
        System.out.println(getMaxPathDpSpaceOptimization(matrix));
    }

    public static int getMaxPathSumRecursion(int[][] matrix) {
        count = 1;
        int maxPath = Integer.MIN_VALUE;
        System.out.println("------------------------------------");

        for (int i = 0; i < matrix[0].length; i++) {
            int currPath = helperRecursion(matrix, matrix.length - 1, i);
            maxPath = Math.max(maxPath, currPath);
        }

        return maxPath;
    }

    public static int helperRecursion(int[][] matrix, int i, int j) {
        if (j < 0 || j > matrix[0].length - 1) {
            return Integer.MIN_VALUE;
        }

        if (i == 0) {
            return matrix[i][j];
        }

        // System.out.println(count++);

        int up = helperRecursion(matrix, i - 1, j);
        int leftDiagnol = helperRecursion(matrix, i - 1, j - 1);
        int rightDiagnol = helperRecursion(matrix, i - 1, j + 1);

        return matrix[i][j] + Math.max(up, Math.max(leftDiagnol, rightDiagnol));
    }

    public static int getMaxPathSumMemoization(int[][] matrix) {
        System.out.println("------------------------------------");
        count = 0;
        int[][] memo = new int[matrix.length][matrix[0].length];
        for (int[] is : memo) {
            Arrays.fill(is, -1);
        }

        int maxPath = Integer.MIN_VALUE;
        for (int i = 0; i < matrix[0].length; i++) {
            int currPath = helperMemoization(matrix, matrix.length - 1, i, memo);
            maxPath = Integer.max(maxPath, currPath);
        }

        return maxPath;
    }

    public static int helperMemoization(int[][] matrix, int i, int j, int[][] memo) {
        if (j < 0 || j > matrix[0].length - 1) {
            return Integer.MIN_VALUE;
        }

        if (i == 0) {
            return matrix[i][j];
        }

        if (memo[i][j] != -1) {
            return memo[i][j];
        }

        // System.out.println(count++);
        int up = helperMemoization(matrix, i - 1, j, memo);
        int leftDiagnol = helperMemoization(matrix, i - 1, j - 1, memo);
        int rightDiagnol = helperMemoization(matrix, i - 1, j + 1, memo);

        return memo[i][j] = matrix[i][j] + Math.max(up, Math.max(leftDiagnol, rightDiagnol));
    }

    public static int getMaxPathDp(int[][] matrix) {
        int maxPath = Integer.MIN_VALUE;
        int[][] dp = new int[matrix.length][matrix[0].length];

        for (int i = 0; i < matrix[0].length; i++) {
            dp[0][i] = matrix[0][i];
        }

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                int up = Integer.MIN_VALUE;
                int rightDiagnol = Integer.MIN_VALUE;
                int leftDiagnol = Integer.MIN_VALUE;

                if (i - 1 >= 0) {
                    up = dp[i - 1][j];
                }

                if (i - 1 >= 0 && j - 1 >= 0) {
                    leftDiagnol = dp[i - 1][j - 1];
                }

                if (i - 1 >= 0 && j + 1 < matrix[0].length) {
                    rightDiagnol = dp[i - 1][j + 1];
                }

                dp[i][j] = matrix[i][j] + Math.max(up, Math.max(leftDiagnol, rightDiagnol));
            }
        }

        for (int i = 0; i < dp[0].length; i++) {
            maxPath = Math.max(maxPath, dp[dp.length - 1][i]);
        }

        return maxPath;
    }

    public static int getMaxPathDpSpaceOptimization(int[][] matrix) {
        int[] prev = new int[matrix[0].length];
        int maxPath = 0;

        for (int i = 0; i < matrix[0].length; i++) {
            prev[i] = matrix[0][i];
        }

        for (int i = 1; i < matrix.length; i++) {
            int[] curr = new int[matrix[0].length];
            for (int j = 0; j < matrix[0].length; j++) {
                int up = Integer.MIN_VALUE;
                int rightDiagnol = Integer.MIN_VALUE;
                int leftDiagnol = Integer.MIN_VALUE;

                if (i - 1 >= 0) {
                    up = prev[j];
                }

                if (i - 1 >= 0 && j - 1 >= 0) {
                    leftDiagnol = prev[j - 1];
                }

                if (i - 1 >= 0 && j + 1 < matrix[0].length) {
                    rightDiagnol = prev[j + 1];
                }

                curr[j] = matrix[i][j] + Math.max(up, Math.max(leftDiagnol, rightDiagnol));
            }
            prev = curr;
        }

        for (int i : prev) {
            maxPath = Math.max(maxPath, i);
        }
        return maxPath;
    }
}

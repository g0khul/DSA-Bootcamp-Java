import java.util.Arrays;

public class CountSquareSubmatricesWithAllOnes {
    public static void main(String[] args) {
        int[][] matrix = {
                { 0, 1, 1, 1 },
                { 1, 1, 1, 1 },
                { 0, 1, 1, 1 }
        };
        System.out.println(countSquares(matrix));
    }

    public static int countSquares(int[][] matrix) {
        int[][] dp = new int[matrix.length][matrix[0].length];

        // Fill first row
        for (int i = 0; i < matrix[0].length; i++) {
            dp[0][i] = matrix[0][i];
        }

        // Fill first col
        for (int i = 0; i < matrix.length; i++) {
            dp[i][0] = matrix[i][0];
        }

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j], Math.min(dp[i - 1][j - 1], dp[i][j - 1]));
                }
            }
        }

        int sum = 0;
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                sum += dp[i][j];
            }
        }

        return sum;
    }
}

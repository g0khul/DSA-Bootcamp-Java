package Array;

import java.util.Arrays;

public class SetZeros {
    public static void main(String[] args) {
        int[][] nums = {
                { 0, 1, 2, 0 },
                { 3, 4, 5, 2 },
                { 1, 3, 1, 5 }
        };

        setZeroes(nums);

        for (int[] n : nums) {
            System.out.println(Arrays.toString(n));
        }
    }

    public static void setZeroes(int[][] matrix) {
        // Brute force approach
        // helper(matrix, 0, 0);

        boolean r = false;
        boolean c = false;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    if (i == 0) {
                        c = true;
                    }

                    if (j == 0) {
                        r = true;
                    }

                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[i].length; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        if (r) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }

        if (c) {
            for (int i = 0; i < matrix[0].length; i++) {
                matrix[0][i] = 0;
            }
        }
    }

    private static void helper(int[][] matrix, int r, int c) {
        if (c == matrix[r].length) {
            r++;
            c = 0;
        }

        if (r == matrix.length) {
            return;
        }

        if (matrix[r][c] == 0) {
            helper(matrix, r, c + 1);
            changeZero(matrix, r, c);
        } else {
            helper(matrix, r, c + 1);
        }
    }

    private static void changeZero(int[][] matrix, int r, int c) {
        // Change row
        for (int column = 0; column < matrix[r].length; column++) {
            matrix[r][column] = 0;
        }

        // Change column
        for (int[] m : matrix) {
            m[c] = 0;
        }
    }
}

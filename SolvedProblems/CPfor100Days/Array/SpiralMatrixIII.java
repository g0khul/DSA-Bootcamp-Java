package Array;

import java.util.Arrays;

public class SpiralMatrixIII {
    public static void main(String[] args) {
        int[][] result = spiralMatrixIII(5, 6, 1, 4);
        for (int[] n : result) {
            System.out.println(Arrays.toString(n));
        }
    }

    public static int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        int[][] result = new int[rows * cols][2];
        result[0][0] = rStart;
        result[0][1] = cStart;

        int r = 1;
        int steps = 1;
        while (r < rows * cols) {
            // Move right
            for (int i = 0; i < steps; i++) {
                cStart++;
                if (rStart >= 0 && rStart < rows && cStart >= 0 && cStart < cols) {
                    result[r][0] = rStart;
                    result[r][1] = cStart;
                    r++;
                }
            }

            // Move Down
            for (int i = 0; i < steps; i++) {
                rStart++;
                if (rStart >= 0 && rStart < rows && cStart >= 0 && cStart < cols) {
                    result[r][0] = rStart;
                    result[r][1] = cStart;
                    r++;
                }
            }
            steps++;

            // Move Left
            for (int i = 0; i < steps; i++) {
                cStart--;
                if (rStart >= 0 && rStart < rows && cStart >= 0 && cStart < cols) {
                    result[r][0] = rStart;
                    result[r][1] = cStart;
                    r++;
                }
            }

            // Move Up
            for (int i = 0; i < steps; i++) {
                rStart--;
                if (rStart >= 0 && rStart < rows && cStart >= 0 && cStart < cols) {
                    result[r][0] = rStart;
                    result[r][1] = cStart;
                    r++;
                }
            }
            steps++;
        }

        return result;
    }
}

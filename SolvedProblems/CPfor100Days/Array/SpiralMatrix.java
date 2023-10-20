package Array;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public static void main(String[] args) {
        int[][] matrix = {
                { 1, 2, 3, 4, 5 },
                { 6, 7, 8, 9, 10 },
                { 16, 17, 18, 19, 20 },
                { 11, 12, 13, 14, 15 }
        };

        System.out.println(spiralOrder(matrix));
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();

        int top = 0;
        int bottom = matrix.length;
        int left = 0;
        int right = matrix[0].length;

        while (left < right && top < bottom) {
            // Move right
            for (int i = left; i < right; i++) {
                result.add(matrix[top][i]);
            }
            top++;

            // Move bottom
            for (int i = top; i < bottom; i++) {
                result.add(matrix[i][right - 1]);
            }
            right--;

            if (!(left < right && top < bottom)) {
                break;
            }

            // Move left
            for (int i = right - 1; i >= left; i--) {
                result.add(matrix[bottom - 1][i]);
            }
            bottom--;

            // Move top
            for (int i = bottom - 1; i >= top; i--) {
                result.add(matrix[i][left]);
            }
            left++;
        }

        return result;
    }
}

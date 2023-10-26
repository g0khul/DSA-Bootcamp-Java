package Array;

import java.util.Arrays;

public class SpiralMatrixII {
    public static void main(String[] args) {
        int[][] result = generateMatrix(3);

        for (int[] nums : result) {
            System.out.println(Arrays.toString(nums));
        }
    }

    public static int[][] generateMatrix(int n) {
        int[][] nums = new int[n][n];

        int top = 0;
        int bottom = nums.length;
        int left = 0;
        int right = nums[0].length;
        int filler = 1;

        while (left < right && top < bottom) {
            // Move right
            for (int i = left; i < right; i++) {
                nums[top][i] = filler++;
            }
            top++;

            // Move bottom
            for (int i = top; i < bottom; i++) {
                nums[i][right - 1] = filler++;
            }
            right--;

            if (!(left < right && top < bottom)) {
                break;
            }

            // Move left
            for (int i = right - 1; i >= left; i--) {
                nums[bottom - 1][i] = filler++;
            }
            bottom--;

            // Move up
            for (int i = bottom - 1; i >= top; i--) {
                nums[i][left] = filler++;
            }
            left++;
        }

        return nums;
    }
}

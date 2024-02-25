import java.util.Arrays;

public class DiagonalTraverse {
    public static void main(String[] args) {
        int[][] mat = {
                { 1, 2, 3, 4 },
                { 5, 6, 7, 8 },
                { 9, 10, 11, 12 }
        };

        int[] result = findDiagonalOrder(mat);
        System.out.println(Arrays.toString(result));
    }

    public static int[] findDiagonalOrder(int[][] mat) {
        int row = 0;
        int col = 0;
        int rowLength = mat.length;
        int colLength = mat[0].length;
        int index = 0;
        boolean up = true;
        int[] result = new int[rowLength * colLength];

        while (row < rowLength && col < colLength) {
            if (up) {
                while (row > 0 && col < colLength - 1) {
                    result[index++] = mat[row][col];
                    row--;
                    col++;
                }
                result[index++] = mat[row][col];

                if (col == colLength - 1) {
                    row++;
                } else {
                    col++;
                }
            } else {
                while (row < rowLength - 1 && col > 0) {
                    result[index++] = mat[row][col];
                    row++;
                    col--;
                }
                result[index++] = mat[row][col];

                if (row == rowLength - 1) {
                    col++;
                } else {
                    row++;
                }
            }
            up = !up;
        }

        return result;
    }
}

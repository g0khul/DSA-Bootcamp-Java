public class MatrixDiagonalSum {
    public static void main(String[] args) {
        int[][] mat = {
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 },
        };

        System.out.println(diagonalSum(mat));
    }

    public static int diagonalSum(int[][] mat) {
        int sum = 0;

        for (int i = 0; i < mat.length; i++) {
            sum = sum + mat[i][i];
        }

        for (int i = 0, j = mat[0].length - 1; i < mat.length && j >= 0; i++, j--) {
            if (i != j) {
                sum = sum + mat[i][j];
            }
        }

        return sum;
    }
}

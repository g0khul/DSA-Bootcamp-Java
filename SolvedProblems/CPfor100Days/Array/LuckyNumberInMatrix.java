package Array;
import java.util.ArrayList;
import java.util.List;

public class LuckyNumberInMatrix {
    public static List<Integer> luckyNumbers(int[][] matrix) {
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (isMin(matrix, matrix[i][j], i)) {
                    if (isMax(matrix, matrix[i][j], j)) {
                        list.add(matrix[i][j]);
                    }
                }
            }
        }

        return list;
    }

    private static boolean isMax(int[][] matrix, int val, int col) {

        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][col] > val) {
                return false;
            }
        }

        return true;
    }

    private static boolean isMin(int[][] matrix, int val, int row) {

        for (int i = 0; i < matrix[row].length; i++) {
            if (matrix[row][i] < val) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int[][] arr = {
                { 1, 10, 4, 2 },
                { 9, 3, 8, 7 },
                { 15, 16, 17, 12 }
        };

        List<Integer> list = luckyNumbers(arr);
        System.out.println(list.toString());
    }
}

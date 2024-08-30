import java.util.HashMap;
import java.util.Map;

public class MaximumValueSumByPlacingThreeRooksI {
    public static void main(String[] args) {
        int[][] board = {
                { -3, 1, 1, 1 },
                { -3, 1, -3, 1 },
                { -3, 2, 1, 1 }
        };
        System.out.println(maximumValueSum(board));
    }

    public static long maximumValueSum(int[][] board) {
        return helperRecursion(board, 3, new HashMap<>());
    }

    public static long helperRecursion(int[][] board, int rookies, Map<String, Integer> hash) {

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                // can place here
                if (rookies != 0 && canPlaceRookieHere(board, i, j, hash)) {
                    String s = i + j + "";
                    hash.put(s, board[i][j]);

                }

            }
        }
    }

    public static boolean canPlaceRookieHere(int[][] board, int row, int col, Map<String, Integer> hash) {
        // Check row
        for (int i = 0; i < board.length; i++) {
            String s = i + col + "";
            if (hash.containsKey(s)) {
                return false;
            }
        }

        // Check col
        for (int i = 0; i < board.length; i++) {
            String s = row + i + "";
            if (hash.containsKey(s)) {
                return false;
            }
        }

        return true;
    }
}

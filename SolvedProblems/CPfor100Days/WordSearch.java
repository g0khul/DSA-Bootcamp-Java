package SolvedProblems.CPfor100Days;

public class WordSearch {
    static int previousRow = -1;
    static int previousCol = -1;
    static boolean firstLetterCatch = true;

    public static boolean exist(char[][] board, String word) {
        boolean[][] marker = new boolean[board.length][board[0].length];

        for (char c : word.toCharArray()) {
            if (!check(board, marker, c)) {
                return false;
            }
        }

        return true;
    }

    public static boolean check(char[][] board, boolean[][] marker, char c) {
        if (firstLetterCatch) {
            // Search everywhere
            for (int row = 0; row < board.length; row++) {
                for (int col = 0; col < board[row].length; col++) {
                    if (board[row][col] == c && !marker[row][col]) {
                        marker[row][col] = true;
                        previousRow = row;
                        previousCol = col;
                        firstLetterCatch = false;
                        return true;
                    }
                }
            }
            return false;
        } else {
            // Search in adjacent
            if ((board[previousRow + 1][previousCol] == c && !marker[previousRow + 1][previousCol])) {
                marker[previousRow + 1][previousCol] = true;
                return true;
            }

            if (board[previousRow - 1][previousCol] == c && !marker[previousRow - 1][previousCol]) {
                marker[previousRow - 1][previousCol] = true;
                return true;
            }

            if (board[previousRow][previousCol + 1] == c && !marker[previousRow][previousCol + 1]) {
                marker[previousRow][previousCol + 1] = true;
                return true;
            }

            if (board[previousRow][previousCol - 1] == c && !marker[previousRow][previousCol - 1]) {
                marker[previousRow][previousCol - 1] = true;
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        char[][] board = {
                { 'A', 'B', 'C', 'E' },
                { 'S', 'F', 'C', 'S' },
                { 'A', 'D', 'E', 'E' }
        };

        String word = "ABCCED";

        System.out.println(exist(board, word));
    }
}

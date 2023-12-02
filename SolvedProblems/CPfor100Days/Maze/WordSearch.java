package CPfor100Days.Maze;

public class WordSearch {
    static int previousRow = -1;
    static int previousCol = -1;
    static boolean firstLetterCatch = true;

    // public static boolean exist(char[][] board, String word) {
    // boolean[][] marker = new boolean[board.length][board[0].length];

    // for (char c : word.toCharArray()) {
    // if (!check(board, marker, c)) {
    // return false;
    // }
    // }

    // return true;
    // }

    // public static boolean check(char[][] board, boolean[][] marker, char c) {
    // if (firstLetterCatch) {
    // // Search everywhere
    // for (int row = 0; row < board.length; row++) {
    // for (int col = 0; col < board[row].length; col++) {
    // if (board[row][col] == c && !marker[row][col]) {
    // marker[row][col] = true;
    // previousRow = row;
    // previousCol = col;
    // firstLetterCatch = false;
    // return true;
    // }
    // }
    // }
    // return false;
    // } else {
    // // Search in adjacent
    // if (previousRow + 1 < board.length) {
    // if ((board[previousRow + 1][previousCol] == c && !marker[previousRow +
    // 1][previousCol])) {
    // marker[previousRow + 1][previousCol] = true;
    // previousRow += 1;
    // return true;
    // }
    // }

    // if (previousRow - 1 >= 0) {
    // if (board[previousRow - 1][previousCol] == c && !marker[previousRow -
    // 1][previousCol]) {
    // marker[previousRow - 1][previousCol] = true;
    // previousRow -= 1;
    // return true;
    // }
    // }

    // if (previousCol + 1 < board[previousRow].length) {
    // if (board[previousRow][previousCol + 1] == c &&
    // !marker[previousRow][previousCol + 1]) {
    // marker[previousRow][previousCol + 1] = true;
    // previousCol += 1;
    // return true;
    // }
    // }

    // if (previousCol - 1 >= 0) {
    // if (board[previousRow][previousCol - 1] == c &&
    // !marker[previousRow][previousCol - 1]) {
    // marker[previousRow][previousCol - 1] = true;
    // previousCol -= 1;
    // return true;
    // }
    // }
    // }

    // return false;
    // }

    public static boolean exist(char[][] board, String word) {
        boolean[][] marker = new boolean[board.length][board[0].length];

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                if (board[row][col] == word.charAt(0) && boardChecking(board, marker, word, row, col, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    private static boolean boardChecking(char[][] board, boolean[][] marker, String word, int row, int col, int index) {
        if (index == word.length()) {
            return true;
        }

        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length || marker[row][col]) {
            return false;
        }

        if (board[row][col] != word.charAt(index)) {
            return false;
        }

        marker[row][col] = true;

        boolean flag = 
                boardChecking(board, marker, word, row + 1, col, index + 1) ||
                boardChecking(board, marker, word, row - 1, col, index + 1) ||
                boardChecking(board, marker, word, row, col + 1, index + 1) ||
                boardChecking(board, marker, word, row, col - 1, index + 1);

        marker[row][col] = false;

        return flag;
    }

    public static void main(String[] args) {
        char[][] board = {
                { 'A', 'B', 'C', 'E' },
                { 'S', 'F', 'C', 'S' },
                { 'A', 'D', 'E', 'E' }
        };

        String word1 = "ABCCED";
        String word2 = "SEE";
        String word3 = "ABCB";

        System.out.println(exist(board, word1)); // Output: true
        System.out.println(exist(board, word2)); // Output: true
        System.out.println(exist(board, word3)); // Output: false

    }
}

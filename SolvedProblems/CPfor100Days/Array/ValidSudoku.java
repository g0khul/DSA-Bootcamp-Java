package CPfor100Days.Array;

public class ValidSudoku {
    public static void main(String[] args) {
        char[][] board = {
                { '5', '3', '.', '.', '7', '.', '.', '.', '.' },
                { '6', '.', '.', '1', '9', '5', '.', '.', '.' },
                { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
                { '8', '.', '.', '.', '6', '.', '.', '.', '3' },
                { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
                { '7', '.', '.', '.', '2', '.', '.', '.', '6' },
                { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
                { '.', '.', '.', '4', '1', '9', '.', '.', '5' },
                { '.', '.', '.', '.', '8', '.', '.', '7', '9' }
        };

        System.out.println(isValidSudoku(board));
    }

    public static boolean isValidSudoku(char[][] board) {
        // Iterate board and find non-empty element
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                if (board[row][col] != '.') {
                    if (!isValidElement(board, board[row][col], row, col)) {
                        return false;
                    }
                }
            }
        }

        return true;
    }

    private static boolean isValidElement(char[][] board, char num, int row, int col) {
        // Check row
        for (int c = 0; c < board[row].length; c++) {
            if (c != col && board[row][c] == num) {
                return false;
            }
        }

        // Check col
        for (int r = 0; r < board.length; r++) {
            if (r != row && board[r][col] == num) {
                return false;
            }
        }

        // Check box
        int sqrt = (int) Math.sqrt(board.length);
        int rowStart = row - (row % sqrt);
        int colStart = col - (col % sqrt);

        for (int r = rowStart; r < rowStart + sqrt; r++) {
            for (int c = colStart; c < colStart + sqrt; c++) {
                if (r != row && c != col && board[r][c] == num) {
                    return false;
                }
            }
        }

        return true;
    }
}

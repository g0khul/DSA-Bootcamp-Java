package CPfor100Days.Recursion;

import java.util.Arrays;

public class SudokuSolver {
    public static void main(String[] args) {
        char[][] board = new char[][] {
                { '3', '.', '6', '5', '.', '8', '4', '.', '.' },
                { '5', '2', '.', '.', '.', '.', '.', '.', '.' },
                { '.', '8', '7', '.', '.', '.', '.', '3', '1' },
                { '.', '.', '3', '.', '1', '.', '.', '8', '.' },
                { '9', '.', '.', '8', '6', '3', '.', '.', '5' },
                { '.', '5', '.', '.', '9', '.', '6', '.', '.' },
                { '1', '3', '.', '.', '.', '.', '2', '5', '.' },
                { '.', '.', '.', '.', '.', '.', '.', '7', '4' },
                { '.', '.', '5', '2', '.', '6', '3', '.', '.' }
        };

        solveSudoku(board);
        display(board);
    }

    private static void display(char[][] board) {
        for (char[] rows : board) {
            System.out.println(Arrays.toString(rows));
        }
    }

    private static boolean solveSudoku(char[][] board) {
        int row = -1;
        int col = -1;

        boolean emptySpace = false;
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board.length; c++) {
                if (board[r][c] == '.') {
                    row = r;
                    col = c;
                    emptySpace = true;
                    break;
                }
            }
            if (emptySpace) {
                break;
            }
        }

        if (!emptySpace) {
            return true;
        }

        for (char num = '1'; num <= '9'; num++) {
            if (isSafe(board, row, col, num)) {
                board[row][col] = num;
                if (solveSudoku(board)) {
                    return true;
                } else {
                    board[row][col] = '.';
                }
            }
        }

        return false;
    }

    private static boolean isSafe(char[][] board, int row, int col, int num) {
        // Check row
        for (int c = 0; c < board.length; c++) {
            if (board[row][c] == num) {
                return false;
            }
        }

        // Check column
        for (char[] rows : board) {
            if (rows[col] == num) {
                return false;
            }
        }

        // Check box
        int sqrt = (int) Math.sqrt(board.length);
        int rowStart = row - row % sqrt;
        int colStart = col - col % sqrt;

        for (int r = rowStart; r < rowStart + sqrt; r++) {
            for (int c = colStart; c < colStart + sqrt; c++) {
                if (board[r][c] == num) {
                    return false;
                }
            }
        }

        return true;
    }
}

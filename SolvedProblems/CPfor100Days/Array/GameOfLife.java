package CPfor100Days.Array;

import java.util.Arrays;

public class GameOfLife {
    public static void main(String[] args) {
        int[][] board = {
                { 0, 1, 0 },
                { 0, 0, 1 },
                { 1, 1, 1 },
                { 0, 0, 0 }
        };

        gameOfLife(board);

        for (int[] row : board) {
            System.out.println(Arrays.toString(row));
        }
    }

    public static void gameOfLife(int[][] board) {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                board[row][col] = getState(board, row, col);
            }
        }

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                board[row][col] /= 2;
            }
        }
    }

    private static int getState(int[][] board, int row, int col) {
        int decision = 0;
        boolean state = (board[row][col] == 0) ? false : true;

        if (col - 1 >= 0 && (board[row][col - 1] == 1 || board[row][col - 1] == 2)) {
            decision++;
        }

        if (row - 1 >= 0 && col - 1 >= 0 && (board[row - 1][col - 1] == 1 || board[row - 1][col - 1] == 2)) {
            decision++;
        }

        if (row - 1 >= 0 && (board[row - 1][col] == 1 || board[row - 1][col] == 2)) {
            decision++;
        }

        if (row - 1 >= 0 && col + 1 < board[row].length && (board[row - 1][col + 1] == 1
                || board[row - 1][col + 1] == 2)) {
            decision++;
        }

        if (col + 1 < board[row].length && (board[row][col + 1] == 1 || board[row][col + 1] == 2)) {
            decision++;
        }

        if (row + 1 < board.length && col + 1 < board[row].length && (board[row + 1][col + 1] == 1
                || board[row + 1][col + 1] == 2)) {
            decision++;
        }

        if (row + 1 < board.length && (board[row + 1][col] == 1 || board[row + 1][col] == 2)) {
            decision++;
        }

        if (row + 1 < board.length && col - 1 >= 0 && (board[row + 1][col - 1] == 1 || board[row + 1][col - 1] == 2)) {
            decision++;
        }

        if (state && decision != 2 && decision != 3) {
            return 1;
        } else if (state && (decision == 2 || decision == 3)) {
            return 2;
        } else if (!state && decision == 3) {
            return 3;
        }

        return 0;
    }
}

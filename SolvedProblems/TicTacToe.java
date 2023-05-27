package SolvedProblems;

import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Initialized board
        char[][] board = new char[3][3];
        clearBoard(board);

        // Initializing default values
        String player = "Player 1";
        boolean gameOver = false;
        boolean whichPlayer = false;

        while (!gameOver) {
            printBoard(board);
            System.out.println("Please enter a position for " + player + " : ");
            int row = sc.nextInt();
            int col = sc.nextInt();
            if (board[row][col] != ' ') {
                System.out.println("Position is already filled");
                continue;
            } else if (player == "Player 1") {
                board[row][col] = 'X';
            } else if (player == "Player 2") {
                board[row][col] = 'O';
            }

            if (won(player, board, row, col)) {
                System.out.println(player + " won the game. \nDo you want to play again? Y/N ");
                char decision = sc.next().charAt(0);
                if (decision == 'Y') {
                    clearBoard(board);
                    player = "Player 1";
                    continue;
                } else {
                    gameOver = false;
                }
            }

            if (whichPlayer) {
                player = "Player 1";
                whichPlayer = false;
            } else {
                player = "Player 2";
                whichPlayer = true;
            }

        }
        sc.close();
    }

    private static void clearBoard(char[][] board) {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board.length; col++) {
                board[row][col] = ' ';
            }
        }
    }

    private static boolean won(String player, char[][] board, int row, int col) {
        char condition = (player == "Player 1") ? 'X' : 'O';
        int count = 0;
        // Checking for the row
        for (int rowCheck = 0; rowCheck < board.length; rowCheck++) {
            if (board[row][rowCheck] == condition) {
                count++;
            }
        }
        if (count == 3) {
            return true;
        } else {
            count = 0;
        }

        // Checking for the column
        for (int colCheck = 0; colCheck < board.length; colCheck++) {
            if (board[colCheck][col] == condition) {
                count++;
            }
        }
        if (count == 3) {
            return true;
        } else {
            count = 0;
        }

        // Checking the diagnol
        if (row == col) {
            for (int diagRow = 0, diagCol = 0; diagRow < board.length; diagRow++, diagCol++) {
                if (board[diagRow][diagCol] == condition) {
                    count++;
                }
            }
            if (count == 3) {
                return true;
            } else {
                count = 0;
            }
        } else if (row + col == 2) {
            for (int diagRow = 0, diagCol = 2; diagRow < board.length; diagRow++, diagCol--) {
                if (board[diagRow][diagCol] == condition) {
                    count++;
                }
            }
            if (count == 3) {
                return true;
            } else {
                count = 0;
            }
        }

        return false;
    }

    private static void printBoard(char[][] board) {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                if (col == 2) {
                    System.out.print(board[row][col] + " ");
                } else {
                    System.out.print(board[row][col] + " | ");
                }
            }
            System.out.println();
        }
    }
}

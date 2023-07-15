package SolvedProblems.CPfor100Days;

public class WordSearch {
    public static boolean exist(char[][] board, String word) {
        boolean[][] marker = new boolean[board.length][board[0].length];
        String wordCopy = word;

        for (int i = 0; i < wordCopy.length(); i++) {
            char c = wordCopy.charAt(i);
            if(helper(board, marker, c, 0, 0)) {
                word = removeCharacter(word, wordCopy.charAt(i));
            }
        }

        return (word.isEmpty()) ? true : false;
    }

    // public static boolean helper(char[][] board, boolean[][] marker, String word,
    // int row, int col) {
    // if (word.isEmpty()) {
    // return true;
    // }

    // if (row >= board.length && col >= board[0].length) {
    // return false;
    // }

    // int index = doesCharExist(board[row][col], word);

    // if (index != -1 && !marker[row][col]) {
    // word = removeCharacter(word, index);
    // marker[row][col] = true;
    // }

    // if (col < board[0].length) {
    // // Check one row by incrementing column
    // if (helper(board, marker, word, row, col + 1)) {
    // return true;
    // }
    // } else {
    // // Move to the next row
    // if (helper(board, marker, word, row + 1, 0)) {
    // return true;
    // }
    // }

    // return false;
    // }

    // public static int doesCharExist(char letter, String word) {
    // int i = 0;
    // boolean flag = false;
    // for (; i < word.length(); i++) {
    // if (letter == word.charAt(i)) {
    // flag = true;
    // break;
    // }
    // }
    // return (flag) ? i : -1;
    // }

    // public static String removeCharacter(String word, int index) {
    // String newWord = "";
    // for (int j = 0; j < word.length(); j++) {
    // if (j != index) {
    // newWord += word.charAt(j);
    // }
    // }
    // return newWord;
    // }

    private static String removeCharacter(String word, char charAt) {
        String result = "";
        boolean flag = false;

        for(int i = 0; i < word.length(); i++){
            if(word.charAt(i) != charAt && !flag){
                result += word.charAt(i);
            }
        }

        return null;
    }

    private static boolean helper(char[][] board, boolean[][] marker, char letter, int row, int col) {
        if (board[row][col] == letter && !marker[row][col]) {
            marker[row][col] = true;
            return true;
        }
        if (row >= board.length && col >= board[row].length) {
            return false;
        }
        if (col < board[row].length) {
            // Move to every column
            helper(board, marker, letter, row, col + 1);
        }
        if (row < board.length) {
            // Move to the next row
            helper(board, marker, letter, row + 1, 0);
        }

        return true;
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

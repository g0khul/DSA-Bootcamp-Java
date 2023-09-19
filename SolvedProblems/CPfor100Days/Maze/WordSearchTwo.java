package Maze;
import java.util.ArrayList;
import java.util.List;

public class WordSearchTwo {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> list = new ArrayList<>();
        for (String word : words) {
            if (word.length() <= board.length * board[0].length) {
                if (helper(board, word)) {
                    list.add(word);
                }
            }
        }
        return list;
    }

    private boolean helper(char[][] board, String word) {
        boolean[][] marker = new boolean[board.length][board[0].length];

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                if (board[row][col] == word.charAt(0) && checkFollowingWords(board, marker, word, row, col, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean checkFollowingWords(char[][] board, boolean[][] marker, String word, int row, int col, int index) {
        if (index == word.length()) {
            return true;
        }

        if (row < 0 || row == board.length || col < 0 || col == board[0].length || marker[row][col]
                || board[row][col] != word.charAt(index)) {
            return false;
        }

        marker[row][col] = true;

        boolean findNextChar = checkFollowingWords(board, marker, word, row + 1, col, index + 1) ||
                checkFollowingWords(board, marker, word, row - 1, col, index + 1) ||
                checkFollowingWords(board, marker, word, row, col + 1, index + 1) ||
                checkFollowingWords(board, marker, word, row, col - 1, index + 1);

        marker[row][col] = false;

        return findNextChar;
    }

}

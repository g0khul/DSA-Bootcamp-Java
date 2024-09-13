import java.util.*;

public class SurroundedRegions {
    public static void main(String[] args) {
        char[][] board = {
                { 'O', 'X', 'X', 'X' },
                { 'X', 'O', 'O', 'X' },
                { 'X', 'X', 'O', 'X' },
                { 'X', 'O', 'X', 'X' }
        };

        solve(board);

        for (char[] is : board) {
            System.out.println(Arrays.toString(is));
        }
    }

    public static void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        boolean[][] visited = new boolean[n][m];

        // Mark diagnols as non boundry elements
        // 0th row
        for (int i = 0; i < board[0].length; i++) {
            if (board[0][i] == 'O' && !visited[0][i]) {
                dfs(board, 0, i, visited);
            }
        }

        // n th row
        for (int i = 0; i < board[0].length; i++) {
            if (board[n - 1][i] == 'O' && !visited[n - 1][i]) {
                dfs(board, n - 1, i, visited);
            }
        }

        // 0 th col
        for (int i = 0; i < n; i++) {
            if (board[i][0] == 'O' && !visited[i][0]) {
                dfs(board, i, 0, visited);
            }
        }

        // n th col
        for (int i = 0; i < n; i++) {
            if (board[i][m - 1] == 'O' && !visited[i][m - 1]) {
                dfs(board, i, m - 1, visited);
            }
        }

        for (boolean[] bs : visited) {
            System.out.println(Arrays.toString(bs));
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }

    }

    public static void dfs(char[][] board, int row, int col, boolean[][] visited) {
        if (row < 0 || row == board.length || col < 0 || col == board[row].length || visited[row][col]
                || board[row][col] != 'O') {
            return;
        }

        visited[row][col] = true;
        int[] drow = { -1, 0, 1, 0 };
        int[] dcol = { 0, 1, 0, -1 };

        for (int i = 0; i < 4; i++) {
            System.out.println(row + drow[i]);
            System.out.println(col + dcol[i]);
            dfs(board, row + drow[i], col + dcol[i], visited);
        }
    }
}

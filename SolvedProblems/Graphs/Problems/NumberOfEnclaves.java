import java.util.LinkedList;
import java.util.Queue;

public class NumberOfEnclaves {
    public static void main(String[] args) {
        int[][] grid = {
                { 0, 0, 0, 0 },
                { 1, 0, 1, 0 },
                { 0, 1, 1, 0 },
                { 0, 0, 0, 0 }
        };

        System.out.println(numEnclaves(grid));
    }

    public static int numEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            if (grid[0][i] == 1) {
                queue.offer(new int[] { 0, i });
                visited[0][i] = true;
            }
            if (grid[n - 1][i] == 1) {
                queue.offer(new int[] { n - 1, i });
                visited[n - 1][i] = true;
            }
        }

        for (int i = 0; i < n; i++) {
            if (grid[i][0] == 1) {
                queue.offer(new int[] { i, 0 });
                visited[i][0] = true;
            }
            if (grid[i][m - 1] == 1) {
                queue.offer(new int[] { i, m - 1 });
                visited[i][m - 1] = true;
            }
        }

        int[] drow = { -1, 0, 1, 0 };
        int[] dcol = { 0, 1, 0, -1 };
        while (!queue.isEmpty()) {
            int[] node = queue.poll();
            int row = node[0];
            int col = node[1];

            for (int i = 0; i < 4; i++) {
                int nrow = row + drow[i];
                int ncol = col + dcol[i];
                if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && !visited[nrow][ncol] && grid[nrow][ncol] == 1) {
                    visited[nrow][ncol] = true;
                    queue.offer(new int[] { nrow, ncol });
                }
            }
        }

        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    count++;
                }
            }
        }

        return count;
    }
}

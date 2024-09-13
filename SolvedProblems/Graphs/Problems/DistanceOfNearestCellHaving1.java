import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DistanceOfNearestCellHaving1 {
    public static void main(String[] args) {
        int[][] grid = { { 0, 1, 1, 0 }, { 1, 1, 0, 0 }, { 0, 0, 1, 1 } };

        int[][] ans = nearest(grid);
        for (int[] i : ans) {
            System.out.println(Arrays.toString(i));
        }
    }

    public static int[][] nearest(int[][] grid) {
        int[][] distance = new int[grid.length][grid[0].length];
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[grid.length][grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                distance[i][j] = Integer.MAX_VALUE;
                if (grid[i][j] == 1) {
                    int[] pair = new int[3];
                    pair[0] = i;
                    pair[1] = j;
                    pair[2] = 0;
                    queue.offer(pair);
                    visited[i][j] = true;
                }
            }
        }

        int[] drow = { -1, 0, 1, 0 };
        int[] dcol = { 0, 1, 0, -1 };
        while (!queue.isEmpty()) {
            int[] pair = queue.poll();
            int row = pair[0];
            int col = pair[1];
            int steps = pair[2];
            distance[row][col] = Math.min(distance[row][col], steps);

            for (int i = 0; i < 4; i++) {
                int nrow = row + drow[i];
                int ncol = col + dcol[i];

                if (nrow >= 0 && nrow < grid.length && ncol >= 0 && ncol < grid[row].length && !visited[nrow][ncol]) {
                    int[] newpair = new int[3];
                    newpair[0] = nrow;
                    newpair[1] = ncol;
                    newpair[2] = steps + 1;
                    queue.offer(newpair);
                    visited[row][col] = true;
                }
            }
        }

        return distance;
    }
}

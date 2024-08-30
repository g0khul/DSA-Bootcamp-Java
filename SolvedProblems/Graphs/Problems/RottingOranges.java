import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RottingOranges {
    public static void main(String[] args) {
        int[][] grid = {
                { 2, 1, 1 },
                { 1, 1, 0 },
                { 0, 1, 1 }
        };

        System.out.println(orangesRotting(grid));
    }

    public static int orangesRotting(int[][] grid) {
        int[][] visited = new int[grid.length][grid[0].length];
        Queue<int[]> queue = new LinkedList<>();
        int countFresh = 0;
        // Find all the rotten oranges initially and add it in the queue
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 2) {
                    int[] list = new int[3];
                    list[0] = i;
                    list[1] = j;
                    // at time 0
                    list[2] = 0;
                    queue.offer(list);
                    visited[i][j] = 2;
                }
                if (grid[i][j] == 1) {
                    countFresh++;
                }
            }
        }

        int[] drow = { -1, 0, 1, 0 };
        int[] dcol = { 0, 1, 0, -1 };
        int time = 0;
        while (!queue.isEmpty()) {
            int[] list = queue.poll();
            int row = list[0];
            int col = list[1];
            int t = list[2];
            time = Math.max(time, t);

            for (int i = 0; i < 4; i++) {
                int nrow = row + drow[i];
                int ncol = col + dcol[i];

                if (nrow >= 0 && nrow < grid.length && ncol >= 0 && ncol < grid[nrow].length && visited[nrow][ncol] != 2
                        && grid[nrow][ncol] == 1) {
                    int[] child = new int[3];
                    child[0] = nrow;
                    child[1] = ncol;
                    child[2] = t + 1;
                    queue.offer(child);
                    visited[nrow][ncol] = 2;
                    countFresh--;
                }
            }

        }

        return countFresh == 0 ? time : -1;
    }
}

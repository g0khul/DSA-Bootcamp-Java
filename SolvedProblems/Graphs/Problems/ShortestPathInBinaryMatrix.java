import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathInBinaryMatrix {
    public static void main(String[] args) {
        int[][] grid = {
                { 1, 1, 1, 1 },
                { 1, 1, 0, 1 },
                { 1, 1, 1, 1 },
                { 1, 1, 0, 0 },
                { 1, 0, 0, 1 }
        };
        int[] src = { 0, 1 };
        int[] dest = { 2, 2 };
        System.out.println(shortestPath(grid, src, dest));
        System.out.println(shortestPathBinaryMatrix(grid));
    }

    public static int shortestPathBinaryMatrix(int[][] grid) {
        // Leetcode
        if (grid[0][0] == 1 || grid[grid.length - 1][grid[0].length - 1] == 1) {
            return -1;
        }

        int[] src = { 0, 0 };
        int[] dest = { grid.length - 1, grid[0].length - 1 };

        if (src[0] == dest[0] && src[1] == dest[1]) {
            return 0;
        }

        int[][] distance = new int[grid.length][grid[0].length];
        for (int[] is : distance) {
            Arrays.fill(is, Integer.MAX_VALUE);
        }
        Queue<int[]> queue = new LinkedList<>();

        distance[src[0]][src[1]] = 0;
        queue.offer(new int[] { 0, src[0], src[1] });

        while (!queue.isEmpty()) {
            int[] pair = queue.poll();
            int dist = pair[0];
            int row = pair[1];
            int col = pair[2];

            int[] drow = { -1, 0, 1, 0, -1, 1, 1, -1 };
            int[] dcol = { 0, 1, 0, -1, 1, 1, -1, -1 };

            for (int i = 0; i < drow.length; i++) {
                int nrow = row + drow[i];
                int ncol = col + dcol[i];
                int ndist = dist + 1;

                if (nrow >= 0 && nrow < grid.length && ncol >= 0 && ncol < grid[0].length && grid[nrow][ncol] == 0
                        && ndist < distance[nrow][ncol]) {
                    if (nrow == dest[0] && ncol == dest[1]) {
                        return ndist;
                    }
                    distance[nrow][ncol] = ndist;
                    queue.offer(new int[] { ndist, nrow, ncol });
                }
            }
        }

        return -1;
    }

    public static int shortestPath(int[][] grid, int[] src, int[] dest) {
        // GFG
        if (src[0] == dest[0] && src[1] == dest[1]) {
            return 0;
        }

        int[][] distance = new int[grid.length][grid[0].length];
        for (int[] is : distance) {
            Arrays.fill(is, Integer.MAX_VALUE);
        }
        Queue<int[]> queue = new LinkedList<>();

        distance[src[0]][src[1]] = 0;
        queue.offer(new int[] { 0, src[0], src[1] });

        while (!queue.isEmpty()) {
            int[] pair = queue.poll();
            int dist = pair[0];
            int row = pair[1];
            int col = pair[2];

            int[] drow = { -1, 0, 1, 0 };
            int[] dcol = { 0, 1, 0, -1 };

            for (int i = 0; i < drow.length; i++) {
                int nrow = row + drow[i];
                int ncol = col + dcol[i];
                int ndist = dist + 1;

                if (nrow >= 0 && nrow < grid.length && ncol >= 0 && ncol < grid[0].length && grid[nrow][ncol] == 1
                        && ndist < distance[nrow][ncol]) {
                    if (nrow == dest[0] && ncol == dest[1]) {
                        return ndist;
                    }
                    distance[nrow][ncol] = ndist;
                    queue.offer(new int[] { ndist, nrow, ncol });
                }
            }
        }

        return -1;
    }
}

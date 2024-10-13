import java.util.Arrays;
import java.util.PriorityQueue;

public class PathWithMinimumEffort {
    public static void main(String[] args) {
        int[][] heights = {
                { 1, 2, 2 },
                { 3, 8, 2 },
                { 5, 3, 5 }
        };
        System.out.println(minimumEffortPath(heights));
    }

    public static int minimumEffortPath(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;
        PriorityQueue<Pair> queue = new PriorityQueue<>((x, y) -> x.distance - y.distance);
        int[][] distance = new int[n][m];
        for (int[] d : distance) {
            Arrays.fill(d, Integer.MAX_VALUE);
        }

        queue.offer(new Pair(0, 0, 0));
        distance[0][0] = 0;

        int[] drow = { -1, 0, 1, 0 };
        int[] dcol = { 0, 1, 0, -1 };
        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            int dist = pair.distance;
            int row = pair.first;
            int col = pair.second;

            if (row == n - 1 && col == m - 1) {
                return dist;
            }

            for (int i = 0; i < drow.length; i++) {
                int nrow = row + drow[i];
                int ncol = col + dcol[i];

                if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m) {
                    int ndist = Math.max(Math.abs(heights[row][col] - heights[nrow][ncol]), dist);
                    if (ndist < distance[nrow][ncol]) {
                        distance[nrow][ncol] = ndist;
                        queue.offer(new Pair(ndist, nrow, ncol));
                    }
                }
            }
        }

        return -1;
    }
}

class Pair {
    int distance;
    int first;
    int second;

    Pair(int distance, int first, int second) {
        this.distance = distance;
        this.first = first;
        this.second = second;
    }
}

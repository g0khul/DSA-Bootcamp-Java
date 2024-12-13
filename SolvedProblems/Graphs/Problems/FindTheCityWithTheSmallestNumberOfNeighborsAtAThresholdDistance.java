import java.util.*;

public class FindTheCityWithTheSmallestNumberOfNeighborsAtAThresholdDistance {
    public static void main(String[] args) {
        int n = 4;
        int distanceThreshold = 4;
        int[][] edges = {
                { 0, 1, 3 },
                { 1, 2, 1 },
                { 1, 3, 4 },
                { 2, 3, 1 }
        };

        System.out.println(findTheCity(n, edges, distanceThreshold));
    }

    public static int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] distance = new int[n][n];
        for (int[] is : distance) {
            Arrays.fill(is, Integer.MAX_VALUE);
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int weight = edge[2];
            distance[u][v] = weight;
            distance[v][u] = weight;
        }

        for (int i = 0; i < n; i++) {
            distance[i][i] = 0;
        }

        for (int via = 0; via < n; via++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (distance[i][via] == Integer.MAX_VALUE || distance[via][j] == Integer.MAX_VALUE) {
                        continue;
                    }
                    distance[i][j] = Math.min(distance[i][j], distance[i][via] + distance[via][j]);
                }
            }
        }

        for (int[] is : distance) {
            System.out.println(Arrays.toString(is));
        }

        int node = 0;
        int minEdges = Integer.MAX_VALUE;
        // Wrote it with the above logic itself
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (distance[i][j] <= distanceThreshold) {
                    count++;
                }
            }
            if (count <= minEdges) {
                node = i;
                minEdges = count;
            }
        }

        return node;
    }
}

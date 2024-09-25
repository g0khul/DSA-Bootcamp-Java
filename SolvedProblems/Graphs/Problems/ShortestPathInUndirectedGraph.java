import java.util.*;

public class ShortestPathInUndirectedGraph {
    public static void main(String[] args) {
        int[][] edges = {
                { 0, 1 }, { 0, 3 }, { 3, 4 }, { 4, 5 }, { 5, 6 }, { 1, 2 }, { 2, 6 }, { 6, 7 }, { 7, 8 }, { 6, 8 }
        };
        int n = 9;
        int m = 10;
        int src = 0;

        System.out.println(Arrays.toString(shortestPath(edges, n, m, src)));
    }

    public static int[] shortestPath(int[][] edges, int n, int m, int src) {
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        int[] distance = new int[n];
        for (int i = 0; i < distance.length; i++) {
            distance[i] = (int) 1e9;
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] { src, 0 });
        distance[src] = 0;

        while (!queue.isEmpty()) {
            int node = queue.peek()[0];
            int dist = queue.peek()[1];
            queue.poll();

            for (int child : adj.get(node)) {
                if (dist + 1 < distance[child]) {
                    distance[child] = dist + 1;
                    queue.offer(new int[] { child, distance[child] });
                }
            }
        }

        for (int i = 0; i < distance.length; i++) {
            if (distance[i] == (int) 1e9) {
                distance[i] = -1;
            }
        }

        return distance;
    }
}

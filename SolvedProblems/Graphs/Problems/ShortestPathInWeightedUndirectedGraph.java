import java.util.*;

public class ShortestPathInWeightedUndirectedGraph {
    public static void main(String[] args) {
        int[][] edges = {
                { 1, 2, 2 },
                { 2, 5, 5 },
                { 2, 3, 4 },
                { 1, 4, 1 },
                { 4, 3, 3 },
                { 3, 5, 1 }
        };
        int n = 5;
        int m = 6;
        System.out.println(shortestPath(n, m, edges));
    }

    public static List<Integer> shortestPath(int n, int m, int edges[][]) {
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int edgeWeight = edges[i][2];
            adj.get(u).add(new int[] { v, edgeWeight });
            adj.get(v).add(new int[] { u, edgeWeight });
        }

        int[] distance = new int[n + 1];
        Arrays.fill(distance, (int) 1e9);
        int[] parent = new int[n + 1];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }

        PriorityQueue<int[]> queue = new PriorityQueue<>((x, y) -> x[0] - y[0]);
        queue.offer(new int[] { 0, 1 });

        while (!queue.isEmpty()) {
            int[] pair = queue.poll();
            int node = pair[1];
            int edgeWeight = pair[0];

            for (int[] childPair : adj.get(node)) {
                int child = childPair[0];
                int childEdgeWeight = childPair[1];

                if (edgeWeight + childEdgeWeight < distance[child]) {
                    parent[child] = node;
                    distance[child] = edgeWeight + childEdgeWeight;
                    queue.offer(new int[] { distance[child], child });
                }
            }
        }

        if (distance[n] == (int) 1e9) {
            return new ArrayList<>(Arrays.asList(-1));
        }

        System.out.println(Arrays.toString(distance));

        List<Integer> result = new ArrayList<>();
        int node = n;
        while (node != 1) {
            result.add(node);
            node = parent[node];
        }
        result.add(1);
        result.add(distance[n]);
        Collections.reverse(result);
        return result;
    }
}

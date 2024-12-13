import java.util.*;

public class MinimumSpanningTree {
    public static void main(String[] args) {
        int V = 3;
        int E = 3;
        int[][] adjArr = {
                { 0, 1, 5 },
                { 1, 2, 3 },
                { 0, 2, 1 }
        };

        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < adjArr.length; i++) {
            int u = adjArr[i][0];
            int v = adjArr[i][1];
            int wt = adjArr[i][2];
            adj.get(u).add(new int[] { v, wt });
            adj.get(v).add(new int[] { u, wt });
        }

        System.out.println(spanningTree(V, E, adj));
    }

    // Not using parent in Pair since the question doesn't ask MST
    public static int spanningTree(int V, int E, List<List<int[]>> adj) {
        PriorityQueue<Pair> queue = new PriorityQueue<>((x, y) -> x.weight - y.weight);
        queue.offer(new Pair(0, 0));
        boolean[] visited = new boolean[V];
        int mstSum = 0;

        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            int node = pair.node;
            int weight = pair.weight;

            if (visited[node]) {
                continue;
            }

            visited[node] = true;
            mstSum += weight;

            for (int[] pairArr : adj.get(node)) {
                int v = pairArr[0];
                int wt = pairArr[1];
                if (!visited[v]) {
                    queue.offer(new Pair(wt, v));
                }
            }
        }

        return mstSum;
    }
}

class Pair {
    int node;
    int weight;

    Pair(int weight, int node) {
        this.node = node;
        this.weight = weight;
    }
}

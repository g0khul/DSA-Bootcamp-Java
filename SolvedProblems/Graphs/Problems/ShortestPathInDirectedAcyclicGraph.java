import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class ShortestPathInDirectedAcyclicGraph {
    public static void main(String[] args) {
        int[][] edges = {
                { 0, 1, 2 },
                { 0, 2, 1 }
        };
        int N = 4;
        int M = 2;
        System.out.println(Arrays.toString(shortestPath(N, M, edges)));
    }

    public static int[] shortestPath(int N, int M, int[][] edges) {
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            adj.add(new ArrayList<>());
        }

        // Create Adj list
        for (int i = 0; i < M; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int wt = edges[i][2];
            adj.get(u).add(new int[] { v, wt });
        }

        // Topo sort using DFS
        boolean[] visited = new boolean[N];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < visited.length; i++) {
            if (!visited[i]) {
                topoSort(adj, i, visited, stack);
            }
        }

        int[] distance = new int[N];
        for (int i = 0; i < distance.length; i++) {
            distance[i] = (int) 1e9;
        }

        distance[0] = 0;
        while (!stack.isEmpty()) {
            int node = stack.pop();
            for (int i = 0; i < adj.get(node).size(); i++) {
                int child = adj.get(node).get(i)[0];
                int wt = adj.get(node).get(i)[1];
                if (distance[node] + wt < distance[child]) {
                    distance[child] = distance[node] + wt;
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

    public static void topoSort(List<List<int[]>> adj, int node, boolean[] visited, Stack<Integer> stack) {
        visited[node] = true;
        for (int i = 0; i < adj.get(node).size(); i++) {
            int child = adj.get(node).get(i)[0];
            if (!visited[child]) {
                topoSort(adj, child, visited, stack);
            }
        }
        stack.push(node);
    }
}

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class UndirectedGraphCycle {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            adj.add(new ArrayList<>());
        }
        adj.get(0).add(1);
        adj.get(1).add(0);
        adj.get(0).add(4);
        adj.get(4).add(0);
        adj.get(1).add(2);
        adj.get(2).add(1);
        adj.get(1).add(3);
        adj.get(3).add(1);
        System.out.println(isCycleBFS(adj.size(), adj));
        System.out.println(isCycleDFS(adj.size(), adj));
    }

    public static boolean isCycleBFS(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (detectCycleBFS(adj, i, visited)) {
                    return true;
                }
            }
        }

        return false;
    }

    public static boolean detectCycleBFS(ArrayList<ArrayList<Integer>> adj, int src, boolean[] visited) {
        Queue<int[]> queue = new LinkedList<>();

        queue.offer(new int[] { src, -1 });
        visited[src] = true;

        while (!queue.isEmpty()) {
            int[] pair = queue.poll();
            int node = pair[0];
            int parent = pair[1];
            for (int child : adj.get(node)) {
                if (!visited[child]) {
                    queue.offer(new int[] { child, node });
                    visited[child] = true;
                } else if (parent != child) {
                    return true;
                }
            }
        }

        return false;
    }

    public static boolean isCycleDFS(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (detectCycleDFS(adj, i, -1, visited)) {
                    return true;
                }
            }
        }

        return false;
    }

    public static boolean detectCycleDFS(ArrayList<ArrayList<Integer>> adj, int index, int parent, boolean[] visited) {
        visited[index] = true;
        for (int child : adj.get(index)) {
            if (!visited[child]) {
                visited[child] = true;
                if (detectCycleDFS(adj, child, index, visited)) {
                    return true;
                }
            } else if (child != parent) {
                return true;
            }
        }
        return false;
    }
}

import java.util.*;

public class DirectedGraphCycle {
    public static void main(String[] args) {

    }

    public static boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[V];
        boolean[] currentPath = new boolean[V];

        for (int i = 0; i < V; i++) {
            for (int node : adj.get(i)) {
                if (!visited[node]) {
                    if (dfs(adj, visited, currentPath, i)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public static boolean dfs(ArrayList<ArrayList<Integer>> adj, boolean[] visited, boolean[] currentPath, int node) {
        visited[node] = true;
        currentPath[node] = true;

        for (int child : adj.get(node)) {
            if (!visited[child]) {
                if (dfs(adj, visited, currentPath, child)) {
                    return true;
                }
            } else if (currentPath[child]) {
                return true;
            }
        }

        currentPath[node] = false;
        return false;
    }
}

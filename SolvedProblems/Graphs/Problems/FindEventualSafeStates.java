import java.util.ArrayList;
import java.util.List;

public class FindEventualSafeStates {
    public static void main(String[] args) {
        int[][] graph = {
                { 1, 2 },
                { 2, 3 },
                { 5 },
                { 0 },
                { 5 },
                {},
                {}
        };

        System.out.println(eventualSafeNodesDFS(graph));
    }

    public static List<Integer> eventualSafeNodesDFS(int[][] graph) {
        boolean[] visited = new boolean[graph.length];
        boolean[] pathVisited = new boolean[graph.length];
        boolean[] safeNodes = new boolean[graph.length];

        for (int node = 0; node < graph.length; node++) {
            if (!visited[node]) {
                dfs(graph, visited, pathVisited, safeNodes, node);
            }
        }

        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < safeNodes.length; i++) {
            if (safeNodes[i]) {
                result.add(i);
            }
        }

        return result;
    }

    public static boolean dfs(int[][] graph, boolean[] visited, boolean[] pathVisited, boolean[] safeNodes, int node) {
        visited[node] = true;
        pathVisited[node] = true;
        safeNodes[node] = false;

        for (int child : graph[node]) {
            if (!visited[child]) {
                if (dfs(graph, visited, pathVisited, safeNodes, child)) {
                    safeNodes[child] = false;
                    return true;
                }
            } else if (pathVisited[child]) {
                safeNodes[child] = false;
                return true;
            }
        }

        safeNodes[node] = true;
        pathVisited[node] = false;
        return false;
    }
}

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
        System.out.println(eventualSafeNodesBFS(graph));
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

    public static List<Integer> eventualSafeNodesBFS(int[][] graph) {
        int[] indegree = new int[graph.length];
        List<List<Integer>> revAdj = new ArrayList<>();
        for (int i = 0; i < graph.length; i++) {
            revAdj.add(new ArrayList<>());
        }

        for (int node = 0; node < graph.length; node++) {
            // It has edge from node -> child
            // Change it to child -> node
            for (int child : graph[node]) {
                revAdj.get(child).add(node);
                indegree[node]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        List<Integer> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            int node = queue.poll();
            result.add(node);

            for (int child : revAdj.get(node)) {
                indegree[child]--;
                if (indegree[child] == 0) {
                    queue.offer(child);
                }
            }
        }

        Collections.sort(result);
        return result;
    }
}

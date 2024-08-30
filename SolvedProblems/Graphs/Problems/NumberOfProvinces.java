import java.util.*;

public class NumberOfProvinces {
    public static void main(String[] args) {
        int[][] isConnected = {
                { 0, 0, 0, 0, 0 },
                { 0, 0, 1, 0, 0 },
                { 1, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0 },
                { 0, 1, 0, 0, 0 }
        };

        System.out.println(findCircleNum(isConnected));

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            adj.add(new ArrayList<>());
        }
        adj.get(0).add(1);
        adj.get(1).add(0);
        adj.get(0).add(4);
        adj.get(4).add(0);
        // adj.get(1).add(2);
        // adj.get(2).add(1);
        // adj.get(1).add(3);
        adj.get(3).add(1);

        System.out.println(numProvinces(adj, 5));
    }

    public static int findCircleNum(int[][] isConnected) {
        boolean[] visited = new boolean[isConnected.length + 1];
        int result = 0;

        for (int i = 1; i < visited.length; i++) {
            if (!visited[i]) {
                result += 1;
                dfs(isConnected, visited, i);
            }
        }

        return result;
    }

    public static void dfs(int[][] isConnected, boolean[] visited, int index) {
        for (int child = 1; child < isConnected.length + 1;) {
            if (!visited[child] && isConnected[index - 1][child - 1] == 1) {
                visited[child] = true;
                dfs(isConnected, visited, child);
            } else {
                child++;
            }
        }
    }

    public static int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) {
        boolean[] visited = new boolean[adj.size()];
        int result = 0;

        for (int i = 1; i < visited.length; i++) {
            if (!visited[i]) {
                result += 1;
                dfs(adj, visited, i);
            }
        }

        return result;
    }

    public static void dfs(ArrayList<ArrayList<Integer>> adj, boolean[] visited, int index) {
        visited[index] = true;
        for (int child : adj.get(index)) {
            if (!visited[child]) {
                dfs(adj, visited, child);
            }
        }
    }
}

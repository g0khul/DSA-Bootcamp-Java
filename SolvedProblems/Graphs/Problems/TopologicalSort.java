import java.util.*;;

public class TopologicalSort {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= 5; i++) {
            adj.add(new ArrayList<>());
        }

        adj.get(5).add(0);
        adj.get(4).add(0);
        adj.get(5).add(2);
        adj.get(2).add(3);
        adj.get(3).add(1);
        adj.get(4).add(1);

        System.out.println(Arrays.toString(topoSort(adj.size(), adj)));
    }

    public static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[V];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < visited.length; i++) {
            if (!visited[i]) {
                dfs(adj, visited, i, stack);
            }
        }

        int[] result = new int[V];
        int i = 0;
        while (!stack.isEmpty()) {
            result[i++] = stack.pop();
        }

        return result;
    }

    public static void dfs(ArrayList<ArrayList<Integer>> adj, boolean[] visited, int node, Stack<Integer> stack) {
        visited[node] = true;
        for (int child : adj.get(node)) {
            if (!visited[child]) {
                dfs(adj, visited, child, stack);
            }
        }
        stack.push(node);
    }
}

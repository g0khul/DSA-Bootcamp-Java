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

        System.out.println(Arrays.toString(topoSortDfs(adj.size(), adj)));
        System.out.println(Arrays.toString(topoSortBfs(adj.size(), adj)));
    }

    public static int[] topoSortDfs(int V, ArrayList<ArrayList<Integer>> adj) {
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

    public static int[] topoSortBfs(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] indegree = new int[V];
        Queue<Integer> queue = new LinkedList<>();

        for (int node = 0; node < V; node++) {
            for (int child : adj.get(node)) {
                indegree[child]++;
            }
        }

        // Add nodes with indegree 0 to queue
        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        int[] result = new int[V];
        int i = 0;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            result[i++] = node;
            for (int child : adj.get(node)) {
                indegree[child]--;
                if (indegree[child] == 0) {
                    queue.offer(child);
                }
            }
        }

        return result;
    }
}

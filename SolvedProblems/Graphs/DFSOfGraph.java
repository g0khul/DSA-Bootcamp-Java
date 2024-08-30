import java.util.ArrayList;
import java.util.List;

public class DFSOfGraph {
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

        DFSOfGraph sl = new DFSOfGraph();
        ArrayList<Integer> ans = sl.dfsOfGraph(5, adj);
        int n = ans.size();
        for (int i = 0; i < n; i++) {
            System.out.print(ans.get(i) + " ");
        }
    }

    public static ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[V];
        return dfsRecursion(adj, visited, 0);
    }

    public static ArrayList<Integer> dfsRecursion(ArrayList<ArrayList<Integer>> adj, boolean[] visited, int index) {
        visited[index] = true;
        ArrayList<Integer> result = new ArrayList<>();
        result.add(index);

        for (int child : adj.get(index)) {
            if (!visited[child]) {
                result.addAll(dfsRecursion(adj, visited, child));
            }
        }

        return result;
    }
}

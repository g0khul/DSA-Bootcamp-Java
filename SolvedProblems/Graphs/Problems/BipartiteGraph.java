import java.util.*;

public class BipartiteGraph {
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
        System.out.println(isBipartite(adj.size(), adj));
        System.out.println(isBipartiteDfs(adj.size(), adj));
    }

    public static boolean isBipartite(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] color = new int[V];
        Arrays.fill(color, -1);

        for (int node = 0; node < adj.size(); node++) {
            for (int child : adj.get(node)) {
                if (color[child] == -1) {
                    if (!bfsCheck(adj, color, child)) {
                        return false;
                    }
                }
            }
        }

        return true;

    }

    public static boolean bfsCheck(ArrayList<ArrayList<Integer>> adj, int[] color, int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        color[start] = 0;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int child : adj.get(node)) {
                if (color[child] == -1) {
                    color[child] = color[node] == 1 ? 0 : 1;
                    queue.offer(child);
                } else if (color[child] == color[node]) {
                    return false;
                }
            }
        }

        return true;
    }

    public static boolean isBipartiteDfs(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] colorArray = new int[V];
        Arrays.fill(colorArray, -1);

        for (int node = 0; node < adj.size(); node++) {
            for (int child : adj.get(node)) {
                if (colorArray[child] == -1) {
                    if (!helperDfs(adj, colorArray, child, true)) {
                        System.out.println(Arrays.toString(colorArray));
                        return false;
                    }
                }
            }
        }

        System.out.println(Arrays.toString(colorArray));

        return true;
    }

    public static boolean helperDfs(ArrayList<ArrayList<Integer>> adj, int[] colorArray, int node, boolean colorFlag) {
        colorArray[node] = colorFlag ? 1 : 0;
        for (int child : adj.get(node)) {
            if (colorArray[child] == -1) {
                if (!helperDfs(adj, colorArray, child, !colorFlag)) {
                    return false;
                }
            } else if (colorArray[node] == colorArray[child]) {
                return false;
            }
        }

        return true;
    }
}

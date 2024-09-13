import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class IsGraphBipartite {
    public static void main(String[] args) {
        int[][] graph = {
                {},
                { 2, 4, 6 },
                { 1, 4, 8, 9 },
                { 7, 8 },
                { 1, 2, 8, 9 },
                { 6, 9 },
                { 1, 5, 7, 8, 9 },
                { 3, 6, 9 },
                { 2, 3, 4, 6, 9 },
                { 2, 4, 5, 6, 7, 8 }
        };

        System.out.println(isBipartite(graph));
        System.out.println(isBipartiteDfs(graph));
    }

    public static boolean isBipartite(int[][] graph) {
        int[] color = new int[graph.length];
        Arrays.fill(color, -1);

        for (int node = 0; node < graph.length; node++) {
            if (color[node] == -1) {
                if (!bfsCheck(graph, color, node)) {
                    return false;
                }
            }
        }

        return true;
    }

    public static boolean bfsCheck(int[][] graph, int[] color, int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        color[start] = 1;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int child : graph[node]) {
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

    public static boolean isBipartiteDfs(int[][] graph) {
        int[] color = new int[graph.length];
        Arrays.fill(color, -1);

        for (int i = 0; i < graph.length; i++) {
            for (int child : graph[i]) {
                if (color[child] == -1) {
                    if (!helperDfs(graph, color, i, false)) {
                        return false;
                    }
                }
            }
        }

        return true;
    }

    public static boolean helperDfs(int[][] graph, int[] color, int node, boolean colorFlag) {
        color[node] = colorFlag ? 1 : 0;

        for (int child : graph[node]) {
            if (color[child] == -1) {
                if (!helperDfs(graph, color, child, !colorFlag)) {
                    return false;
                }
            } else if (color[node] == color[child]) {
                return false;
            }
        }

        return true;
    }
}

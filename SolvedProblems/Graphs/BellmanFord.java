import java.util.*;

public class BellmanFord {
    public static void main(String[] args) {
        int V = 6;
        int S = 0;
        ArrayList<ArrayList<Integer>> edges = new ArrayList<>() {
            {
                add(new ArrayList<Integer>(Arrays.asList(3, 2, 6)));
                add(new ArrayList<Integer>(Arrays.asList(5, 3, 1)));
                add(new ArrayList<Integer>(Arrays.asList(0, 1, 5)));
                add(new ArrayList<Integer>(Arrays.asList(1, 5, -3)));
                add(new ArrayList<Integer>(Arrays.asList(1, 2, -2)));
                add(new ArrayList<Integer>(Arrays.asList(3, 4, -2)));
                add(new ArrayList<Integer>(Arrays.asList(2, 4, 3)));
            }
        };

        int[] dist = bellmanFord(V, edges, S);
        System.out.println(Arrays.toString(dist));
    }

    public static int[] bellmanFord(int V, ArrayList<ArrayList<Integer>> edges, int src) {
        int[] distance = new int[V];
        Arrays.fill(distance, (int) 1e9);
        distance[src] = 0;

        for (int i = 0; i < V - 1; i++) {
            for (ArrayList<Integer> pair : edges) {
                int u = pair.get(0);
                int v = pair.get(1);
                int wt = pair.get(2);

                if (distance[u] + wt < distance[v]) {
                    distance[v] = distance[u] + wt;
                }
            }
        }

        for (ArrayList<Integer> pair : edges) {
            int u = pair.get(0);
            int v = pair.get(1);
            int wt = pair.get(2);

            if (distance[u] + wt < distance[v]) {
                return new int[] { -1 };
            }
        }

        return distance;
    }
}
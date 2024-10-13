import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.TreeSet;

public class DijkstraAlgorithm {
    public static void main(String[] args) {
        int V = 3, E = 3, S = 2;
        List<Integer> node1 = new ArrayList<>() {
            {
                add(1);
                add(1);
            }
        };
        List<Integer> node2 = new ArrayList<>() {
            {
                add(2);
                add(6);
            }
        };
        List<Integer> node3 = new ArrayList<>() {
            {
                add(2);
                add(3);
            }
        };
        List<Integer> node4 = new ArrayList<>() {
            {
                add(0);
                add(1);
            }
        };
        List<Integer> node5 = new ArrayList<>() {
            {
                add(1);
                add(3);
            }
        };
        List<Integer> node6 = new ArrayList<>() {
            {
                add(0);
                add(6);
            }
        };

        List<List<Integer>> inter1 = new ArrayList<>() {
            {
                add(node1);
                add(node2);
            }
        };
        List<List<Integer>> inter2 = new ArrayList<>() {
            {
                add(node3);
                add(node4);
            }
        };
        List<List<Integer>> inter3 = new ArrayList<>() {
            {
                add(node5);
                add(node6);
            }
        };
        List<List<List<Integer>>> adj = new ArrayList<>() {
            {
                add(inter1); // for 1st node
                add(inter2); // for 2nd node
                add(inter3); // for 3rd node
            }
        };
        // add final values of adj here.
        int[] res = dijkstra(V, adj, S);

        System.out.println(Arrays.toString(res));
        res = dijkstraUsingSet(V, adj, S);
        System.out.println(Arrays.toString(res));
    }

    public static int[] dijkstra(int V, List<List<List<Integer>>> adj, int S) {
        int[] distance = new int[V];
        for (int i = 0; i < distance.length; i++) {
            distance[i] = (int) 1e9;
        }

        PriorityQueue<int[]> queue = new PriorityQueue<>((x, y) -> x[0] - y[0]);

        queue.offer(new int[] { 0, S });
        distance[S] = 0;

        while (!queue.isEmpty()) {
            int[] pair = queue.poll();
            int edgeWeight = pair[0];
            int node = pair[1];

            for (List<Integer> childPair : adj.get(node)) {
                int childNode = childPair.get(0);
                int childEdgeWeight = childPair.get(1);

                if (distance[node] + childEdgeWeight < distance[childNode]) {
                    distance[childNode] = distance[node] + childEdgeWeight;
                    queue.offer(new int[] { distance[childNode], childNode });
                }
            }
        }

        return distance;
    }

    public static int[] dijkstraUsingSet(int V, List<List<List<Integer>>> adj, int S) {
        int[] distance = new int[V];
        Arrays.fill(distance, (int) 1e9);

        TreeSet<int[]> set = new TreeSet<>((x, y) -> x[0] == y[0] ? x[1] - y[1] : x[0] - y[0]);
        set.add(new int[] { 0, S });
        distance[S] = 0;

        while (!set.isEmpty()) {
            int[] pair = set.pollFirst();
            int node = pair[1];
            int edgeWeight = pair[0];

            for (List<Integer> childPair : adj.get(node)) {
                int child = childPair.get(0);
                int childEdgeWeight = childPair.get(1);

                if (distance[node] + childEdgeWeight < distance[child]) {
                    if (distance[child] == (int) 1e9) {
                        set.remove(new int[] { distance[child], child });
                    }
                    distance[child] = distance[node] + childEdgeWeight;
                    set.add(new int[] { distance[child] + childEdgeWeight, child });
                }
            }
        }

        return distance;
    }
}

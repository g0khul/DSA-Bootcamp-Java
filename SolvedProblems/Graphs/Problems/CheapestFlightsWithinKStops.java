import java.util.*;

public class CheapestFlightsWithinKStops {
    public static void main(String[] args) {
        int[][] flights = {
                { 0, 1, 100 },
                { 1, 2, 100 },
                { 2, 0, 100 },
                { 1, 3, 600 },
                { 2, 3, 200 }
        };
        int n = 4;
        int source = 0;
        int destination = 3;
        int k = 1;
        System.out.println(findCheapestPrice(n, flights, source, destination, k));
    }

    public static int findCheapestPrice(int n, int[][] flights, int source, int destination, int k) {
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < flights.length; i++) {
            adj.get(flights[i][0]).add(new int[] { flights[i][1], flights[i][2] });
        }

        int[] costs = new int[n + 1];
        Arrays.fill(costs, Integer.MAX_VALUE);

        Queue<int[]> queue = new LinkedList<>();
        // { steps, node, cost}
        queue.offer(new int[] { 0, source, 0 });
        costs[source] = 0;

        while (!queue.isEmpty()) {
            int[] pairs = queue.poll();
            int steps = pairs[0];
            int node = pairs[1];
            int cost = pairs[2];

            if (steps > k) {
                continue;
            }

            for (int[] childPair : adj.get(node)) {
                int child = childPair[0];
                int edgeWeight = childPair[1];

                if (cost + edgeWeight < costs[child] && steps <= k) {
                    costs[child] = cost + edgeWeight;
                    queue.offer(new int[] { steps + 1, child, cost + edgeWeight });
                }
            }
        }

        System.out.println(Arrays.toString(costs));

        return costs[destination] == Integer.MAX_VALUE ? -1 : costs[destination];
    }
}

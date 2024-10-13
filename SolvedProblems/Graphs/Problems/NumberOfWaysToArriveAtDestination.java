import java.util.*;

public class NumberOfWaysToArriveAtDestination {
    public static void main(String[] args) {
        int n = 6;
        int[][] roads = {
                { 0, 1, 1000000000 },
                { 0, 3, 1000000000 },
                { 1, 3, 1000000000 },
                { 1, 2, 1000000000 },
                { 1, 5, 1000000000 },
                { 3, 4, 1000000000 },
                { 4, 5, 1000000000 },
                { 2, 5, 1000000000 }
        };

        System.out.println(countPaths(n, roads));
    }

    public static int countPaths(int n, int[][] roads) {
        List<List<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] pair : roads) {
            adj.get(pair[0]).add(new Pair(pair[1], pair[2]));
            adj.get(pair[1]).add(new Pair(pair[0], pair[2]));
        }

        Queue<Pair> queue = new PriorityQueue<>((x, y) -> Long.compare(x.time, y.time));
        long[] time = new long[n];
        int[] ways = new int[n];
        Arrays.fill(time, Long.MAX_VALUE);
        time[0] = 0;
        ways[0] = 1;
        queue.offer(new Pair(0, 0));
        int MOD = (int) (Math.pow(10, 9) + 7);

        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            int node = pair.node;
            long nodeTime = pair.time;

            for (Pair childPair : adj.get(node)) {
                int child = childPair.node;
                long childTime = childPair.time;
                long newTime = nodeTime + childTime;

                if (newTime < time[child]) {
                    time[child] = newTime;
                    ways[child] = ways[node];
                    queue.offer(new Pair(child, newTime));
                } else if (newTime == time[child]) {
                    ways[child] = (ways[child] + ways[node]) % MOD;
                }
            }
        }

        System.out.println(Arrays.toString(ways));

        return ways[n - 1];
    }
}

class Pair {
    int node;
    long time;

    Pair(int node, long time) {
        this.node = node;
        this.time = time;
    }

    @Override
    public String toString() {
        return "(" + time + ", " + node + ")";
    }
}

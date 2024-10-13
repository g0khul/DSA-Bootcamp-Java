import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class MinimumMultiplicationsToReachEnd {
    public static void main(String[] args) {
        int[] arr = { 2, 5, 7 };
        int start = 3;
        int end = 30;
        System.out.println(minimumMultiplications(arr, start, end));
    }

    public static int minimumMultiplications(int[] arr, int start, int end) {
        if (start == end) {
            return 0;
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] { start, 0 });
        Map<Integer, Integer> distance = new HashMap<>();
        distance.put(start, 0);
        int MOD = (int) Math.pow(10, 5);

        while (!queue.isEmpty()) {
            int[] pair = queue.poll();
            int num = pair[0];
            int step = pair[1];

            for (int n : arr) {
                int newnum = (num * n) % MOD;
                int newstep = step + 1;
                if (newnum == end) {
                    return newstep;
                }

                if (!distance.containsKey(newnum)) {
                    distance.put(newnum, newstep);
                    queue.offer(new int[] { newnum, newstep });
                }
            }
        }

        return -1;
    }
}

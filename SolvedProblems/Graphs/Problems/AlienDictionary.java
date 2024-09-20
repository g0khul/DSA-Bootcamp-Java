import java.util.*;

public class AlienDictionary {
    public static void main(String[] args) {
        String[] dict = { "caa", "aaa", "aab" };
        int k = 3;
        int n = dict.length;

        System.out.println(findOrder(dict, n, k));
    }

    public static String findOrder(String[] dict, int n, int k) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < n - 1; i++) {
            String s1 = dict[i];
            String s2 = dict[i + 1];
            // Ignore equal chars
            int len = Math.min(s1.length(), s2.length());
            for (int j = 0; j < len; j++) {
                if (s1.charAt(j) != s2.charAt(j)) {
                    adj.get(s1.charAt(j) - 'a').add(s2.charAt(j) - 'a');
                    break;
                }
            }
        }

        // Topo sort the result, if result is possible, return result else None
        int[] indegree = new int[k];
        for (int node = 0; node < adj.size(); node++) {
            for (int child : adj.get(node)) {
                indegree[child]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        StringBuilder result = new StringBuilder();
        while (!queue.isEmpty()) {
            int node = queue.poll();
            result.append((char) (node + 'a'));

            for (int child : adj.get(node)) {
                indegree[child]--;
                if (indegree[child] == 0) {
                    queue.offer(child);
                }
            }
        }

        return result.length() == adj.size() ? result.toString() : "";
    }
}

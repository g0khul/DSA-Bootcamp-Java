import java.util.*;

public class CourseScheduleII {
    public static void main(String[] args) {

    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < prerequisites.length; i++) {
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }

        int[] indegree = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            for (int child : adj.get(i)) {
                indegree[child]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        int[] topoSort = new int[numCourses];
        int i = 0;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            topoSort[i++] = node;

            for (int child : adj.get(node)) {
                indegree[child]--;
                if (indegree[child] == 0) {
                    queue.offer(child);
                }
            }
        }

        return i == numCourses ? topoSort : new int[numCourses];
    }
}

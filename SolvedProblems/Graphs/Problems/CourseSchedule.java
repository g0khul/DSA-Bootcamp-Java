import java.util.*;;

public class CourseSchedule {
    public static void main(String[] args) {
        int[][] prerequisites = {
                { 1, 0 }
        };

        int numCourses = 2;
        System.out.println(canFinish(numCourses, prerequisites));
    }

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < prerequisites.length; i++) {
            adj.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }

        int[] indegree = new int[numCourses];
        for (int node = 0; node < numCourses; node++) {
            for (int child : adj.get(node)) {
                indegree[child]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int node = 0; node < indegree.length; node++) {
            if (indegree[node] == 0) {
                queue.offer(node);
            }
        }

        int count = 0;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            count++;
            for (int child : adj.get(node)) {
                indegree[child]--;
                if (indegree[child] == 0) {
                    queue.offer(child);
                }
            }
        }

        return count == numCourses;
    }
}

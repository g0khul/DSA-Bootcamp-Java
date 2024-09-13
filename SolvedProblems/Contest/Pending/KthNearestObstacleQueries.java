import java.util.Arrays;

public class KthNearestObstacleQueries {
    public static void main(String[] args) {
        int[][] queries = {
                { 1, 2 },
                { 3, 4 },
                { 2, 3 },
                { -3, 0 }
        };
        int k = 2;

        System.out.println(Arrays.toString(resultsArray(queries, k)));

    }

    public static int[] resultsArray(int[][] queries, int k) {
        int[] result = new int[queries.length];
        int[] obstacles = new int[queries.length];
        Arrays.fill(obstacles, -1);

        for (int i = 0; i < queries.length; i++) {
            int distance = Math.abs(queries[i][0]) + Math.abs(queries[i][1]);
            obstacles[i] = distance;
            // Arrays.sort(obstacles);
            boolean isThereAnObstacle = false;
            if (i - k >= 0 && obstacles[i - k] != -1) {
                isThereAnObstacle = true;
            }
            if (i + k < result.length && obstacles[i + k] != -1) {
                isThereAnObstacle = true;
            }
            result[i] = isThereAnObstacle ? distance : -1;
        }

        return result;
    }
}

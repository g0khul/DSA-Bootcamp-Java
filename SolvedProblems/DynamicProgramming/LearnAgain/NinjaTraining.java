import java.lang.reflect.Array;
import java.util.Arrays;

public class NinjaTraining {
    public static void main(String[] args) {
        int[][] points = {
                { 2, 4, 3 },
                { 3, 2, 6 },
                { 6, 4, 3 },
                { 13, 6, 4 },
                { 4, 2, 6 }
        };
        int n = points.length;
        System.out.println(ninjaTrainingWithRecursion(n, points));
        System.out.println(ninjaTrainingWithTabulation(n, points));
        System.out.println(ninjaTrainingWithSpaceOptimization(n, points));
    }

    public static int ninjaTrainingWithRecursion(int n, int points[][]) {
        int[][] dp = new int[points.length][points[0].length + 1];
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }

        return helper(points, n - 1, points[0].length, dp);
    }

    public static int helper(int[][] points, int day, int last, int[][] dp) {
        if (dp[day][last] != -1) {
            return dp[day][last];
        }

        if (day == 0) {
            int max = Integer.MIN_VALUE;
            for (int task = 0; task < points[day].length; task++) {
                if (task != last) {
                    max = Math.max(max, points[day][task]);
                }
            }
            return dp[day][last] = max;
        }

        int max = 0;
        for (int task = 0; task < points[day].length; task++) {
            if (task != last) {
                int point = points[day][task] + helper(points, day - 1, task, dp);
                max = Math.max(max, point);
            }
        }

        return dp[day][last] = max;
    }

    public static int ninjaTrainingWithTabulation(int n, int points[][]) {
        int[][] dp = new int[n][points[0].length + 1];
        dp[0][0] = Math.max(points[0][1], points[0][2]);
        dp[0][1] = Math.max(points[0][0], points[0][2]);
        dp[0][2] = Math.max(points[0][0], points[0][1]);
        dp[0][3] = Math.max(points[0][0], Math.max(points[0][1], points[0][2]));

        for (int day = 1; day < n; day++) {
            for (int last = 0; last < points[0].length + 1; last++) {
                dp[day][last] = 0;
                int max = 0;
                for (int task = 0; task < points[0].length; task++) {
                    if (task != last) {
                        int point = points[day][task] + dp[day - 1][task];
                        max = Math.max(max, point);
                    }
                }
                dp[day][last] = max;
            }
        }

        return dp[n - 1][dp[0].length - 1];
    }

    public static int ninjaTrainingWithSpaceOptimization(int n, int[][] points) {
        int[] dp = new int[4];
        dp[0] = Math.max(points[0][1], points[0][2]);
        dp[1] = Math.max(points[0][0], points[0][2]);
        dp[2] = Math.max(points[0][0], points[0][1]);
        dp[3] = Math.max(points[0][0], Math.max(points[0][1], points[0][2]));

        for (int day = 1; day < n; day++) {
            int[] temp = new int[4];
            for (int last = 0; last < points[0].length + 1; last++) {
                temp[last] = 0;
                int max = 0;
                for (int task = 0; task < points[0].length; task++) {
                    if (task != last) {
                        int point = points[day][task] + dp[task];
                        max = Math.max(max, point);
                    }
                    temp[last] = max;
                }
            }
            dp = temp;
        }

        return dp[dp.length - 1];
    }

}

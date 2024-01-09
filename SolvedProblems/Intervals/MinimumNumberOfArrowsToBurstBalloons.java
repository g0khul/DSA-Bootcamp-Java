
import java.util.Arrays;

public class MinimumNumberOfArrowsToBurstBalloons {
    public static void main(String[] args) {
        int[][] points = { { 1, 2 }, { 3, 4 }, { 5, 6 }, { 7, 8 } };

        System.out.println(findMinArrowShots(points));
    }

    public static int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));

        int ans = 0;
        int start = points[0][0];
        int end = points[0][1];

        for (int i = 1; i < points.length; i++) {
            if (end >= points[i][0]) {
                start = Math.max(start, points[i][0]);
                end = Math.min(end, points[i][1]);
            } else {
                ans++;
                start = points[i][0];
                end = points[i][1];
            }
        }

        return ans + 1;
    }
}

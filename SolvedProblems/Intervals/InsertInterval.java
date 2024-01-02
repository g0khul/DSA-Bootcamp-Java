
// package InsertInterval;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertInterval {
    public static void main(String[] args) {
        int[][] intervals = {
                { 1, 2 },
                { 3, 5 },
                { 6, 7 },
                { 8, 9 },
                { 12, 16 }
        };
        int[] newInterval = { 10, 11 };
        intervals = insert(intervals, newInterval);
        for (int[] interval : intervals) {
            System.out.println(Arrays.toString(interval));
        }

    }

    public static int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();

        for (int i = 0; i < intervals.length; i++) {
            if (newInterval[1] < intervals[i][0]) {
                result.add(newInterval);
                for (int j = i; j < intervals.length; j++) {
                    result.add(intervals[j]);
                }
                return result.stream().toArray(int[][]::new);
            } else if (newInterval[0] > intervals[i][1]) {
                result.add(intervals[i]);
            } else {
                newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
                newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            }
        }

        result.add(newInterval);

        return result.stream().toArray(int[][]::new);
    }
}

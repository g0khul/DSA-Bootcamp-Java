// package MergeIntervals;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Comparator;

public class MergeIntervals {
    public static void main(String[] args) {
        int[][] intervals = {
                { 1, 3 },
                { 8, 10 },
                { 2, 6 },
                { 9, 18 }
        };

        intervals = merge(intervals);
        for (int[] interval : intervals) {
            System.out.println(Arrays.toString(interval));
        }
    }

    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(interval -> interval[0]));

        List<List<Integer>> result = new ArrayList<>();
        int start = intervals[0][0];
        int end = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (end > intervals[i][1]) {
                // Merge completly
                continue;
            } else if (end > intervals[i][0]) {
                // Possible merging
                end = intervals[i][1];
            } else {
                result.add(new ArrayList<>(Arrays.asList(start, end)));
                start = intervals[i][0];
                end = intervals[i][1];
            }
        }

        result.add(new ArrayList<>(Arrays.asList(start, end)));

        return result.stream().map(list -> list.stream().mapToInt(Integer::intValue).toArray()).toArray(int[][]::new);
    }
}

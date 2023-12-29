// package Intervals;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {
    public static void main(String[] args) {
        int[] nums = { };
        System.out.println(summaryRanges(nums));
    }

    public static List<String> summaryRanges(int[] nums) {
        if(nums.length == 0){
            return new ArrayList<>();
        }

        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        int size = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (size == 0) {
                sb.append(nums[i]);
                size++;
            }
            if (nums[i] + 1 == nums[i + 1]) {
                size++;
            } else if (size == 1) {
                result.add(sb.toString());
                sb.delete(0, sb.length());
                size = 0;
            } else {
                sb.append("->" + nums[i]);
                result.add(sb.toString());
                sb.delete(0, sb.length());
                size = 0;
            }
        }

        if (size == 0) {
            result.add(nums[nums.length - 1] + "");
        } else {
            sb.append("->" + nums[nums.length - 1]);
            result.add(sb.toString());
        }

        return result;
    }
}

package SolvedProblems.Sorting;

import java.util.Arrays;
import java.util.TreeMap;

public class CountSort {
    public static void main(String[] args) {
        int[] nums = { 4, 2, 7, 4, 9, 4, 1, 8 };
        // Efficient than hashmap but cannot handle negative values
        countSortWithArray(nums);
        // Ok solution but handles negative values
        countSortWithHashMap(nums);
        System.out.println(Arrays.toString(nums));
    }

    private static void countSortWithHashMap(int[] nums) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        int max = Arrays.stream(nums).max().getAsInt();
        int min = Arrays.stream(nums).min().getAsInt();

        for (int k = min, n = 0; k < max + 1;) {
            if (map.containsKey(k) && map.get(k) != 0) {
                nums[n++] = k;
                map.put(k, map.get(k) - 1);
            } else {
                k++;
            }
        }
    }

    private static void countSortWithArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            max = (max < nums[i]) ? nums[i] : max;
        }

        int[] frequency = new int[max + 1];
        for (int i = 0; i < nums.length; i++) {
            frequency[nums[i]]++;
        }

        for (int f = 0, n = 0; n < nums.length;) {
            if (frequency[f] != 0) {
                nums[n++] = f;
                frequency[f]--;
            } else {
                f++;
            }
        }
    }
}

package Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SubsetsII {
    public static void main(String[] args) {
        int[] nums = { 4, 4, 4, 1, 4 };
        System.out.println(subsetsWithDup(nums));
    }

    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Set<List<Integer>> resultSet = new HashSet<>();
        List<Integer> unprocessed = new ArrayList<>();
        Arrays.sort(nums);
        for (int i : nums) {
            unprocessed.add(i);
        }

        helper(new ArrayList<>(), unprocessed, resultSet);
        result.addAll(resultSet);
        return result;
    }

    private static void helper(List<Integer> processed, List<Integer> unprocessed, Set<List<Integer>> result) {
        if (unprocessed.isEmpty()) {
            result.add(new ArrayList<>(processed));
            return;
        }

        // Take it
        processed.add(unprocessed.get(0));
        int val = unprocessed.remove(0);
        helper(processed, unprocessed, result);
        processed.remove(processed.size() - 1);
        unprocessed.add(0, val);

        // Leave it
        val = unprocessed.remove(0);
        helper(processed, unprocessed, result);
        unprocessed.add(0, val);

    }
}

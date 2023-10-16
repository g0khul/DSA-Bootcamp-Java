package Recursion;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public static void main(String[] args) {
        int[] nums = { 1, 2, 3 };
        System.out.println(subsets(nums));
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        List<Integer> unprocessed = new ArrayList<>();
        for (int i : nums) {
            unprocessed.add(i);
        }

        helper(new ArrayList<>(), unprocessed, result);
        return result;
    }

    private static void helper(List<Integer> processed, List<Integer> unprocessed, List<List<Integer>> result) {
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

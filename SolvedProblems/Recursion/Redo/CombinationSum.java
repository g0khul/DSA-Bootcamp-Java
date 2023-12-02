package Recursion.Redo;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public static void main(String[] args) {
        int[] nums = { 2, 3, 5, 8 };
        int target = 8;

        // These are unique combinations. They don't include repeated values like eg:
        // {2,3,5} target of 8 then 2,2,2,2 is also a solution. It doesn't do that so I
        // need to do that in the another function
        List<List<Integer>> result = getUniqueCombination(nums, target, 0, new ArrayList<>(),
                new ArrayList<List<Integer>>());
        System.out.println(result);

        result = getCombination(nums, target, 0, new ArrayList<>(), new ArrayList<List<Integer>>());
        System.out.println(result);
    }

    private static List<List<Integer>> getCombination(int[] nums, int target, int index, ArrayList<Integer> processed,
            List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(processed));
            return result;
        }

        if (target < 0 || index >= nums.length) {
            return result;
        }

        for (int i = index; i < nums.length; i++) {
            processed.add(nums[i]);
            getCombination(nums, target - nums[i], i, processed, result);
            processed.remove(processed.size() - 1);
        }

        return result;
    }

    private static List<List<Integer>> getUniqueCombination(int[] nums, int target, int index, List<Integer> processed,
            ArrayList<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(processed));
            return result;
        }

        if (target < 0 || index >= nums.length) {
            return result;
        }

        // Take it
        processed.add(nums[index]);
        getUniqueCombination(nums, target - nums[index], index + 1, processed, result);
        processed.remove(processed.size() - 1);

        // Leave it
        getUniqueCombination(nums, target, index + 1, processed, result);

        return result;
    }

}

package Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if (candidates.length == 0) {
            return new ArrayList<>();
        }

        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        helper(candidates, target, 0, result, new ArrayList<>());

        return result;
    }

    private static void helper(int[] candidates, int target, int index, List<List<Integer>> result,
            ArrayList<Integer> answer) {
        if (target == 0) {
            result.add(new ArrayList<>(answer));
            return;
        }

        if (target < 0) {
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            if (i > index && candidates[i] == candidates[i - 1]) {
                continue;
            }
            answer.add(candidates[i]);
            helper(candidates, target - candidates[i], i + 1, result, answer);
            answer.remove(answer.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = { 10, 1, 2, 7, 6, 1, 5 };
        int target = 8;
        System.out.println(combinationSum2(nums, target));
    }
}

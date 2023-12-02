package CPfor100Days.Recursion;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumIII {
    public static List<List<Integer>> combinationSum3(int k, int n) {
        int sum = (k * (k + 1)) / 2;

        if (sum > n) {
            return new ArrayList<>();
        }

        List<List<Integer>> result = new ArrayList<>();

        helper(k, n, 1, new ArrayList<>(), result);

        return result;
    }

    private static void helper(int k, int n, int index, ArrayList<Integer> answer, List<List<Integer>> result) {
        if (n == 0 && k == 0) {
            result.add(new ArrayList<>(answer));
            return;
        }

        if (n < 0) {
            return;
        }

        for (int i = index; i < 10; i++) {
            answer.add(i);
            helper(k - 1, n - i, i + 1, answer, result);
            answer.remove(answer.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(combinationSum3(3, 7));
    }
}

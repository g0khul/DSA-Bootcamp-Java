import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NumberOfDiceRollsWithTargetSum {
    public static void main(String[] args) {
        int n = 30;
        int k = 30;
        int target = 500;

        System.out.println(numRollsToTarget(n, k, target));
    }

    public static int numRollsToTarget(int n, int k, int target) {
        int count = 0;
        Map<List<Integer>, Integer> map = new HashMap<>();
        count = helper(n, k, target, map);
        return count;
    }

    public static int helper(int n, int k, int target, Map<List<Integer>, Integer> map) {
        if (n == 0) {
            return (target == 0) ? 1 : 0;
        }

        List<Integer> list = new ArrayList<>(List.of(n, target));
        if(map.containsKey(list)){
            return map.get(list);
        }

        int count = 0;

        for (int i = 1; i <= k; i++) {
            int MOD = (int) Math.pow(10, 9) + 7;
            count = (count + helper(n - 1, k, target - i, map)) % MOD;
        }
        map.put(list, count);

        return count;
    }
}

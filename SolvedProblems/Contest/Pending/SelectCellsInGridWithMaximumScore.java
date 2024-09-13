import java.util.*;

public class SelectCellsInGridWithMaximumScore {
    public static void main(String[] args) {
        int[][] matrix = {
                { 8, 7, 6 },
                { 8, 3, 2 }
        };

        List<List<Integer>> grid = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            int[] m = matrix[i];
            grid.add(new ArrayList<>());
            for (int j = 0; j < m.length; j++) {
                grid.get(i).add(m[j]);
            }
        }

        System.out.println(maxScore(grid));
        System.out.println(maxScoreDp(grid));
    }

    public static int maxScore(List<List<Integer>> grid) {
        Map<String, Integer> memo = new HashMap<>();
        return helperRecursion(grid, grid.size(), grid.get(0).size(), 0, new HashSet<>(), memo);
    }

    public static int helperRecursion(List<List<Integer>> grid, int n, int m, int index, Set<Integer> hash,
            Map<String, Integer> memo) {
        if (index == n) {
            return 0;
        }

        String hashKey = index + hash.toString();

        if (memo.containsKey(hashKey)) {
            return memo.get(hashKey);
        }

        int result = Integer.MIN_VALUE;
        for (int i = 0; i < m; i++) {
            int num = grid.get(index).get(i);
            if (!hash.contains(num)) {
                hash.add(num);
                int curr = num + helperRecursion(grid, n, m, index + 1, hash, memo);
                hash.remove(num);
                result = Math.max(result, curr);
            } else {
                int curr = helperRecursion(grid, n, m, index + 1, hash, memo);
                result = Math.max(result, curr);
            }
        }

        memo.put(hashKey, result);
        return result;
    }
}

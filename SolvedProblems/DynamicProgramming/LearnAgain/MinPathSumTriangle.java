import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinPathSumTriangle {
    public static void main(String[] args) {
        List<Integer> row1 = new ArrayList<>(Arrays.asList(1));
        List<Integer> row2 = new ArrayList<>(Arrays.asList(2, 3));
        List<Integer> row3 = new ArrayList<>(Arrays.asList(4, 5, 6));
        List<Integer> row4 = new ArrayList<>(Arrays.asList(7, 8, 9, 10));
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(row1);
        triangle.add(row2);
        triangle.add(row3);
        triangle.add(row4);

        System.out.println(minimumTotalRecursion(triangle));
        System.out.println(minimumTotalMemoization(triangle));
        System.out.println(minimumTotalDp(triangle));
        System.out.println(minimumTotalDpSpaceOptimized(triangle));
    }

    public static int minimumTotalRecursion(List<List<Integer>> triangle) {
        return helperRecursion(triangle, 0, 0);
    }

    public static int helperRecursion(List<List<Integer>> triangle, int i, int j) {
        if (j > i + 1 || i >= triangle.size()) {
            return Integer.MAX_VALUE;
        }

        int pathSum = triangle.get(i).get(j);
        int down = helperRecursion(triangle, i + 1, j);
        int diagnol = helperRecursion(triangle, i + 1, j + 1);

        if (down == Integer.MAX_VALUE && diagnol == Integer.MAX_VALUE) {
            return pathSum;
        }
        if (down == Integer.MAX_VALUE) {
            return diagnol;
        }

        if (diagnol == Integer.MAX_VALUE) {
            return down;
        }

        return pathSum + Integer.min(down, diagnol);
    }

    public static int minimumTotalMemoization(List<List<Integer>> triangle) {
        List<List<Integer>> memo = new ArrayList<>();
        for (List<Integer> list : triangle) {
            List<Integer> curr = new ArrayList<>();
            for (int i = 0; i < list.size(); i++) {
                curr.add(-1);
            }
            memo.add(curr);
        }
        return helperMemoization(triangle, 0, 0, memo);
    }

    public static int helperMemoization(List<List<Integer>> triangle, int i, int j, List<List<Integer>> memo) {
        if (j > i + 1 || i >= triangle.size()) {
            return Integer.MAX_VALUE;
        }

        if (memo.get(i).get(j) != -1) {
            return memo.get(i).get(j);
        }

        int pathSum = triangle.get(i).get(j);
        int down = helperMemoization(triangle, i + 1, j, memo);
        int diagnol = helperMemoization(triangle, i + 1, j + 1, memo);

        if (down == Integer.MAX_VALUE && diagnol == Integer.MAX_VALUE) {
            memo.get(i).add(j, pathSum);
            return pathSum;
        }
        if (down == Integer.MAX_VALUE) {
            memo.get(i).add(j, diagnol);
            return diagnol;
        }

        if (diagnol == Integer.MAX_VALUE) {
            memo.get(i).add(j, down);
            return down;
        }

        memo.get(i).add(j, pathSum + Integer.min(down, diagnol));
        return memo.get(i).get(j);
    }

    public static int minimumTotalDp(List<List<Integer>> triangle) {
        int[][] dp = new int[triangle.size()][];

        for (int i = 0; i < triangle.size(); i++) {
            int[] curr = new int[triangle.get(i).size()];
            Arrays.fill(curr, -1);
            dp[i] = curr;
        }

        for (int i = 0; i < triangle.get(triangle.size() - 1).size(); i++) {
            dp[triangle.size() - 1][i] = triangle.get(triangle.size() - 1).get(i);
        }

        for (int i = triangle.size() - 2; i >= 0; i--) {
            for (int j = triangle.get(i).size() - 1; j >= 0; j--) {
                int pathSum = triangle.get(i).get(j);
                int up = dp[i + 1][j];
                int diagnol = dp[i + 1][j + 1];
                dp[i][j] = pathSum + Integer.min(up, diagnol);
            }
        }

        return dp[0][0];
    }

    public static int minimumTotalDpSpaceOptimized(List<List<Integer>> triangle) {
        int[] prev = new int[triangle.get(triangle.size() - 1).size()];

        for (int i = 0; i < prev.length; i++) {
            prev[i] = triangle.get(triangle.size() - 1).get(i);
        }

        for (int i = triangle.size() - 2; i >= 0; i--) {
            int[] curr = new int[triangle.get(i).size()];
            for (int j = triangle.get(i).size() - 1; j >= 0; j--) {
                int pathSum = triangle.get(i).get(j);
                int up = prev[j];
                int diagnol = prev[j + 1];
                curr[j] = pathSum + Integer.min(up, diagnol);
            }
            prev = curr;
        }

        return prev[0];
    }
}

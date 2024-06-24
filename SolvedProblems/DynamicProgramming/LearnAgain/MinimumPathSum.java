import java.util.Arrays;

public class MinimumPathSum {
    public static void main(String[] args) {
        int[][] grid = {
                { 1, 2, 3 },
                { 4, 5, 6 }
        };

        System.out.println(minPathSumRecursion(grid));
        System.out.println(minPathSumMemoization(grid));
        System.out.println(minPathSumDP(grid));
        System.out.println(minPathSumDPSpaceOptimized(grid));
    }

    public static int minPathSumRecursion(int[][] grid) {
        return helperRecursion(grid, grid.length - 1, grid[0].length - 1);
    }

    public static int helperRecursion(int[][] grid, int i, int j) {
        if (i == 0 && j == 0) {
            return grid[i][j];
        }

        if (i < 0 || j < 0) {
            return Integer.MAX_VALUE;
        }

        int up = helperRecursion(grid, i - 1, j);
        if (up != Integer.MAX_VALUE) {
            up += grid[i][j];
        }
        int left = helperRecursion(grid, i, j - 1);
        if (left != Integer.MAX_VALUE) {
            left += grid[i][j];
        }

        return Integer.min(up, left);
    }

    public static int minPathSumMemoization(int[][] grid) {
        int[][] memo = new int[grid.length][grid[0].length];
        for (int[] is : memo) {
            Arrays.fill(is, -1);
        }
        return helperMemoization(grid, grid.length - 1, grid[0].length - 1, memo);
    }

    public static int helperMemoization(int[][] grid, int i, int j, int[][] memo) {
        if (i == 0 && j == 0) {
            return grid[i][j];
        }

        if (i < 0 || j < 0) {
            return Integer.MAX_VALUE;
        }

        if (memo[i][j] != -1) {
            return memo[i][j];
        }

        int up = helperMemoization(grid, i - 1, j, memo);
        if (up != Integer.MAX_VALUE) {
            up += grid[i][j];
        }
        int left = helperMemoization(grid, i, j - 1, memo);
        if (left != Integer.MAX_VALUE) {
            left += grid[i][j];
        }

        return memo[i][j] = Integer.min(up, left);
    }

    public static int minPathSumDP(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];

        for (int[] is : dp) {
            Arrays.fill(is, -1);
        }

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = grid[i][j];
                } else {
                    int up = Integer.MAX_VALUE;
                    int left = Integer.MAX_VALUE;

                    if (i > 0) {
                        up = grid[i][j] + dp[i - 1][j];
                    }

                    if (j > 0) {
                        left = grid[i][j] + dp[i][j - 1];
                    }

                    dp[i][j] = Integer.min(up, left);
                }
            }
        }

        return dp[grid.length - 1][dp[0].length - 1];
    }

    public static int minPathSumDPSpaceOptimized(int[][] grid) {
        int[] dp = new int[grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            int[] temp = new int[grid[0].length];
            for (int j = 0; j < grid[i].length; j++) {
                if (i == 0 && j == 0) {
                    temp[0] = grid[i][j];
                } else {
                    int up = Integer.MAX_VALUE;
                    int left = Integer.MAX_VALUE;

                    if (i > 0) {
                        up = grid[i][j] + dp[j];
                    }

                    if (j > 0) {
                        left = grid[i][j] + temp[j - 1];
                    }

                    temp[j] = Integer.min(up, left);
                }
            }
            dp = temp;
        }

        return dp[dp.length - 1];
    }
}

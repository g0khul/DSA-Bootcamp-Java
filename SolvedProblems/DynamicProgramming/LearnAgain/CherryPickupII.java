import java.util.Arrays;

public class CherryPickupII {
    public static void main(String[] args) {
        int[][] grid = {
                { 2, 3, 1, 2 },
                { 3, 4, 2, 2 },
                { 5, 6, 3, 5 }
        };

        System.out.println(cherryPickupRecursion(grid));
        System.out.println(cherryPickupMemoization(grid));
        System.out.println(cherryPickupDp(grid));
        System.out.println(cherryPickupSpaceOptimization(grid));
    }

    public static int cherryPickupRecursion(int[][] grid) {
        return helperRecursion(grid, 0, 0, grid[0].length - 1);
    }

    public static int helperRecursion(int[][] grid, int i, int j1, int j2) {
        if (j1 < 0 || j1 > grid[0].length - 1 || j2 < 0 || j2 > grid[0].length - 1) {
            return Integer.MIN_VALUE;
        }

        if (i == grid.length - 1) {
            return (j1 == j2) ? grid[i][j1] : grid[i][j1] + grid[i][j2];
        }

        int maxCherryPickup = Integer.MIN_VALUE;
        for (int x = -1; x < 2; x++) {
            for (int y = -1; y < 2; y++) {
                int currMaxCherryPicup = (j1 == j2) ? grid[i][j1] : grid[i][j1] + grid[i][j2];
                currMaxCherryPicup += helperRecursion(grid, i + 1, j1 + x, j2 + y);
                maxCherryPickup = Math.max(maxCherryPickup, currMaxCherryPicup);
            }
        }

        return maxCherryPickup;
    }

    public static int cherryPickupMemoization(int[][] grid) {
        int[][][] memo = new int[grid.length][grid[0].length][grid[0].length];
        for (int[][] is : memo) {
            for (int[] is2 : is) {
                Arrays.fill(is2, -1);
            }
        }

        for (int i = 0; i < memo.length; i++) {
            for (int j = 0; j < memo[i].length; j++) {
                for (int k = 0; k < memo[i][j].length; k++) {
                    memo[i][j][k] = -1;
                }
            }
        }
        return helperMemoization(grid, 0, 0, grid[0].length - 1, memo);
    }

    public static int helperMemoization(int[][] grid, int i, int j1, int j2, int[][][] memo) {
        if (j1 < 0 || j1 > grid[0].length - 1 || j2 < 0 || j2 > grid[0].length - 1) {
            return Integer.MIN_VALUE;
        }

        if (i == grid.length - 1) {
            return (j1 == j2) ? grid[i][j1] : grid[i][j1] + grid[i][j2];
        }

        if (memo[i][j1][j2] != -1) {
            return memo[i][j1][j2];
        }

        int maxCherryPickup = Integer.MIN_VALUE;
        for (int x = -1; x < 2; x++) {
            for (int y = -1; y < 2; y++) {
                int currMaxCherryPickup = (j1 == j2) ? grid[i][j1] : grid[i][j1] + grid[i][j2];
                currMaxCherryPickup += helperMemoization(grid, i + 1, j1 + x, j2 + y, memo);
                maxCherryPickup = Integer.max(maxCherryPickup, currMaxCherryPickup);
            }
        }

        return maxCherryPickup;
    }

    public static int cherryPickupDp(int[][] grid) {
        int[][][] dp = new int[grid.length][grid[0].length][grid[0].length];

        for (int j1 = 0; j1 < grid[0].length; j1++) {
            for (int j2 = 0; j2 < grid[0].length; j2++) {
                dp[grid.length - 1][j1][j2] = (j1 == j2) ? grid[grid.length - 1][j1]
                        : grid[grid.length - 1][j1] + grid[grid.length - 1][j2];
            }
        }

        for (int i = grid.length - 2; i >= 0; i--) {
            for (int j1 = 0; j1 < grid[0].length; j1++) {
                for (int j2 = 0; j2 < grid[0].length; j2++) {
                    int maxCherryPickup = Integer.MIN_VALUE;
                    for (int x = -1; x < 2; x++) {
                        for (int y = -1; y < 2; y++) {
                            int currMaxCherryPickup = (j1 == j2) ? grid[i][j1] : grid[i][j1] + grid[i][j2];
                            if (j1 + x >= 0 && j1 + x < grid[0].length && j2 + y >= 0
                                    && j2 + y < grid[0].length) {
                                currMaxCherryPickup += dp[i + 1][j1 + x][j2 + y];
                            }
                            maxCherryPickup = Integer.max(maxCherryPickup, currMaxCherryPickup);
                        }
                    }
                    dp[i][j1][j2] = maxCherryPickup;
                }
            }
        }

        return dp[0][0][grid[0].length - 1];
    }

    public static int cherryPickupSpaceOptimization(int[][] grid) {
        int[][] front = new int[grid[0].length][grid[0].length];

        for (int j1 = 0; j1 < grid[0].length; j1++) {
            for (int j2 = 0; j2 < grid[0].length; j2++) {
                front[j1][j2] = (j1 == j2) ? grid[grid.length - 1][j1]
                        : grid[grid.length - 1][j1] + grid[grid.length - 1][j2];
            }
        }

        for (int i = grid.length - 2; i >= 0; i--) {
            int[][] current = new int[grid[0].length][grid[0].length];
            for (int j1 = 0; j1 < grid[0].length; j1++) {
                for (int j2 = 0; j2 < grid[0].length; j2++) {
                    int maxCherryPickup = Integer.MIN_VALUE;
                    for (int x = -1; x < 2; x++) {
                        for (int y = -1; y < 2; y++) {
                            int currMaxCherryPickup = (j1 == j2) ? grid[i][j1] : grid[i][j1] + grid[i][j2];
                            if (j1 + x >= 0 && j1 + x < grid[0].length && j2 + y >= 0
                                    && j2 + y < grid[0].length) {
                                currMaxCherryPickup += front[j1 + x][j2 + y];
                            }
                            maxCherryPickup = Integer.max(maxCherryPickup, currMaxCherryPickup);
                        }
                    }
                    current[j1][j2] = maxCherryPickup;
                }
            }
            front = current;
        }

        return front[0][grid[0].length - 1];
    }
}

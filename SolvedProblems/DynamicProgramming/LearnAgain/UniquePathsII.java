import java.util.Arrays;

public class UniquePathsII {
    public static void main(String[] args) {
        int[][] obstacleGrid = {
                { 0, 0, 0 },
                { 0, 1, 0 },
                { 0, 0, 0 }
        };

        System.out.println(uniquePathsWithObstaclesRecursion(obstacleGrid));
        System.out.println(uniquePathsWithObstaclesMemoization(obstacleGrid));
        System.out.println(uniquePathsWithObstaclesDP(obstacleGrid));
        System.out.println(uniquePathsWithObstaclesDPSpaceOptimization(obstacleGrid));
    }

    public static int uniquePathsWithObstaclesRecursion(int[][] obstacleGrid) {
        return helperRecursion(obstacleGrid, obstacleGrid.length - 1, obstacleGrid[0].length - 1);
    }

    public static int helperRecursion(int[][] obstacleGrid, int row, int col) {
        if (row == 0 && col == 0 && obstacleGrid[row][col] != 1) {
            return 1;
        }

        if (row < 0 || col < 0 || obstacleGrid[row][col] == 1) {
            return 0;
        }

        int left = helperRecursion(obstacleGrid, row, col - 1);
        int top = helperRecursion(obstacleGrid, row - 1, col);

        return left + top;
    }

    public static int uniquePathsWithObstaclesMemoization(int[][] obstacleGrid) {
        int[][] memo = new int[obstacleGrid.length][obstacleGrid[0].length];
        for (int[] is : memo) {
            Arrays.fill(is, -1);
        }
        return helperMemoization(obstacleGrid, obstacleGrid.length - 1, obstacleGrid[0].length - 1, memo);
    }

    public static int helperMemoization(int[][] obstacleGrid, int row, int col, int[][] memo) {
        if (row == 0 && col == 0 && obstacleGrid[row][col] != 1) {
            return 1;
        }

        if (row < 0 || col < 0 || obstacleGrid[row][col] == 1) {
            return 0;
        }

        if (memo[row][col] != -1) {
            return memo[row][col];
        }

        int left = helperMemoization(obstacleGrid, row, col - 1, memo);
        int top = helperMemoization(obstacleGrid, row - 1, col, memo);

        return memo[row][col] = left + top;
    }

    public static int uniquePathsWithObstaclesDP(int[][] obstacleGrid) {
        int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];

        for (int row = 0; row < obstacleGrid.length; row++) {
            for (int col = 0; col < obstacleGrid[row].length; col++) {
                if (row == 0 && col == 0 && obstacleGrid[row][col] != 1) {
                    dp[row][col] = 1;
                } else {
                    int left = 0;
                    int top = 0;
                    if (col > 0 && obstacleGrid[row][col] != 1) {
                        left = dp[row][col - 1];
                    }
                    if (row > 0 && obstacleGrid[row][col] != 1) {
                        top = dp[row - 1][col];
                    }

                    dp[row][col] = top + left;
                }
            }
        }

        return dp[dp.length - 1][dp[0].length - 1];
    }

    public static int uniquePathsWithObstaclesDPSpaceOptimization(int[][] obstacleGrid) {
        int[] dp = new int[obstacleGrid[0].length];

        for (int row = 0; row < obstacleGrid.length; row++) {
            int[] temp = new int[obstacleGrid[row].length];
            for (int col = 0; col < obstacleGrid[row].length; col++) {
                if (row == 0 && col == 0 && obstacleGrid[row][col] != 1) {
                    temp[col] = 1;
                } else {
                    int left = 0;
                    int top = 0;
                    if (col > 0 && obstacleGrid[row][col] != 1) {
                        left = temp[col - 1];
                    }

                    if (row > 0 && obstacleGrid[row][col] != 1) {
                        top = dp[col];
                    }

                    temp[col] = left + top;
                }
            }
            dp = temp;
        }

        return dp[dp.length - 1];
    }
}

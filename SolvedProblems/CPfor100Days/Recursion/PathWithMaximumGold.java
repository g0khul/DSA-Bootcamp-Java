package Recursion;

public class PathWithMaximumGold {
    public static void main(String[] args) {
        int[][] grid = {
                { 1, 0, 7, 0, 0, 0 },
                { 2, 0, 6, 0, 1, 0 },
                { 3, 5, 6, 7, 4, 2 },
                { 4, 3, 1, 0, 2, 0 },
                { 3, 0, 5, 0, 20, 0 }
        };

        System.out.println(getMaximumGold(grid));
    }

    public static int getMaximumGold(int[][] grid) {
        int max = Integer.MIN_VALUE;
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                int currmax = getGold(grid, new boolean[grid.length][grid[row].length], row, col);
                if (currmax > max) {
                    max = currmax;
                }
            }
        }

        return max;
    }

    private static int getGold(int[][] grid, boolean[][] marker, int row, int col) {
        if (row < 0 || row == grid.length || col < 0 || col == grid[row].length || marker[row][col]) {
            return 0;
        }

        if (grid[row][col] == 0) {
            return 0;
        }

        marker[row][col] = true;
        int currmax = grid[row][col]
                + Math.max(
                        Math.max(
                                getGold(grid, marker, row - 1, col),
                                getGold(grid, marker, row + 1, col)),
                        Math.max(
                                getGold(grid, marker, row, col - 1),
                                getGold(grid, marker, row, col + 1)));

        marker[row][col] = false;

        return currmax;
    }
}

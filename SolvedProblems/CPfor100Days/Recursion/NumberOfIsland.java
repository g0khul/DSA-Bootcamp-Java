package Recursion;

public class NumberOfIsland {
    public int numIslands(char[][] grid) {
        return getIsland(grid, new boolean[grid.length][grid[0].length]);
    }

    private int getIsland(char[][] grid, boolean[][] marker) {
        int island = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (!marker[i][j] && grid[i][j] == '1') {
                    marker[i][j] = true;
                    island += helperIsland(grid, marker, i, j);
                }
            }
        }
        return island;
    }

    private int helperIsland(char[][] grid, boolean[][] marker, int row, int col) {
        if (row >= grid.length || row < 0 || col >= grid[0].length || col < 0) {
            return 1;
        }

        // Check right
        if (col + 1 < grid[row].length && !marker[row][col + 1] && grid[row][col + 1] == '1') {
            marker[row][col + 1] = true;
            helperIsland(grid, marker, row, col + 1);
        }

        // Check down
        if (row + 1 < grid.length && !marker[row + 1][col] && grid[row + 1][col] == '1') {
            marker[row + 1][col] = true;
            helperIsland(grid, marker, row + 1, col);
        }

        // Check left
        if (col - 1 >= 0 && !marker[row][col - 1] && grid[row][col - 1] == '1') {
            marker[row][col - 1] = true;
            helperIsland(grid, marker, row, col - 1);
        }

        // Check up
        if (row - 1 >= 0 && !marker[row - 1][col] && grid[row - 1][col] == '1') {
            marker[row - 1][col] = true;
            helperIsland(grid, marker, row - 1, col);
        }

        return 1;
    }

    public static void main(String[] args) {
        // char[][] grid = {
        // { '1', '1', '1', '1', '0' },
        // { '1', '1', '0', '1', '0' },
        // { '1', '1', '0', '0', '0' },
        // { '0', '0', '0', '0', '0' }
        // };

        char[][] grid = {
                { '1', '1', '0', '0', '0' },
                { '1', '1', '0', '0', '0' },
                { '0', '0', '1', '0', '0' },
                { '0', '0', '0', '1', '1' }
        };

        NumberOfIsland obj = new NumberOfIsland();
        System.out.println(obj.numIslands(grid));
    }
}

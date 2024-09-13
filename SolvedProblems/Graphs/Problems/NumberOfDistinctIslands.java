import java.util.*;

public class NumberOfDistinctIslands {
    public static void main(String[] args) {
        int[][] grid = {
                { 1, 1, 0, 0, 0 },
                { 1, 1, 0, 0, 0 },
                { 0, 0, 0, 1, 1 },
                { 0, 0, 0, 1, 1 }
        };

        System.out.println(countDistinctIslands(grid));
    }

    public static int countDistinctIslands(int[][] grid) {
        Set<String> hash = new HashSet<>();
        boolean[][] visited = new boolean[grid.length][grid[0].length];

        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                if (!visited[row][col] && grid[row][col] == 1) {
                    List<int[]> shape = new ArrayList<>();
                    dfs(row, col, grid, visited, row, col, shape);
                    String shapeString = toString(shape);
                    hash.add(shapeString);
                }
            }
        }

        for (String s : hash) {
            System.out.println(s);
        }

        return hash.size();
    }

    public static String toString(List<int[]> shape) {
        StringBuilder sb = new StringBuilder();
        for (int[] pair : shape) {
            int row = pair[0];
            int col = pair[1];
            sb.append(row + " " + col);
        }
        return sb.toString();
    }

    public static void dfs(int row, int col, int[][] grid, boolean[][] visited, int baserow, int basecol,
            List<int[]> shape) {
        if (row < 0 || row == grid.length || col < 0 || col == grid[row].length || visited[row][col]
                || grid[row][col] != 1) {
            return;
        }

        visited[row][col] = true;
        shape.add(new int[] { baserow - row, basecol - col });

        int[] delrow = { -1, 0, 1, 0 };
        int[] delcol = { 0, 1, 0, -1 };

        for (int k = 0; k < 4; k++) {
            int nrow = row + delrow[k];
            int ncol = col + delcol[k];
            dfs(nrow, ncol, grid, visited, baserow, basecol, shape);
        }

        return;
    }
}

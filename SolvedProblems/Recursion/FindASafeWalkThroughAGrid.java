import java.util.*;

public class FindASafeWalkThroughAGrid {
    public static void main(String[] args) {
        int[][] gridArray = {
                { 0, 1, 0, 0, 0 },
                { 0, 1, 0, 1, 0 },
                { 0, 0, 0, 1, 0 }
        };
        List<List<Integer>> grid = new ArrayList<>();
        for (int i = 0; i < gridArray.length; i++) {
            grid.add(new ArrayList<>());
            for (int j = 0; j < gridArray[i].length; j++) {
                grid.get(i).add(gridArray[i][j]);
            }
        }
        System.out.println(findSafeWalk(grid, 1));
    }

    public static boolean findSafeWalk(List<List<Integer>> grid, int health) {
        Boolean[][][] memo = new Boolean[grid.size()][grid.get(0).size()][health + 1];
        boolean[][] visited = new boolean[grid.size()][grid.get(0).size()];
        return helperResursion(grid, memo, visited, 0, 0, health);
    }

    public static boolean helperResursion(List<List<Integer>> grid, Boolean[][][] memo, boolean[][] visited, int row,
            int col, int health) {
        if (health <= 0 || row < 0 || row >= grid.size() || col < 0 || col >= grid.get(0).size() || visited[row][col]) {
            return false;
        }

        int cellValue = grid.get(row).get(col);
        if (cellValue == 1) {
            health--;
        }

        if (health <= 0) {
            return false;
        }

        if (row == grid.size() - 1 && col == grid.get(0).size() - 1) {
            return true;
        }

        if (memo[row][col][health] != null) {
            return memo[row][col][health];
        }

        visited[row][col] = true;
        int[] drow = { -1, 0, 1, 0 };
        int[] dcol = { 0, 1, 0, -1 };

        for (int i = 0; i < drow.length; i++) {
            int nrow = row + drow[i];
            int ncol = col + dcol[i];
            if (helperResursion(grid, memo, visited, nrow, ncol, health)) {
                memo[row][col][health] = true;
                return true;
            }
        }

        visited[row][col] = false;
        return memo[row][col][health] = false;
    }
}

// There are 100 cells. Initially every cells is closed (false) you have to start from 
// cell 1 to 100. If I go for first cell then invert the cells that makes numbers divisible. 
// Eg. 2 then all the even cells will be inverted from true to false or false to true.

public class OpenCells {
    public static void main(String[] args) {
        boolean[][] cells = new boolean[10][10];
        calculateOpen(cells, cells.length);
        display(cells);
    }

    private static void display(boolean[][] cells) {
        for (boolean[] i : cells) {
            for (boolean j : i) {
                System.out.printf(j + "  ");
            }
            System.out.println();
        }
    }

    private static void calculateOpen(boolean[][] cells, int gridSize) {
        for (int i = 1; i <= 100; i++) {
            if (isPerfectSquare(i)) {
                int row = (i - 1) / gridSize;
                int col = (i - 1) % gridSize;
                cells[row][col] = true;
            }
        }
    }

    private static boolean isPerfectSquare(int num) {
        if (num < 0) {
            return false;
        }

        int sqrt = (int) Math.sqrt(num);
        return sqrt * sqrt == num;
    }
}
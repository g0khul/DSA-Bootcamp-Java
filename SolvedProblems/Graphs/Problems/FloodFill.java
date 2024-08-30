import java.util.*;

public class FloodFill {
    public static void main(String[] args) {
        int[][] image = {
                { 0, 0, 0 },
                { 0, 0, 0 }
        };

        int sr = 1;
        int sc = 0;
        int color = 2;

        image = floodFill(image, sr, sc, color);

        for (int[] is : image) {
            System.out.println(Arrays.toString(is));
        }
    }

    public static int[][] floodFill(int[][] image, int sr, int sc, int color) {
        boolean[][] visited = new boolean[image.length][image[sr].length];
        dfs(image, visited, sr, sc, color, image[sr][sc]);
        return image;
    }

    public static void dfs(int[][] image, boolean[][] visited, int sr, int sc, int color, int pattern) {
        if (sr < 0 || sr >= image.length || sc < 0 || sc >= image[sr].length || visited[sr][sc]
                || image[sr][sc] != pattern) {
            return;
        }

        visited[sr][sc] = true;
        image[sr][sc] = color;
        // up
        dfs(image, visited, sr - 1, sc, color, pattern);
        // down
        dfs(image, visited, sr + 1, sc, color, pattern);
        // left
        dfs(image, visited, sr, sc - 1, color, pattern);
        // right
        dfs(image, visited, sr, sc + 1, color, pattern);
    }
}

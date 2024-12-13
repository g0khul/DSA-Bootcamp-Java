import java.util.*;

public class FloydWarshall {
    public static void main(String[] args) {
        // Edge weight matrix
        int[][] mat = {
                { 0, 1, 43 },
                { 1, 0, 6 },
                { -1, -1, 0 },
        };

        shortestDistance(mat);

        for (int[] is : mat) {
            System.out.println(Arrays.toString(is));
        }
    }

    public static void shortestDistance(int[][] mat) {
        int n = mat.length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == -1) {
                    mat[i][j] = (int) 1e9;
                } else if (i == j) {
                    mat[i][j] = 0;
                }
            }
        }

        for (int via = 0; via < n; via++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    mat[i][j] = Math.min(mat[i][j], mat[i][via] + mat[via][j]);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (mat[i][i] < 0) {
                System.out.println("Contains negative cycle");
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == (int) 1e9) {
                    mat[i][j] = -1;
                }
            }
        }
    }
}

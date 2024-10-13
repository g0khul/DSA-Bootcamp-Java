import java.util.*;

public class PascalsTriangle {
    public static void main(String[] args) {
        int numRows = 5;
        System.out.println(generate(numRows));
    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();

        for (int n = 1; n <= numRows; n++) {
            List<Integer> curr = new ArrayList<>();
            int ans = 1;
            curr.add(ans);
            for (int i = 1; i < n; i++) {
                ans = ans * (n - i);
                ans = ans / i;
                curr.add(ans);
            }
            result.add(curr);
        }

        return result;
    }
}

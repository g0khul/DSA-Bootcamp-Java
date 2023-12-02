package CPfor100Days.Recursion;

public class KthSymbolInGrammar {
    public static int kthGrammar(int n, int k) {
        // Direct approach
        // return ((int) helper(n, "0").charAt(k - 1) - 48 == 0) ? 1 : 0;

        if (n == 1) {
            return 0;
        }

        return helper(n, k);
    }

    private static int helper(int n, int k) {
        if (n == 1) {
            return 0;
        }

        int prevLength = 1 << (n - 2);

        if (k <= prevLength) {
            helper(n - 1, k);
        }
        return (helper(n - 1, k - prevLength) == 0) ? 1 : 0;
    }

    // private static String helper(int n, String string) {
    // if (n == 1) {
    // return string;
    // }

    // if (string.equals("0")) {
    // return helper(n - 1, "0") + helper(n - 1, "1");
    // }

    // return helper(n - 1, "1") + helper(n - 1, "0");
    // }

    public static void main(String[] args) {
        System.out.println(kthGrammar(30, 434991989));
    }
}

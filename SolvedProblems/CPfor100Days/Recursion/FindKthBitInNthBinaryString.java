package CPfor100Days.Recursion;

public class FindKthBitInNthBinaryString {
    public char findKthBit(int n, int k) {
        String[] memo = new String[n + 1];
        memo[1] = "0";
        return helper(n, memo).charAt(k - 1);
    }

    // Using memoization
    private String helper(int n, String[] memo) {
        if (n <= 1) {
            return memo[1];
        }

        if (memo[n] != null) {
            return memo[n];
        }

        memo[n] = helper(n - 1, memo) + "1" + reverse(invert(new StringBuilder(helper(n - 1, memo))));
        return memo[n];
    }

    // Without using memoization
    // private String helper(int n) {
    //     if (n <= 1) {
    //         return "0";
    //     }

    //     return helper(n - 1) + "1" + reverse(invert(new StringBuilder(helper(n - 1))));
    // }

    private String reverse(StringBuilder invert) {
        return invert.reverse().toString();
    }

    private StringBuilder invert(StringBuilder result) {
        for (int i = 0; i < result.length(); i++) {
            if (result.charAt(i) == '0') {
                result.setCharAt(i, '1');
            } else {
                result.setCharAt(i, '0');
            }
        }
        return result;
    }

    public static void main(String[] args) {
        FindKthBitInNthBinaryString obj = new FindKthBitInNthBinaryString();
        System.out.println(obj.findKthBit(4, 11));
    }
}

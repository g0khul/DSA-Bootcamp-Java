import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PalindromePartitioningII {
    public static void main(String[] args) {
        String s = "bababcbadcede";
        System.out.println(minCutRecursion(s));
        System.out.println(minCutMemoization(s));
        System.out.println(minCutDp(s));
    }

    public static int minCutRecursion(String s) {
        return helperRecursion(s, 0) - 1;
    }

    public static int helperRecursion(String s, int front) {
        if (front == s.length()) {
            return 0;
        }

        int min = Integer.MAX_VALUE;
        for (int i = front; i < s.length(); i++) {
            if (isPalindrome(s, front, i)) {
                int currMin = 1 + helperRecursion(s, i + 1);
                min = Math.min(min, currMin);
            }
        }

        return min;
    }

    public static int minCutMemoization(String s) {
        int[] memo = new int[s.length()];
        Arrays.fill(memo, -1);
        return helperMemoization(s, 0, memo) - 1;
    }

    public static int helperMemoization(String s, int front, int[] memo) {
        if (front == s.length()) {
            return 0;
        }

        if (memo[front] != -1) {
            return memo[front];
        }

        int min = Integer.MAX_VALUE;
        for (int i = front; i < s.length(); i++) {
            if (isPalindrome(s, front, i)) {
                int currMin = 1 + helperMemoization(s, i + 1, memo);
                min = Math.min(min, currMin);
            }
        }

        return memo[front] = min;
    }

    public static int minCutDp(String s) {
        int[] dp = new int[s.length() + 1];
        dp[s.length()] = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            int min = Integer.MAX_VALUE;
            for (int j = i; j < s.length(); j++) {
                if (isPalindrome(s, i, j)) {
                    int currMin = 1 + dp[j + 1];
                    min = Math.min(min, currMin);
                }
            }
            dp[i] = min;
        }

        return dp[0] - 1;
    }

    public static boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}

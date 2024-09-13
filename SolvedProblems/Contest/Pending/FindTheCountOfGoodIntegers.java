import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FindTheCountOfGoodIntegers {
    public static void main(String[] args) {
        int n = 3;
        int k = 5;
        // TLE Brute Force
        System.out.println(countGoodIntegers(n, k));
    }

    public static long countGoodIntegers(int n, int k) {
        int start = (int) Math.pow(10, n - 1);
        int end = (int) Math.pow(10, n) - 1;

        long count = 0;
        Map<String, Boolean> memo = new HashMap<>();
        for (int i = start; i <= end; i++) {
            String unprocessed = String.valueOf(i);
            if (!memo.containsKey(unprocessed) && isPalindromic(unprocessed, unprocessed, "", k, memo)) {
                count++;
            }
        }

        return count;
    }

    public static boolean isPalindromic(String placeHolder, String unprocessed, String processed, int k,
            Map<String, Boolean> memo) {
        if (unprocessed.isEmpty()) {
            if (processed.charAt(0) == '0') {
                memo.put(placeHolder, false);
                return false;
            }
            int num = Integer.parseInt(processed);
            if (isPalindrome(processed)) {
                boolean res = (num % k == 0);
                memo.put(placeHolder, res);
                return res;
            }
            return false;
        }

        if (memo.containsKey(processed)) {
            return true;
        }

        for (int i = 0; i < processed.length() + 1; i++) {
            String subString = processed.substring(0, i) + unprocessed.charAt(0) + processed.substring(i);
            if (isPalindromic(placeHolder, unprocessed.substring(1), subString, k, memo)) {
                return true;
            }
        }

        return false;
    }

    public static boolean isPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;

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

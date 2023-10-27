package Recursion;

public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("ac"));
    }

    public static String longestPalindrome(String s) {
        if (s.length() == 0) {
            return "";
        }

        String result = "";
        for (int i = 0; i < s.length(); i++) {
            // Odd values
            int left = i;
            int right = i + 1;
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                if (right - left + 1 > result.length()) {
                    result = s.substring(left, right + 1);
                }
                left--;
                right++;
            }

            // Even values
            left = i;
            right = i;
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                if (right - left + 1 > result.length()) {
                    result = s.substring(left, right + 1);
                }
                left--;
                right++;
            }
        }

        return result;
    }

    // private static String helper(String s, int left, int right) {
    // String result = "";

    // while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right))
    // {
    // if (right - left + 1 > result.length()) {
    // result = s.substring(left, right + 1);
    // }
    // left--;
    // right++;
    // }

    // return result;
    // }
}

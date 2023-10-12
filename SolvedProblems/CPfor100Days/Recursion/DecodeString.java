package Recursion;

public class DecodeString {
    public String decodeString(String s) {
        return helper(new StringBuilder(s), 0, 0).toString();
    }

    private StringBuilder helper(StringBuilder s, int start, int end) {
        if (end == s.length() - 1) {
            if (s.charAt(end) == ']') {
                change(s, start, end);
            }
            return s;
        }

        if (Character.isDigit(s.charAt(end))) {
            helper(s, end, end + 1);
        } else if (s.charAt(end) == ']') {
            change(s, start, end);
        } else {
            helper(s, start, end + 1);
        }

        return s;
    }

    private void change(StringBuilder s, int start, int end) {
    }
}

package CPfor100Days.Strings;

public class FindTheIndexOfTheFirstOccurrenceInAString {
    public static void main(String[] args) {
        String haystack = "mississippi";
        String needle = "issip";
        System.out.println(strStr(haystack, needle));
    }

    public static int strStr(String haystack, String needle) {
        int h = 0;
        int n = 0;

        for (; h < haystack.length(); h++) {
            if (n < needle.length() && haystack.charAt(h) == needle.charAt(n)) {
                n++;
            } else if (n == needle.length()) {
                return h - n;
            } else if (n != 0) {
                h = h - n;
                n = 0;
            }
        }

        return (n == needle.length()) ? h - n : -1;
    }
}

package CPfor100Days.Strings;

public class IsSubsequence {
    public static void main(String[] args) {
        String s = "abc";
        String t = "acdbc";
        System.out.println(isSubsequence(s, t));
    }

    public static boolean isSubsequence(String s, String t) {
        int i = 0;
        for (int j = 0; j < t.length(); j++) {
            if (i < s.length() && s.charAt(i) == t.charAt(j)) {
                i++;
            }
        }
        return i == s.length();
    }
}

package CPfor100Days.Strings;

public class ValidPalindrome {
    public static boolean isPalindrome(String s) {
        s = s.toLowerCase();
        StringBuilder sb = new StringBuilder();

        for (char c : s.toCharArray()) {
            if ((c >= 97 && c <= 122) || (c >= 48 && c <= 57)) {
                sb.append(c);
            }
        }

        String actual = sb.toString();
        String reverse = sb.reverse().toString();

        return actual.equals(reverse);
    }

    public static void main(String[] args) {
        String str = "race a car";
        System.out.println(isPalindrome(str));

    }
}

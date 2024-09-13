import java.util.Arrays;

public class HashDividedString {
    public static void main(String[] args) {
        String s = "ant";
        int k = 1;
        System.out.println(stringHash(s, k));
    }

    public static String stringHash(String s, int k) {
        int n = s.length();
        String[] substrings = new String[n / k];

        int index = 0;
        int len = n / (n / k);
        for (int i = 0; i < n; index++, i += len) {
            substrings[index] = s.substring(i, i + len);
        }

        System.out.println(Arrays.toString(substrings));

        StringBuilder sb = new StringBuilder();
        for (String string : substrings) {
            int curr = 0;
            for (char c : string.toCharArray()) {
                curr += c - 'a';
            }
            curr = curr % 26;
            sb.append((char) (curr + 'a'));
        }

        return sb.toString();
    }
}

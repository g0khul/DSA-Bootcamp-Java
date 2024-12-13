import java.util.*;

public class CountSubstringsWithKFrequencyCharactersI {
    public static void main(String[] args) {
        String s = "abacb";
        int k = 2;
        System.out.println(numberOfSubstrings(s, k));
    }

    public static int numberOfSubstrings(String s, int k) {
        int count = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            StringBuilder substring = new StringBuilder();
            for (int j = i; j < n; j++) {
                substring.append(s.charAt(j));
                if (substring.length() >= k && isSubstringValid(substring.toString(), k)) {
                    count++;
                }
            }
        }
        return count;
    }

    public static boolean isSubstringValid(String substring, int k) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : substring.toCharArray()) {
            if (map.containsKey(c)) {
                int value = map.get(c) + 1;
                if (value == k) {
                    return true;
                }
                map.put(c, value);
            } else {
                if (k == 1) {
                    return true;
                }
                map.put(c, 1);
            }
        }
        return false;
    }
}

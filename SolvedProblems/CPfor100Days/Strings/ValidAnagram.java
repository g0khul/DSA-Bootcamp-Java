package CPfor100Days.Strings;

import java.util.Map;
import java.util.TreeMap;

public class ValidAnagram {
    public static void main(String[] args) {
        String s = "ab";
        String t = "a";
        System.out.println(isAnagram(s, t));
    }

    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        // s = sort(s);
        // t = sort(t);

        // return s.equals(t);

        int[] frequency = new int[26];

        for (char c : s.toCharArray()) {
            frequency[c - 'a']++;
        }

        for (char c : t.toCharArray()) {
            if (frequency[c - 'a'] == 0) {
                return false;

            } else {
                frequency[c - 'a']--;
            }
        }

        return true;
    }

    private static String sort(String string) {
        TreeMap<Character, Integer> map = new TreeMap<>();

        for (int i = 0; i < string.length(); i++) {
            map.put(string.charAt(i), map.getOrDefault(string.charAt(i), 0) + 1);
        }

        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            char key = entry.getKey();
            int value = entry.getValue();
            while (value != 0) {
                sb.append(key);
                value--;
            }
        }

        return sb.toString();
    }
}

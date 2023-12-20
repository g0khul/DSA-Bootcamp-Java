// package HashTable;

import java.util.HashMap;

public class IsomorphicStrings {
    public static void main(String[] args) {
        String s = "badc";
        String t = "baba";
        System.out.println(isIsomorphic(s, t));
    }

    public static boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        HashMap<Character, Character> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char key = s.charAt(i);
            char value = t.charAt(i);

            if ((map.containsKey(key) && map.get(key) != value) || (!map.containsKey(key) && map.containsValue(value))) {
                return false;
            } else {
                map.put(key, value);
            }
        }

        return true;
    }
}

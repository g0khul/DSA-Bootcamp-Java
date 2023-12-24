// package HashTable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {
    public static void main(String[] args) {
        String[] strs = { "eat", "tea", "tan", "ate", "nat", "bat" };
        System.out.println(groupAnagrams(strs));
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();

        for (String string : strs) {
            int[] sort = new int[26];
            for (char c : string.toCharArray()) {
                sort[c - 'a']++;
            }

            StringBuilder key = new StringBuilder();
            for (int value : sort) {
                key.append(value);
                key.append('#');
            }

            String keyStr = key.toString();
            if (!map.containsKey(keyStr)) {
                map.put(keyStr, new ArrayList<>());
            }
            map.get(keyStr).add(string);
        }

        return new ArrayList<>(map.values());
    }
}

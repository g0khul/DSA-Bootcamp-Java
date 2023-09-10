package Recursion;

import java.util.HashSet;
import java.util.Set;

public class LongestSubStringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 1) {
            return 1;
        }

        int maxLength = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                String str = s.substring(i, j + 1);
                int length = str.length();
                if (isUnique(str) && maxLength < length) {
                    maxLength = length;
                }
            }
        }

        return maxLength;
    }

    private int getLength(String processed, String unprocessed, int maxLength, int index) {
        if (index == unprocessed.length()) {
            if (isUnique(processed) && maxLength < processed.length() && unprocessed.indexOf(processed) != -1) {
                maxLength = processed.length();
            }
            return maxLength;
        }

        getLength(unprocessed.substring(index), unprocessed.substring(index, index), maxLength, index + 1);
        

        return maxLength;
    }

    private boolean isUnique(String processed) {
        Set<Character> set = new HashSet<>();

        for (char c : processed.toCharArray()) {
            set.add(c);
        }

        return set.size() == processed.length();
    }

    public static void main(String[] args) {
        LongestSubStringWithoutRepeatingCharacters obj = new LongestSubStringWithoutRepeatingCharacters();
        System.out.println(obj.lengthOfLongestSubstring("bbbbb"));
    }
}

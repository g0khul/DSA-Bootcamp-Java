package CPfor100Days.SlidingWindow;

import java.util.HashSet;
import java.util.Set;

public class LongestSubStringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 1) {
            return 1;
        }

        // int maxLength = 0;
        // for (int i = 0; i < s.length(); i++) {
        // for (int j = i; j < s.length(); j++) {
        // String str = s.substring(i, j + 1);
        // int length = str.length();
        // if (isUnique(str) && maxLength < length) {
        // maxLength = length;
        // }
        // }
        // }

        // return maxLength;
        return helper(s);
    }

    private int helper(String s) {
        int start = 0;
        int end = 0;
        int maxLength = Integer.MIN_VALUE;

        String result = "";
        while (end < s.length()) {
            result = s.substring(start, end + 1);
            end = end + 1;

            if (!isUnique(result)) {
                start = start + 1;
            } else if (maxLength < result.length()) {
                System.out.println(result);
                maxLength = result.length();
            }
        }

        return maxLength;
    }

    private boolean isUnique(String processed) {
        boolean[] marker = new boolean[128];

        for (int i = 0; i < processed.length(); i++) {
            int val = processed.charAt(i);
            if(marker[val]){
                return false;
            }
            marker[val] = true;
        }
        
        return true;
    }

    // private int getLength(String processed, String unprocessed, int maxLength,
    // int index) {
    // if (index == unprocessed.length()) {
    // if (isUnique(processed) && maxLength < processed.length() &&
    // unprocessed.indexOf(processed) != -1) {
    // maxLength = processed.length();
    // }
    // return maxLength;
    // }

    // getLength(unprocessed.substring(index), unprocessed.substring(index, index),
    // maxLength, index + 1);

    // return maxLength;
    // }

    public static void main(String[] args) {
        LongestSubStringWithoutRepeatingCharacters obj = new LongestSubStringWithoutRepeatingCharacters();
        System.out.println(obj.lengthOfLongestSubstring("bcabcbb"));
    }
}

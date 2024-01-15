import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";

        System.out.println(minWindow(s, t));
    }

    public static String minWindow(String s, String t) {
        if (t.isEmpty()) {
            return "";
        }

        Map<Character, Integer> have = new HashMap<>();
        Map<Character, Integer> need = new HashMap<>();

        for (char c : t.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        int start = 0;
        int end = 0;
        int haveSize = 0;
        int needSize = need.size();

        int resultS = 0;
        int resultE = 0;
        int resultLength = Integer.MAX_VALUE;

        while (end < s.length()) {
            char c = s.charAt(end);
            have.put(c, have.getOrDefault(c, 0) + 1);

            if (need.containsKey(c) && have.get(c) == need.get(c)) {
                haveSize++;
            }

            while (haveSize == needSize) {
                if (resultLength > (end - start + 1)) {
                    resultS = start;
                    resultE = end;
                    resultLength = end - start + 1;
                }

                char st = s.charAt(start);
                have.put(st, have.get(st) - 1);

                if (need.containsKey(st) && have.get(st) < need.get(st)) {
                    haveSize--;
                }

                start++;
            }

            end++;
        }

        return (resultLength != Integer.MAX_VALUE) ? s.substring(resultS, resultE + 1) : "";
    }
}

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;

public class SubstringWithConcatenationOfAllWords {
    public static void main(String[] args) {
        String s = "wordgoodgoodgoodbestword";
        String words[] = { "word", "good", "best", "good" };

        System.out.println(findSubstring(s, words));
    }

    public static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();

        if (s.isEmpty() || words.length == 0) {
            return result;
        }

        Map<String, Integer> initialMap = new HashMap<>();
        int jump = words[0].length();
        int totalAnsLength = words.length * jump;

        for (String word : words) {
            initialMap.put(word, initialMap.getOrDefault(word, 0) + 1);
        }

        for (int start = 0; start <= s.length() - totalAnsLength; start++) {
            Map<String, Integer> map = new HashMap<>(initialMap);
            int index = start;

            while (index <= s.length() && index < start + totalAnsLength) {
                String str = s.substring(index, index + jump);

                if (!map.containsKey(str) || map.get(str) == 0) {
                    break;
                }

                map.put(str, map.get(str) - 1);
                index = index + jump;
            }

            if (index == start + totalAnsLength) {
                result.add(start);
            }
        }

        return result;
    }
}

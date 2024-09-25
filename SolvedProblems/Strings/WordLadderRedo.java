import java.util.ArrayList;
import java.util.Arrays;
import java.uWordLadderRedot;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class WordLadder {
    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = new ArrayList<>(Arrays.asList("hot", "dot", "dog", "lot", "log", "cog"));
        int ans = ladderLength(beginWord, endWord, wordList);
        System.out.println(ans);
    }

    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) {
            return 0;
        }

        if (wordSet.contains(beginWord)) {
            wordSet.remove(beginWord);
        }

        Set<Character> set = new HashSet<>();
        for (String string : wordSet) {
            for (char c : string.toCharArray()) {
                set.add(c);
            }
        }

        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        int ans = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            ans++;

            for (int i = 0; i < size; i++) {
                String removed = queue.poll();

                for (int j = 0; j < removed.length(); j++) {
                    char[] temp = removed.toCharArray();

                    for (char c : set) {
                        temp[j] = c;

                        String str = new String(temp);

                        if (wordSet.contains(str) && str.equals(endWord)) {
                            return ans + 1;
                        }

                        if (wordSet.contains(str)) {
                            queue.offer(str);
                            wordSet.remove(str);
                        }
                    }
                }
            }
        }

        return 0;
    }
}

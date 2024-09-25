import java.util.*;
import javafx.util.Pair;

public class WordLadderI {
    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = new ArrayList<>(Arrays.asList("hot", "dot", "dog", "lot", "log", "cog"));
        int ans = ladderLengthBFS(beginWord, endWord, wordList);
        System.out.println(ans);
    }

    public static int ladderLengthBFS(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>();
        for (String word : wordList) {
            set.add(word);
        }

        Queue<String[]> queue = new LinkedList<>();
        queue.offer(new String[] { beginWord, "1" });
        set.remove(beginWord);

        while (!queue.isEmpty()) {
            String[] pair = queue.poll();
            String word = pair[0];
            int length = Integer.parseInt(pair[1]);

            if (word.equals(endWord)) {
                return length;
            }

            for (int i = 0; i < word.length(); i++) {
                StringBuilder sb = new StringBuilder(word);
                for (char j = 'a'; j <= 'z'; j++) {
                    sb.setCharAt(i, j);
                    String sbString = sb.toString();
                    if (set.contains(sbString)) {
                        set.remove(sbString);
                        queue.offer(new String[] { sbString, length + 1 + "" });
                    }
                }
            }
        }

        return 0;
    }
}

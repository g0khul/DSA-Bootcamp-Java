import java.util.*;
import java.util.Arrays;
import java.util.Map;
import java.util.HashSet;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class WordLadderII {
    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = new ArrayList<>(Arrays.asList("hot", "dot", "dog", "lot", "log", "cog"));
        // List<List<String>> ans = findLadders(beginWord, endWord, wordList);
        // System.out.println(ans);
        System.out.println(findLaddersOptimized(beginWord, endWord, wordList));
    }

    public static List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>();
        for (String string : wordList) {
            set.add(string);
        }

        List<List<String>> result = new ArrayList<>();

        Queue<List<String>> queue = new LinkedList<>();
        queue.offer(new ArrayList<>(Arrays.asList(beginWord)));

        List<String> usedOnLevel = new ArrayList<>();
        usedOnLevel.add(beginWord);

        int level = 0;
        while (!queue.isEmpty()) {
            List<String> currPath = queue.poll();

            if (currPath.size() > level) {
                level++;
                for (String string : usedOnLevel) {
                    set.remove(string);
                }
            }

            String lastWord = currPath.get(currPath.size() - 1);
            if (lastWord.equals(endWord)) {
                if (result.isEmpty()) {
                    result.add(currPath);
                } else if (result.get(0).size() == currPath.size()) {
                    result.add(currPath);
                }
            }

            for (int i = 0; i < lastWord.length(); i++) {
                StringBuilder lastWordSb = new StringBuilder(lastWord);
                for (char j = 'a'; j <= 'z'; j++) {
                    lastWordSb.setCharAt(i, j);
                    String newWord = lastWordSb.toString();
                    if (set.contains(newWord)) {
                        List<String> temp = new ArrayList<>(currPath);
                        temp.add(newWord);
                        queue.offer(temp);
                        usedOnLevel.add(newWord);
                    }
                }
            }
        }

        return result;
    }

    public static List<List<String>> findLaddersOptimized(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>();
        for (String string : wordList) {
            set.add(string);
        }

        Map<String, Integer> map = new HashMap<>();

        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        set.remove(beginWord);
        map.put(beginWord, 1);

        while (!queue.isEmpty()) {
            String word = queue.poll();
            int level = map.get(word);

            if (word.equals(endWord)) {
                break;
            }

            for (int i = 0; i < word.length(); i++) {
                StringBuilder wordSb = new StringBuilder(word);
                for (char j = 'a'; j <= 'z'; j++) {
                    wordSb.setCharAt(i, j);
                    String newWord = wordSb.toString();
                    if (set.contains(newWord)) {
                        queue.offer(newWord);
                        set.remove(newWord);
                        map.put(newWord, level + 1);
                    }
                }
            }
        }

        List<List<String>> answer = new ArrayList<>();
        if (map.containsKey(endWord)) {
            List<String> sequence = new ArrayList<>();
            sequence.add(endWord);
            dfs(endWord, sequence, beginWord, map, answer);
        }

        return answer;
    }

    public static void dfs(String word, List<String> sequence, String beginWord,
            Map<String, Integer> map, List<List<String>> answer) {
        if (word.equals(beginWord)) {
            List<String> sequenceRev = new ArrayList<>(sequence);
            Collections.reverse(sequenceRev);
            answer.add(sequenceRev);
        }

        int level = map.get(word);

        for (int i = 0; i < word.length(); i++) {
            StringBuilder wordSb = new StringBuilder(word);
            for (char j = 'a'; j <= 'z'; j++) {
                wordSb.setCharAt(i, j);
                String newWord = wordSb.toString();
                if (map.containsKey(newWord) && map.get(newWord) + 1 == level) {
                    sequence.add(newWord);
                    dfs(newWord, sequence, beginWord, map, answer);
                    sequence.remove(sequence.size() - 1);
                }
            }
        }
    }
}

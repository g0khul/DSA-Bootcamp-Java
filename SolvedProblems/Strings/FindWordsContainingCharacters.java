import java.util.ArrayList;
import java.util.List;

public class FindWordsContainingCharacters {
    public static void main(String[] args) {
        String[] words = { "abc", "bcd", "aaaa", "cbc" };
        char x = 'a';
        System.out.println(findWordsContaining(words, x));
    }

    public static List<Integer> findWordsContaining(String[] words, char x) {
        List<Integer> indexes = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            if (words[i].contains(x + "")) {

                indexes.add(i);
            }
        }
        return indexes;
    }
}

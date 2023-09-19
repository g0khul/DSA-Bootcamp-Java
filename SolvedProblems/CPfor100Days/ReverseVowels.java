import java.util.ArrayList;
import java.util.List;

public class ReverseVowels {
    public static String reverseVowels(String s) {
        List<Integer> vowelIndex = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'a' || s.charAt(i) == 'e' || s.charAt(i) == 'i'
                    || s.charAt(i) == 'o' || s.charAt(i) == 'u'
                    || s.charAt(i) == 'A' || s.charAt(i) == 'E' || s.charAt(i) == 'I'
                    || s.charAt(i) == 'O' || s.charAt(i) == 'U') {
                vowelIndex.add(i);
            }
        }

        StringBuilder result = new StringBuilder(s);
        for(int i = 0; i < vowelIndex.size() / 2; i++){
            char temp = s.charAt(vowelIndex.size() - 1 - i);
            

        }

        return result.toString();
    }
}

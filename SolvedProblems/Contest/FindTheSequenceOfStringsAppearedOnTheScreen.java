import java.util.*;

public class FindTheSequenceOfStringsAppearedOnTheScreen {
    public static void main(String[] args) {
        String target = "abc";
        System.out.println(stringSequence(target));
    }

    public static List<String> stringSequence(String target) {
        List<String> result = new ArrayList<>();

        char start = target.charAt(0);
        for (char i = 'a'; i <= start; i++) {
            result.add(i + "");
        }

        for (int i = 1; i < target.length(); i++) {
            for (char j = 'a'; j <= target.charAt(i); j++) {
                String last = result.get(result.size() - 1);
                if (last.length() == i) {
                    result.add(last + j);
                } else {
                    StringBuilder sb = new StringBuilder(last);
                    sb.setCharAt(sb.length() - 1, j);
                    result.add(sb.toString());
                }
            }
        }

        return result;
    }
}

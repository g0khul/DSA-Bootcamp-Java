
public class ReverseWordsInAStringIII {
    public static void main(String[] args) {
        System.out.println(reverseWords("Let's take LeetCode contest"));
    }

    public static String reverseWords(String s) {
        StringBuilder result = new StringBuilder();
        String[] str = s.split(" ");

        for (int i = 0; i < str.length; i++) {
            StringBuilder rev = new StringBuilder(str[i]);
            if (i == 0) {
                result.append(rev.reverse());
            } else {
                result.append(" " + rev.reverse());
            }
        }

        return result.toString();
    }
}

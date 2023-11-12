package CPfor100Days.Strings;

public class StringEquvilent {
    public static boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        String s1 = String.join("", word1);
        String s2 = String.join("", word2);

        return (s1.equals(s2)) ? true : false;
    }

    public static void main(String[] args) {
        String[] word1 = { "ab", "c" };
        String[] word2 = { "a", "bc" };

        System.out.println(arrayStringsAreEqual(word1, word2));
    }
}

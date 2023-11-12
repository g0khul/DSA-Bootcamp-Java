public class NumberOfStringsThatAppearAsSubstringsInWord {
    public static void main(String[] args) {
        String[] patterns = { "a", "abc", "bc", "d" };
        String word = "abc";
        System.out.println(numOfStrings(patterns, word));

        hasSubString("a", word);
    }

    public static int numOfStrings(String[] patterns, String word) {
        int count = 0;
        // for (String unprocessed : patterns) {
        // if (hasSubString(unprocessed, word)) {
        // count++;
        // }
        // }

        for (int i = 0; i < patterns.length; i++) {
            if (word.contains(patterns[i])) {
                count++;
            }
        }

        // for (int i = 0; i < patterns.length; i++) {
        // if (hasSubString(patterns[i], word)) {
        // count++;
        // }
        // }

        return count;
    }

    private static boolean hasSubString(String unprocessed, String word) {
        for (int i = 0; i < word.length(); i++) {
            for (int j = i + 1; j <= word.length(); j++) {
                if (word.substring(i, j).equals(unprocessed)) {
                    return true;
                }
            }
        }
        return false;
    }
}

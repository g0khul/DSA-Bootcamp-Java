package CPfor100Days.Recursion;

public class PermutationOfString {
    private static void getPermutation(String string) {
        helper("", string);
    }

    private static void helper(String processed, String unprocessed) {
        if (unprocessed.isEmpty()) {
            System.out.println(processed);
            return;
        }

        for (int i = 0; i < processed.length() + 1; i++) {
            helper(processed.substring(0, i) + unprocessed.charAt(0) + processed.substring(i),
                    unprocessed.substring(1));
        }
    }

    public static void main(String[] args) {
        getPermutation("abc");
    }
}

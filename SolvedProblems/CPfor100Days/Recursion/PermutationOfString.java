package CPfor100Days.Recursion;

import java.util.ArrayList;
import java.util.List;

public class PermutationOfString {
    private static List<String> getPermutation(String string) {
        return helper("", string);
    }

    public static List<String> helper(String processed, String unprocessed) {
        if (unprocessed.isEmpty()) {
            List<String> result = new ArrayList<>();
            result.add(processed);
            return result;
        }

        List<String> result = new ArrayList<>();

        for (int i = 0; i < processed.length() + 1; i++) {
            String leftPart = processed.substring(0, i);
            String righPart = processed.substring(i);
            char ch = unprocessed.charAt(0);
            String newProcessed = leftPart + ch + righPart;
            String newUnprocessed = unprocessed.substring(1);
            result.addAll(helper(newProcessed, newUnprocessed));
        }

        return result;
    }

    // private static void helper(String processed, String unprocessed) {
    // if (unprocessed.isEmpty()) {
    // System.out.println(processed);
    // return;
    // }

    // for (int i = 0; i < processed.length() + 1; i++) {
    // helper(processed.substring(0, i) + unprocessed.charAt(0) +
    // processed.substring(i),
    // unprocessed.substring(1));
    // }
    // }

    public static void main(String[] args) {
        System.out.println(getPermutation("abc"));
    }
}

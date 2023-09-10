package SolvedProblems.Recursion.Redo;

import java.util.ArrayList;


public class SubsequenceOfString {
    public static void main(String[] args) {
        generateSubsequence("", "abc");
        System.out.println(returnSubsequence("", "abc"));
    }

    private static void generateSubsequence(String processed, String unprocessed) {
        if (unprocessed.isEmpty()) {
            System.out.println(processed);
            return;
        }

        // Take it
        generateSubsequence(processed + unprocessed.charAt(0), unprocessed.substring(1));

        // Leave it
        generateSubsequence(processed, unprocessed.substring(1));
    }

    private static ArrayList<String> returnSubsequence(String processed, String unprocessed) {
        if (unprocessed.isEmpty()) {
            // System.out.println(processed);
            ArrayList<String> result = new ArrayList<>();
            result.add(processed);
            return result;
        }

        ArrayList<String> result = new ArrayList<>();
        // Take it
        result.addAll(returnSubsequence(processed + unprocessed.charAt(0), unprocessed.substring(1)));

        // Leave it
        result.addAll(returnSubsequence(processed, unprocessed.substring(1)));

        return result;
    }
}

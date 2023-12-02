package CPfor100Days.Recursion;

import java.util.HashSet;
import java.util.Set;

public class LetterTilePossibilities {
    public static int numTilePossibilities(String tiles) {
        Set<String> result = new HashSet<>();
        
        // Bruteforce approach
        getCombination("", tiles, result);

        System.out.println(result);
        return result.size();
    }

    private static void getCombination(String processed, String unprocessed, Set<String> result) {
        if (unprocessed.isEmpty()) {
            if (!processed.isEmpty()) {
                findPermutation("", processed, result);
            }
            return;
        }

        getCombination(processed + unprocessed.charAt(0), unprocessed.substring(1), result);

        getCombination(processed, unprocessed.substring(1), result);
    }

    private static void findPermutation(String processed, String unprocessed, Set<String> result) {
        if (unprocessed.isEmpty()) {
            result.add(processed);
            return;
        }

        for (int i = 0; i < processed.length() + 1; i++) {
            findPermutation(processed.substring(0, i) + unprocessed.charAt(0) + processed.substring(i),
                    unprocessed.substring(1), result);
        }
    }

    public static void main(String[] args) {
        System.out.println(numTilePossibilities("AAB"));

    }
}

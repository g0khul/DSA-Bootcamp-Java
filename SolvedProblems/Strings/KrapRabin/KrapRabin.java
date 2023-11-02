package SolvedProblems.Strings.KrapRabin;

public class KrapRabin {
    private double PRIME = 10501;

    private double calculateHash(String text) {
        double hash = 0;
        for (int i = 0; i < text.length(); i++) {
            hash += text.charAt(i) * Math.pow(PRIME, i);
        }
        return hash;
    }

    private double updateHash(double preHash, char rmChar, char addChar, int patternLength) {
        double newHash = (preHash - rmChar) / PRIME;
        newHash += addChar * Math.pow(PRIME, patternLength - 1);
        return newHash;
    }

    public void search(String text, String pattern) {
        if (text.length() < pattern.length()) {
            System.out.println("Pattern not found");
            return;
        }

        double patternHash = calculateHash(pattern);
        double textHash = calculateHash(text.substring(0, pattern.length()));

        for (int i = 0; i <= text.length() - pattern.length(); i++) {
            if (textHash == patternHash) {
                if (text.substring(i, i + pattern.length()).equals(pattern)) {
                    System.out.println("Pattern found at index : " + i);
                    return;
                }
            }

            if (i < text.length() - pattern.length()) {
                textHash = updateHash(textHash, text.charAt(i), text.charAt(i + pattern.length()), pattern.length());
            }
        }

        System.out.println("Pattern not found");
    }

}

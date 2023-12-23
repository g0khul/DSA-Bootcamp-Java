// package Strings;

import java.util.ArrayList;
import java.util.List;

public class TextJustification {
    public static void main(String[] args) {
        String[] words = { "This", "is", "an", "example", "of", "text", "justification." };
        int maxWidth = 16;
        List<String> result = fullJustify(words, maxWidth);

        for (String string : result) {
            System.out.println("---" + string + "---");
        }
    }

    public static List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();

        int start = 0;

        while (start < words.length) {
            int end = start;
            int lineLength = 0;

            while (end < words.length && lineLength + words[end].length() + (end - start) <= maxWidth) {
                lineLength = lineLength + words[end].length();
                end++;
            }

            StringBuilder line = new StringBuilder(words[start]);
            int spaces = maxWidth - lineLength;

            if (end == words.length || (end - start) == 1) {
                for (int i = start + 1; i < end; i++) {
                    line.append(" ").append(words[i]);
                }

                while (line.length() < maxWidth) {
                    line.append(" ");
                }
            } else {
                int spacesInBetween = spaces / (end - start - 1);
                int extraSpacesInBetween = spaces % (end - start - 1);

                StringBuilder space = new StringBuilder();
                for (int j = 0; j < spacesInBetween; j++) {
                    space.append(" ");
                }

                for (int i = start + 1; i < end; i++) {
                    line.append(space);

                    if (extraSpacesInBetween > 0) {
                        line.append(" ");
                        extraSpacesInBetween--;
                    }

                    line.append(words[i]);
                }
            }

            result.add(line.toString());
            start = end;
        }

        return result;
    }
}

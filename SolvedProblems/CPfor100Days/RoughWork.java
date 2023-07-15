package SolvedProblems.CPfor100Days;

public class RoughWork {
    public static String doesCharExist(char letter, String word) {
        int i = 0;
        boolean flag = false;
        while (i < word.length()) {
            if (letter == word.charAt(i)) {
                flag = true;
                break;
            }
            i++;
        }

        if (flag) {
            String newWord = "";
            for (int j = 0; j < word.length(); j++) {
                if (j != i) {
                    newWord += word.charAt(j);
                }
            }
            return newWord;
        }

        return word;
    }

    public static void main(String[] args) {
        String word = "a";
        char letter = 'a';

        boolean[][] marker = new boolean[3][3];

        for(boolean[] arr : marker){
            for(boolean bool : arr){
                System.out.print(bool + " ");
            }
            System.out.println();
        }

        System.out.println(doesCharExist(letter, word));
    }
}

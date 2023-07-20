package SolvedProblems.CPfor100Days;

public class RoughWork {

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

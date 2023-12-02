package Recursion.Redo;

public class SkipAChar {
    public static void main(String[] args) {
        String str = "baccab";

        System.out.println(skipAChar(str));
        System.out.println(skipAWord("bcapplecba"));    // Output : bccba
    }

    private static String skipAChar(String str) {
        if (str.isEmpty()) {
            return "";
        }

        if (str.charAt(0) != 'a') {
            return str.charAt(0) + skipAChar(str.substring(1));
        }
        return "" + skipAChar(str.substring(1));
    }

    // here i'm trying to skip a word apple
    private static String skipAWord(String str){
        if(str.isEmpty()){
            return "";
        }

        if(str.startsWith("apple")){
            return "" + skipAWord(str.substring(5));
        }

        return str.charAt(0) + skipAWord(str.substring(1));
    }

    
}

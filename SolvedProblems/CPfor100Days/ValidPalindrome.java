package SolvedProblems.CPfor100Days;

public class ValidPalindrome {
    public static boolean isPalindrome(String s) {
        String str = "";
        for (char c : s.toCharArray()) {
            if(( (int) c >= 65 && (int) c <= 90) || ( (int) c >= 97 && (int) c <= 122)){
                str += c;
            }
        }

        System.out.println(str.toLowerCase());

        if(str.isEmpty()){
            return false;
        }

        return isValid(str.toLowerCase());
    }

    public static boolean isValid(String str){

        for(int i = 0; i < str.length() / 2; i++){
            if(str.charAt(i) != str.charAt(str.length() - 1 - i)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String str = "A man, a plan, a canal: Panama";
        System.out.println(isPalindrome(str));
    }
}

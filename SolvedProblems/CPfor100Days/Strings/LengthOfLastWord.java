package CPfor100Days.Strings;

public class LengthOfLastWord {
    public static void main(String[] args) {
        String s = "Hello world  ";
        System.out.println(lengthOfLastWord(s));
    }

    public static int lengthOfLastWord(String s) {
        String[] str = s.split(" ");
        return str[str.length - 1].length();
    }
}

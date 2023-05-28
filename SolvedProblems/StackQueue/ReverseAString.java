package Problems;
import java.util.*;

public class ReverseAString {
    public static void main(String[] args) {
        String str = "ABCDEFGHIJK";
        char[] chars = str.toCharArray();

        Stack<Character> value = new Stack<>();
        for(char c : chars){
            value.push(c);
        }
        for(int i =0; i<str.length();i++){
            System.out.print(value.pop());
        }

    }
}

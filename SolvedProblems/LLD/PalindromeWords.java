package LLD;

import java.util.Scanner;

// Remove words that are palindrome 
public class PalindromeWords {
    public static String reverseString(String input) {
        StringBuilder sb = new StringBuilder(input);
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine().toLowerCase();

        String result = "";
        for (String word : str.split(" ")) {
            if (!word.equals(reverseString(word))) {
                result += word + " ";
            }
        }

        System.out.println(result);
        sc.close();
    }
}

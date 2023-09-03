package SolvedProblems.Random;

import java.util.*;

public class LookAndSay {

    public static String look(String val) {
        StringBuilder result = new StringBuilder();

        char repeat = val.charAt(0);
        val = val.substring(1) + " ";
        int times = 1;
        for (char actual : val.toCharArray()) {
            if (actual != repeat) {
                result.append(times + "" + repeat);
                times = 1;
                repeat = actual;
            } else {
                times += 1;
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        String val = "1";
        for (int i = 1; i <= num; i++) {
            System.out.println(val);
            val = look(val);
        }
        sc.close();
    }
}
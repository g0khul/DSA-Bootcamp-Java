package Strings;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Random;

public class LearnStringBuilder {
    public static void main(String[] args) {
        StringBuilder sb1 = new StringBuilder();
        sb1.append("Hello");
        sb1.append(" world");
        sb1.reverse();
        System.out.println(sb1);

        StringBuilder sb2 = new StringBuilder("Hi Hello");
        sb2.append(" world");
        sb2.insert(2, "HI");
        System.out.println(sb2);
        sb2.replace(2, 8, "NEW STRING REPLACED"); // Here 2 is inclusive and 8 is exclusive
        System.out.println(sb2);

        StringBuilder sb3 = new StringBuilder(30);
        System.out.println(sb3.capacity());

        // Generate a random number
        Random random = new Random();
        System.out.println(random.nextInt(10)); // 10 is the upper bound (exclusive)

        // Remove white spaces
        String str = "Hi hello hl jkbds sdg sd dv dv ";
        str = str.replaceAll(" ", "");
        System.out.println(str);

        // Split
        String str1 = "Hi hello hl jkbds sdg sd dv dv ";
        String[] arr = str1.split(" ");
        System.out.println(Arrays.toString(arr));

        // Rounding off
        DecimalFormat df = new DecimalFormat("00.000");
        System.out.println(df.format(7.4));

    }
}

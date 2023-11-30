package CPfor100Days.Strings;

import java.util.Map;
import java.util.TreeMap;

public class IntegerToRoman {
    public static void main(String[] args) {
        int num = 1994;
        System.out.println(intToRoman(num));
    }

    public static String intToRoman(int num) {
        TreeMap<Integer, String> map = new TreeMap<>();

        map.put(-4, "IV");
        map.put(-5, "V");
        map.put(-9, "IX");
        map.put(-10, "X");
        map.put(-40, "XL");
        map.put(-50, "L");
        map.put(-90, "XC");
        map.put(-100, "C");
        map.put(-400, "CD");
        map.put(-500, "D");
        map.put(-900, "CM");
        map.put(-1000, "M");

        StringBuilder result = new StringBuilder();

        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            int key = Math.abs(entry.getKey());
            if (num / key > 0) {
                String value = entry.getValue();
                int times = num / key;
                for (int i = 0; i < times; i++) {
                    result.append(value);
                }
                num = num % key;
            }
        }

        for (int i = 0; i < num; i++) {
            result.append("I");
        }

        return result.toString();
    }
}

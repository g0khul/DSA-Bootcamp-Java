// package HashTable;

import java.util.HashMap;

public class WordPattern {
    public static void main(String[] args) {
        String pattern = "e";
        String s = "eukera";
        System.out.println(wordPattern(pattern, s));
    }

    public static boolean wordPattern(String pattern, String s) {
        HashMap<String, Integer> map = new HashMap<>();
        int ptr = 0;
        int counter = 1;
        for (int i = 0; i < pattern.length(); i++) {
            String string = pattern.charAt(i) + "";
            if (map.containsKey(string)) {
                ptr = ptr * 10 + map.get(string);
            } else {
                map.put(string, counter);
                ptr = ptr * 10 + counter;
                counter++;
            }
        }

        map.clear();
        int str = 0;
        counter = 1;
        for (String string : s.split(" ")) {
            if (map.containsKey(string)) {
                str = str * 10 + map.get(string);
            } else {
                map.put(string, counter);
                str = str * 10 + counter;
                counter++;
            }
        }

        System.out.println(ptr + " : " + str);

        return ptr == str;
    }
}

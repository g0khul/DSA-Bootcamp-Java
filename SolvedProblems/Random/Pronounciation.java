import java.util.*;

public class Pronounciation {

    public static boolean easyPronounciation(String str) {

        // 4 or more consecutive consonants will make the word hard to read

        int count = 0;

        if (str.length() < 4)
            return true;
        else {
            for (int i = 1; i < str.length(); i++) {
                count = 0;
                if (str.length() - i - 1 >= 4) {
                    for (int j = i - 1; j <= i + 3; j++) {
                        if (str.charAt(j) != 'a' || str.charAt(j) != 'e' ||
                                str.charAt(j) != 'i' || str.charAt(j) != 'o' ||
                                str.charAt(j) != 'u')
                            count++;
                    }
                    if (count >= 4) {
                        return false;
                    }
                } else
                    return true;
            }

            return true;
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        /*
         * Other inputs that can be tested
         * 
         * schtschurowskia - hard word so false
         * cry - easy word so true
         * apple - easy word so true
         * 
         * aabbb - easy word so true
         * aabbbba - hard word so false
         * 
         */

        String str = "aabbbb";

        // Print true if the string is easy to read or print false
        System.out.println(easyPronounciation(str));

        sc.close();
    }
}

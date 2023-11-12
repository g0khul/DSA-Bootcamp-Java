package CPfor100Days.Strings;

public class DecryptString {
    public static String freqAlphabets(String s) {
        String result = "";

        for (int i = s.length() - 1; i >= 0; i--) {
            int val = 0;
            if (s.charAt(i) == '#') {
                val = Integer.parseInt("" + s.charAt(i - 2) + s.charAt(i - 1));
                i -= 2;
            } else {
                val = Integer.parseInt("" + s.charAt(i));
            }
            result = (char) (val + 96) + result;
        }

        return result;
    }

    public static void main(String[] args) {
        String str = "10#11#12";
        System.out.println(freqAlphabets(str));
    }
}
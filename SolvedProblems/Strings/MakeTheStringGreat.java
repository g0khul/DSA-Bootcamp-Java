public class MakeTheStringGreat {
    public static void main(String[] args) {
        String s = "kkdsFuqUfSDKK";
        System.out.println(makeGood(s));
    }

    public static String makeGood(String s) {
        StringBuilder sb = new StringBuilder(s);

        int i = 0;
        while (!sb.isEmpty() && i < sb.length() - 1) {
            if (sb.charAt(i) != sb.charAt(i + 1) && (Character.toUpperCase(sb.charAt(i)) == sb.charAt(i + 1)
                    || sb.charAt(i) == Character.toUpperCase(sb.charAt(i + 1)))) {
                sb.deleteCharAt(i);
                sb.deleteCharAt(i);
                if (i - 1 < 0) {
                    i = 0;
                } else {
                    i--;
                }
            } else {
                i++;
            }
        }

        return sb.toString();
    }
}

public class StringToInteger {
    public static void main(String[] args) {
        String s = "-91283472332";
        System.out.println(myAtoi(s));
    }

    public static int myAtoi(String s) {
        long num = 0;
        boolean isNegative = false;
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                num = (num * 10) + Integer.parseInt(c + "");
            } else if (c == '-' && !isNegative) {
                isNegative = !isNegative;
            } else if (c == ' ') {
                continue;
            } else {
                break;
            }

            if (num > Integer.MAX_VALUE) {
                return isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
        }
        return isNegative ? (int) -num : (int) num;
    }
}

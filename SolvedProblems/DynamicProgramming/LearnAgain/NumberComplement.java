public class NumberComplement {
    public static void main(String[] args) {
        int num = 5;
        System.out.println(findComplement(num));
    }

    public static int findComplement(int num) {
        int rem = 0;
        int quotient = num;
        StringBuilder sb = new StringBuilder();
        while (quotient != 0) {
            rem = quotient % 2;
            quotient = quotient / 2;
            sb.append(rem);
        }

        for (int i = 0; i < sb.length(); i++) {
            sb.setCharAt(i, sb.charAt(i) == '0' ? '1' : '0');
        }

        int n = 1;
        int res = 0;
        for (int i = 0; i < sb.length(); i++) {
            res += (sb.charAt(i) - '0') * n;
            n *= 2;
        }

        return res;
    }
}

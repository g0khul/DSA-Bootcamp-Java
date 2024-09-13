public class BinaryNumberWithAlternatingBits {
    public static void main(String[] args) {
        int n = 21;
        System.out.println(hasAlternatingBits(n));
    }

    public static boolean hasAlternatingBits(int n) {
        boolean first = true;
        int searchBit = 0;

        while (n != 0) {
            int remainder = n % 2;
            int quotient = n / 2;

            if (first) {
                searchBit = remainder == 1 ? 0 : 1;
                first = false;
            } else if (searchBit != remainder) {
                return false;
            }

            searchBit = remainder == 1 ? 0 : 1;
            n = quotient;
        }

        return true;
    }
}

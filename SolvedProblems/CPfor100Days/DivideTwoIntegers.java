package CPfor100Days;

public class DivideTwoIntegers {
    public static void main(String[] args) {
        int dividend = -15;
        int divisor = -3;
        System.out.println(divide(dividend, divisor));
    }

    public static int divide(int dividend, int divisor) {
        if (dividend > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }

        if (dividend < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }

        if (dividend == Integer.MIN_VALUE) {
            if (divisor == 1) {
                return Integer.MIN_VALUE;
            }
            if (divisor == -1) {
                return Integer.MAX_VALUE;
            }
        }

        boolean negative = ((dividend < 0) == (divisor < 0)) ? false : true;
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);

        int result = 0;
        while (dividend - divisor >= 0) {
            int count = 0;
            while (dividend - (divisor << 1 << count) >= 0) {
                count++;
            }
            dividend -= divisor << count;
            result += 1 << count;
        }

        return (negative) ? -result : result;
    }
}

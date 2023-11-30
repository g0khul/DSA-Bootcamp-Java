package CPfor100Days;

public class ReverseInteger {
    public static void main(String[] args) {
        int x = Integer.MIN_VALUE;
        System.out.println(reverse(x));
    }

    public static int reverse(int x) {
        if (x == Integer.MIN_VALUE) {
            return 0;
        }

        int sign = (x < 0) ? -1 : 1;
        x = Math.abs(x);

        int reverse = 0;
        while (x > 9) {
            int rem = x % 10;
            reverse = reverse * 10 + rem;
            x = x / 10;
        }

        int max = Integer.MAX_VALUE / 10;
        if (reverse > max || (reverse == max && x > 7)) {
            return 0;
        }

        int min = Integer.MIN_VALUE / 10;
        if (reverse < min || (reverse == min && x < 8)) {
            return 0;
        }

        return (reverse * 10 + x) * sign;
    }
}

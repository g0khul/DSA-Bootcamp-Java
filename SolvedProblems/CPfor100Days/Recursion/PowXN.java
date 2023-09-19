package Recursion;

public class PowXN {
    public static double myPow(double x, int n) {
        if (x == 0) {
            return 0;
        }

        return (n < 0) ? 1 / helper(x, n * -1) : helper(x, n);
    }

    private static double helper(double x, int n) {
        if (n == 0) {
            return 1;
        }

        if (x == 0) {
            return 0;
        }

        double result = helper(x, n / 2);
        return (n % 2 == 0) ? result * result : result * result * x;
    }

    // public static double myPow(double x, int n) {
    // if (n == 0) {
    // return 1;
    // }

    // return (n < 0) ? 1 / helper(x, n * -1) : helper(x, n);
    // }

    // private static double helper(double x, int n) {
    // if (n == 1) {
    // return x;
    // }

    // return x * helper(x, n - 1);
    // }

    public static void main(String[] args) {
        System.out.println(myPow(2.00000, -2147483648));
    }
}

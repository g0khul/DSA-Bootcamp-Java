package Recursion;

public class CountingGoodNumbers {
    public static int countGoodNumbers(long n) {
        if (n == 0) {
            return 0;
        }

        if (n == 1) {
            return 5;
        }

        return helper(n, "", new int[] { 0, 2, 4, 6, 8 }, new int[] { 2, 3, 5, 7, 9 });
    }

    private static int helper(long n, String processed, int[] even, int[] prime) {
        if (n == 0) {
            System.out.println(processed);
            return 1;
        }

        if (n < 0) {
            return 0;
        }

        int count = 0;
        for (int e = 0, p = 0; !(e >= even.length && p >= prime.length);) {
            if (e < even.length) {
                count += helper(n - 1, processed + even[e], even, prime);
                e++;
            }

            if (p < prime.length) {
                count += helper(n - 2, processed + even[e - 1] + prime[p], even, prime);
                p++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println("Answer : " + countGoodNumbers(4));

        int a = 10;
        a = 20;
        a = 30;
    }
}

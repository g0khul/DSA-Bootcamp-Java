package CPfor100Days.Recursion;

// https://www.geeksforgeeks.org/print-all-n-digit-strictly-increasing-numbers/

public class NDigitNumbersWithDigitIncreasingOrder {
    public static void increasingNumbers(int n){
        helper(n, "", 1);
    }

    private static void helper(int n, String string, int index) {
        if(n == 0){
            System.out.println(string);
            return;
        }

        for (int i = index; i <= 9; i++) {
            helper(n - 1, string + i, i + 1);
        }
    }

    public static void main(String[] args) {
        increasingNumbers(3);
    }
}

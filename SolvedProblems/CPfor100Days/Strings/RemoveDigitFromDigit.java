package Strings;
// package SolvedProblems.CPfor100Days;

public class RemoveDigitFromDigit {
    public static String removeDigit(String number, char digit) {
        if (number.length() == 0) {
            return "";
        }

        long max = Integer.MIN_VALUE;
        char[] arr = number.toCharArray();
        for (int i = 0; i < number.length(); i++) {
            if (arr[i] == digit) {
                max = findMax(arr, digit, max, i);
            }
        }

        return String.valueOf(max);
    }

    private static long findMax(char[] arr, char digit, long max, int index) {
        int newNum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i != index) {
                newNum = newNum * 10 + (int) (arr[i]) - 48;
            }
        }
        if (max < newNum) {
            max = newNum;
        }
        return max;
    }

    public static void main(String[] args) {
        String number = "26468";
        char digit = '6';
        System.out.println(removeDigit(number, digit));
    }
}

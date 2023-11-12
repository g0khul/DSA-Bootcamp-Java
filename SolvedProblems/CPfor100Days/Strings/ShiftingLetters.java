package CPfor100Days.Strings;

// https://leetcode.com/problems/shifting-letters

public class ShiftingLetters {
    public static String shiftingLetters(String s, int[] shifts) {
        int n = s.length();
        int[] prefixSum = new int[n];

        prefixSum[n - 1] = shifts[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            prefixSum[i] = (prefixSum[i + 1] + shifts[i]) % 26;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int shift = (s.charAt(i) - 'a' + prefixSum[i]) % 26;
            char shiftedChar = (char) ('a' + shift);
            sb.append(shiftedChar);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "abc";
        int[] shifts = {3, 5, 9};

        String result = shiftingLetters(s, shifts);
        System.out.println(result);
    }
}

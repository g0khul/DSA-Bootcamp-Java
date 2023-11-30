package CPfor100Days.Strings;

public class NumberOf1Bits {
    public static void main(String[] args) {
        int n = 11;
        System.out.println(hammingWeight(n));
    }

    public static int hammingWeight(int n) {
        return (n == 0) ? 0 : 1 + hammingWeight(n & (n - 1));
    }
}

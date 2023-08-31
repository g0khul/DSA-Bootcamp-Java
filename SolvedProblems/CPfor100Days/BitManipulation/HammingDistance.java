package BitManipulation;

public class HammingDistance {
    public static int hammingDistance(int x, int y) {
        int count = 0;
        for (int i = 1, j = 0; j < Integer.bitCount(x ^ y); i <<= 1) {
            if (((x ^ y) & i) != 0) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        hammingDistance(4, 1);
    }
}

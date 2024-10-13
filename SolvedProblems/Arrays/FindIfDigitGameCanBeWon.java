public class FindIfDigitGameCanBeWon {
    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4, 10 };
        System.out.println(canAliceWin(nums));
    }

    public static boolean canAliceWin(int[] nums) {
        int singleDigitSum = 0;
        int doubleDigitSum = 0;

        for (int n : nums) {
            if (n >= 0 && n < 10) {
                singleDigitSum += n;
            } else {
                doubleDigitSum += n;
            }
        }

        return singleDigitSum > doubleDigitSum || doubleDigitSum > singleDigitSum;
    }
}

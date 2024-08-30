public class FindTheMaximumAchievableNumber {
    public static void main(String[] args) {
        int num = 3;
        int t = 2;
        System.out.println(theMaximumAchievableX(num, t));
    }

    public static int theMaximumAchievableX(int num, int t) {
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < t; i++) {
            if (max < num + 2) {
                max = num + 2;
                num = num + 2;
            } else if (max < num - 2) {
                max = num - 2;
                num = num - 2;
            }
        }

        return max;
    }
}

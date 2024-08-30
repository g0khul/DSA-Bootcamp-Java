public class CountAlmostEqualPairsI {
    public static void main(String[] args) {
        int[] nums = { 1, 1, 1, 1, 1 };
        // 5, 12, 8, 5, 5, 1, 20, 3, 10, 10, 5, 5, 5, 5, 1
        // 8, 12, 5, 5, 14, 3, 12, 3, 3, 6, 8, 20, 14, 3, 8
        System.out.println(countPairs(nums));
    }

    public static int countPairs(int[] nums) {
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (canBeAlmostEqual(nums[i], nums[j])) {
                    count++;
                }
            }
        }

        return count;
    }

    public static boolean canBeAlmostEqual(int n1, int n2) {
        StringBuilder num1 = new StringBuilder(n1 + "");
        StringBuilder num2 = new StringBuilder(n2 + "");

        if (n1 == n2) {
            return true;
        }

        if (canSwapToMatch(num1, num2)) {
            return true;
        }

        if (canSwapToMatch(num2, num1)) {
            return true;
        }

        return false;
    }

    public static boolean canSwapToMatch(StringBuilder num1, StringBuilder num2) {
        for (int i = 0; i < num1.length(); i++) {
            for (int j = i + 1; j < num1.length(); j++) {
                char a = num1.charAt(i);
                char b = num1.charAt(j);

                num1.setCharAt(i, b);
                num1.setCharAt(j, a);

                if (Integer.parseInt(num1.toString()) == Integer.parseInt(num2.toString())) {
                    return true;
                }

                num1.setCharAt(i, a);
                num1.setCharAt(j, b);
            }
        }
        return false;
    }
}

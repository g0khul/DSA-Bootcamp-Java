import java.util.Arrays;

public class FindTheKeyOfTheNumbers {
    public static void main(String[] args) {
        int num1 = 987;
        int num2 = 879;
        int num3 = 798;

        System.out.println(generateKey(num1, num2, num3));
    }

    public static int generateKey(int num1, int num2, int num3) {
        String[] nums = { String.valueOf(num1), String.valueOf(num2), String.valueOf(num3) };

        for (int i = 0; i < nums.length; i++) {
            while (nums[i].length() < 4) {
                nums[i] = '0' + nums[i];
            }
        }

        String result = "";
        for (int i = 0; i < 4; i++) {
            result += Math.min(
                    Integer.parseInt(nums[0].charAt(i) + ""),
                    Math.min(
                            Integer.parseInt(nums[1].charAt(i) + ""),
                            Integer.parseInt(nums[2].charAt(i) + "")));
        }

        return Integer.parseInt(result);
    }
}

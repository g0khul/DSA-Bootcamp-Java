
public class SingleNumber {
    public static void main(String[] args) {
        int[] nums = { 4, 1, 2, 1, 2 };
        System.out.println(singleNumber(nums));
    }

    public static int singleNumber(int[] nums) {
        int sum = 0;
        for (int i : nums) {
            sum = sum ^ i;
        }
        return sum;
    }

}
public class FindMinimumOperationsToMakeAllElementsDivisibleByThree {
    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4 };
        System.out.println(minimumOperations(nums));
    }

    public static int minimumOperations(int[] nums) {
        int operations = 0;
        for (int n : nums) {
            if (n % 3 != 0 && ((n - 1) % 3 == 0 || (n + 1) % 3 == 0)) {
                operations++;
            }
        }
        return operations;
    }
}

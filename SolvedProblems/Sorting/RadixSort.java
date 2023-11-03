package SolvedProblems.Sorting;

import java.util.Arrays;

public class RadixSort {
    public static void main(String[] args) {
        int[] nums = { 34, 8, 65, 468, 864, 96, 1, 2, 65 };
        radixSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    private static void radixSort(int[] nums) {
        int max = Arrays.stream(nums).max().getAsInt();
        int times = (int) Math.log10(max) + 1;

        for (int exp = 1; exp < times + 1; exp++) {
            countSort(nums, exp);
        }
    }

    private static void countSort(int[] nums, int exp) {
        int[] count = new int[10];
        int[] update = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            count[(nums[i] / exp ) % 10]++;
        }

        for (int i = 1; i < count.length; i++) {
            count[i] = count[i] + count[i - 1];
        }

        for (int i = nums.length - 1; i >= 0; i--) {
            update[count[(nums[i] / exp) % 10] - 1] = nums[i];
            count[(nums[i] / exp) % 10]--;
        }

        System.arraycopy(update, 0, nums, 0, nums.length);
    }
}

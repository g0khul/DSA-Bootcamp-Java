package SolvedProblems.Heaps;

import java.util.Arrays;
import java.util.Scanner;

// Max heap
public class BasicOperations {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = 9;
        // 9
        // 14 2 4 5 9 8 7 16 10
        int[] arr = { -1, 14, 2, 4, 5, 9, 8, 7, 16, 10 };
        int[] nums = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            nums[i] = arr[i];
            insert(nums, i);
        }

        System.out.println(nums[1]); // Max element
        System.out.println(Arrays.toString(nums));

        // Delete root val
        nums[1] = 0;

        // Restructure the array
        remove(nums);

        System.out.println(Arrays.toString(nums));
        sc.close();
    }

    private static void remove(int[] nums) {
        nums[1] = nums[nums.length - 1];
        nums[nums.length - 1] = 0;

        int index = 1;
        while (index != nums.length && (nums[index] < nums[2 * index] || nums[index] < nums[2 * index + 1])) {
            if (nums[index] < nums[2 * index]) {
                int temp = nums[index];
                nums[index] = nums[2 * index];
                nums[2 * index] = temp;
                index = 2 * index;
            }

            if (nums[index] < nums[2 * index + 1]) {
                int temp = nums[index];
                nums[index] = nums[2 * index + 1];
                nums[2 * index + 1] = temp;
                index = 2 * index + 1;
            }
        }
    }

    private static void insert(int[] nums, int index) {
        while (index != 1 && nums[index / 2] < nums[index]) {
            int temp = nums[index];
            nums[index] = nums[index / 2];
            nums[index / 2] = temp;
            index = index / 2;
            // System.out.println("hi");
        }
    }
}

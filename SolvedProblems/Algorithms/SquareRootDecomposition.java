// package Algorithms;

import java.util.Arrays;

public class SquareRootDecomposition {
    public static void main(String[] args) {
        int[] arr = { 1, 3, 5, 2, 7, 6, 3, 13, 1, 4, 8 };
        int left = 0;
        int right = arr.length - 1;
        int sum = getSum(arr, left, right);
        System.out.println(sum);
        update(arr, 2, 13);
        System.out.println(Arrays.toString(arr));
    }

    public static int[] getBlocks(int[] arr, int sqrt) {
        int[] blocks = new int[sqrt + 1];
        int block_index = -1;

        for (int i = 0; i < arr.length; i++) {
            if (i % sqrt == 0) {
                block_index++;
            }
            blocks[block_index] += arr[i];
        }

        return blocks;
    }

    public static int getSum(int[] arr, int left, int right) {
        int sqrt = (int) Math.sqrt(arr.length);
        int[] blocks = getBlocks(arr, sqrt);

        return query(arr, blocks, left, right, sqrt);
    }

    public static int query(int[] arr, int[] blocks, int left, int right, int sqrt) {
        int ans = 0;

        while (left != 0 && left % sqrt != 0 && left < right) {
            ans += arr[left++];
        }

        while (left + sqrt <= right) {
            ans += blocks[left / sqrt];
            left += sqrt;
        }

        while (left <= right) {
            ans += arr[left++];
        }

        return ans;
    }

    public static void update(int[] arr, int index, int val) {
        int sqrt = (int) Math.sqrt(arr.length);
        int[] blocks = getBlocks(arr, sqrt);
        updateIndex(arr, blocks, index, val, sqrt);
    }

    public static void updateIndex(int[] arr, int[] blocks, int index, int val, int sqrt) {
        int block_index = index / sqrt;
        blocks[block_index] = blocks[block_index] - arr[index] + val;
        arr[index] = val;
    }
}

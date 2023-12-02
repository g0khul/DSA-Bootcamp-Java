package CPfor100Days.GreedyApproach;

// https://www.geeksforgeeks.org/minimum-sum-product-two-arrays/

public class MinimumSumOfProductOfTwoArrays {
    public static int minProduct(int[] nums1, int[] nums2, int k) {
        int minSum = Integer.MAX_VALUE;
        for (int i = 0; i < nums1.length; i++) {
            int currSum = 0;

            // Decrement
            if (nums1[i] > 0 && nums2[i] > 0) {
                nums1[i] -= 2 * k;
                currSum = findSum(nums1, nums2);
                nums1[i] += 2 * k;
            } else { // Increment
                nums1[i] += 2 * k;
                currSum = findSum(nums1, nums2);
                nums1[i] -= 2 * k;
            }

            if (currSum < minSum) {
                minSum = currSum;
            }
        }

        return minSum;
    }

    private static int findSum(int[] nums1, int[] nums2) {
        int sum = 0;

        for (int i = 0; i < nums1.length; i++) {
            sum += nums1[i] * nums2[i];
        }

        return sum;
    }

    public static void main(String[] args) {
        int[] nums1 = { 1, 2, -3 };
        int[] nums2 = { -2, 3, -5 };
        int k = 5;
        System.out.println(minProduct(nums1, nums2, k));
    }
}

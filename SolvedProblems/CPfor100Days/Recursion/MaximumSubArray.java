package Recursion;

public class MaximumSubArray {
    public static int maxSubArray(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        // int max = Integer.MIN_VALUE;
        // int sum = 0;
        // for (int i : nums) {
        //     sum += i;
        //     max = Math.max(max, sum);
        //     if (sum < 0) {
        //         sum = 0;
        //     }
        // }

        // Print max subarray
        // int start = 0;
        // int starti = -1;
        // int endi = -1;
        // int max = Integer.MIN_VALUE;
        // int sum = 0;
        // for (int i = 0; i < nums.length; i++) {
        //     if(sum == 0){
        //         start = i;
        //     }

        //     sum += nums[i];
            
        //     if(sum > max){
        //         max = sum;
                
        //         starti = start;
        //         endi = i;
        //     }
            
        //     if (sum < 0) {
        //         sum = 0;
        //     }
        // }

        // for (int i = starti; i <= endi; i++) {
        //     System.out.print(nums[i] + " ");
        // }
        // System.out.println();

        // return max;

        return helper(nums, 0, 0, Integer.MIN_VALUE);
    }

    private static int helper(int[] nums, int index, int sum, int max) {
        if (index == nums.length) {
            return max;
        }

        sum += nums[index];

        if (sum < 0) {
            sum = 0;
        }

        return helper(nums, index + 1, sum, Math.max(max, sum));
    }

    public static void main(String[] args) {
        int[] nums = { -2,1,-3,4,-1,2,1,-5,4 };
        System.out.println(maxSubArray(nums));
    }
}

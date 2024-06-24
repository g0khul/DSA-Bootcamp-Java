public class MaximumSumOfNonAdjacentArray {
    public static void main(String[] args) {
        int[] arr = { 2, 1, 4, 3 };
        System.out.println(maximumSumOfNonAdjacentArray(arr));
        System.out.println(dpMaximumSumOfNonAdjacentArray(arr));
    }

    public static int maximumSumOfNonAdjacentArray(int[] arr) {
        return helper(arr, arr.length - 1);
    }

    public static int helper(int[] arr, int index) {
        if (index < 0) {
            return 0;
        }

        if (index == 0) {
            return arr[0];
        }

        int takeIt = arr[index] + helper(arr, index - 2);
        int leaveIt = helper(arr, index - 1);

        return Math.max(takeIt, leaveIt);
    }

    public static int dpMaximumSumOfNonAdjacentArray(int[] arr) {
        if (arr.length == 1) {
            return arr[0];
        }

        if (arr.length == 2) {
            return Math.max(arr[0], arr[1]);
        }

        // int[] dp = new int[arr.length];
        // dp[0] = arr[0];
        // dp[1] = Math.max(arr[0], arr[1]);
        // for (int i = 2; i < dp.length; i++) {
        // int takeIt = arr[i] + dp[i - 2];
        // int leaveIt = dp[i - 1];
        // dp[i] = Math.max(takeIt, leaveIt);
        // }

        // return dp[dp.length - 1];

        // Space optimized
        int prev = arr[0];
        int secPrev = 0;

        for (int i = 2; i < arr.length; i++) {
            int takeIt = arr[i] + secPrev;
            int leaveIt = prev;
            secPrev = prev;
            prev = Math.max(takeIt, leaveIt);
        }

        return prev;
    }
}

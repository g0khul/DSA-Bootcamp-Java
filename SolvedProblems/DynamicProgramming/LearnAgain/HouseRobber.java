public class HouseRobber {
    public static void main(String[] args) {
        int[] arr = { 2, 7, 9, 3, 1 };
        System.out.println(houseRobber(arr));
    }

    public static int houseRobber(int[] arr) {
        if (arr.length == 1) {
            return arr[0];
        }

        // Ignoring last
        int ans1 = maxSumWithRange(arr, 0, arr.length - 1);

        // Ignoring first
        int ans2 = maxSumWithRange(arr, 1, arr.length);

        return Math.max(ans1, ans2);
    }

    public static int maxSumWithRange(int[] arr, int start, int end) {
        int prev = arr[start++];
        int secPrev = 0;

        for (int i = start; i < end; i++) {
            int takeIt = arr[i] + secPrev;
            int leaveIt = prev;
            secPrev = prev;
            prev = Math.max(takeIt, leaveIt);
        }

        return prev;
    }
}
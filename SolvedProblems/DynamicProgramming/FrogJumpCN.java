import java.util.Arrays;

// Coding Ninjas
public class FrogJump {
    public static void main(String[] args) {
        int[] stones = { 0, 2, 5, 6, 7 };
        System.out.println(maxJump(stones));
    }

    public static int maxJump(int[] stones) {
        // int[] dp = new int[stones.length];
        // Arrays.fill(dp, -1);
        // return helper(stones, dp, stones.length - 1);

        int previous = 0;
        int secondPrevioius = Math.abs(stones[0] - stones[1]);

        for(int i = 2; i < stones.length; i++){
            int fs = previous + Math.abs(stones[i] - stones[i - 1]);
            int ss = Integer.MAX_VALUE;
 - 1
            if(i > 1){
                ss = secondPrevioius = secondPrevioius + Math.abs(stones[i] - stones[i - 2]);
            }
            int sum = Math.min(fs, ss);
            secondPrevioius = previous;
            previous = sum;
        }

        return previous;
    }

    public static int helper(int[] stones, int[] dp, int index) {
        if (index == 0) {
            return 0;
        }

        if (dp[index] != -1) {
            return dp[index];
        }

        int left = helper(stones, dp, index - 1) + Math.abs(stones[index] - stones[index - 1]);

        int right = Integer.MAX_VALUE;
        if (index > 1) {
            right = helper(stones, dp, index - 2) + Math.abs(stones[index] - stones[index - 2]);
        }

        dp[index] = Math.min(left, right);

        return dp[index];
    }
}

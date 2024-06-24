// https://www.geeksforgeeks.org/problems/geek-jump/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=geek-jump

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class FrogJump {
    public static void main(String[] args) {
        // Scanner sc = new Scanner(System.in);
        // int n = sc.nextInt();
        // int[] input = new int[n];
        // for (int i = 0; i < input.length; i++) {
        // input[i] = sc.nextInt();
        // }
        int n = 6;
        int[] input = { 30, 10, 60, 10, 60, 50 };
        System.out.println(Arrays.toString(input));

        // int[] dp = new int[n];
        // Arrays.fill(dp, -1);
        // dp[0] = 0;
        // dp[1] = Math.abs(input[0] - input[1]);
        // int result = minimumEnergy(n - 1, input, dp);
        // System.out.println(result);

        // if (n - 1 == 0) {
        // System.out.println(0);
        // return;
        // }

        // int prev = 0;
        // int secPrev = 0;
        // for (int i = 1; i < n; i++) {
        // int left = prev + Math.abs(input[i] - input[i - 1]);
        // int right = Integer.MAX_VALUE;
        // if (i > 1) {
        // right = secPrev + Math.abs(input[i] - input[i - 2]);
        // }
        // int result = Math.min(left, right);
        // secPrev = prev;
        // prev = result;
        // }
        // System.out.println(prev);

        // K steps with space optimization
        int k = 3;
        if (n - 1 == 0) {
            System.out.println(0);
            return;
        }

        List<Integer> dp = new ArrayList<>();
        dp.add(0);
        for (int i = 1; i < n; i++) {
            int resi = Integer.MAX_VALUE;
            for (int j = 1; j <= k; j++) {
                if (i - j >= 0) {
                    int curi = dp.get((i - j) % k) + Math.abs(input[i] - input[i - j]);
                    resi = Math.min(resi, curi);
                }
            }
            dp.add(resi);
            if (dp.size() > k) {
                dp.remove(0);
            }
        }

        System.out.println(dp.get(dp.size() - 1));
        System.out.println(dp);
    }

    public static int minimumEnergy(int n, int[] input, int[] dp) {
        if (n == 0) {
            return 0;
        }

        if (dp[n] != -1) {
            return dp[n];
        }

        int left = minimumEnergy(n - 1, input, dp) + Math.abs(input[n] - input[n - 1]);
        int right = Integer.MAX_VALUE;
        if (n > 1) {
            right = minimumEnergy(n - 2, input, dp) + Math.abs(input[n] - input[n - 2]);
        }

        dp[n] = Math.min(left, right);

        return dp[n];
    }
}

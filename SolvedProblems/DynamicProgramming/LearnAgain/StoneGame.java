import java.util.*;

public class StoneGame {
    public static void main(String[] args) {
        int[] piles = { 5, 3, 4, 5 };
        System.out.println(stoneGameRecursion(piles));
        System.out.println(stoneGameMemoization(piles));
        System.out.println(stoneGameDp(piles));
    }

    public static boolean stoneGameRecursion(int[] piles) {
        // Brute Force
        return helperRecursion(piles, 0, piles.length - 1, 0, 0);
    }

    public static boolean helperRecursion(int[] piles, int start, int end, int turn, int aliceSum) {
        if (start > end) {
            int total = 0;
            for (int i : piles) {
                total += i;
            }
            return aliceSum > total / 2;
        }

        boolean startRes = false;
        boolean endRes = false;
        if (turn == 0) {
            // Alice turn
            // Take from start
            startRes = helperRecursion(piles, start + 1, end, 1, aliceSum + piles[start]);
            // Take from end
            endRes = helperRecursion(piles, start, end - 1, 1, aliceSum + piles[end]);
        } else {
            // Bob turn
            // Take from start
            startRes = helperRecursion(piles, start + 1, end, 0, aliceSum);
            // Take from end
            endRes = helperRecursion(piles, start, end - 1, 0, aliceSum);
        }

        return startRes || endRes;
    }

    public static boolean stoneGameMemoization(int[] piles) {
        int total = 0;
        for (int i : piles) {
            total += i;
        }

        int[][][] memo = new int[piles.length][piles.length][total];
        for (int[][] is : memo) {
            for (int[] is2 : is) {
                Arrays.fill(is2, -1);
            }
        }

        return helperMemoization(piles, 0, piles.length - 1, 0, total, memo);
    }

    public static boolean helperMemoization(int[] piles, int start, int end, int aliceSum, int total, int[][][] memo) {
        if (start > end) {
            return aliceSum > total / 2;
        }

        if (memo[start][end][aliceSum] != -1) {
            return memo[start][end][aliceSum] == 1;
        }

        // 0 for alice 1 for bob
        boolean isAliceTurn = (start + end) % 2 == 0;
        boolean res = false;
        if (isAliceTurn) {
            res = helperMemoization(piles, start + 1, end, aliceSum + piles[start], total, memo)
                    || helperMemoization(piles, start, end - 1, aliceSum + piles[end], total, memo);
        } else {
            res = helperMemoization(piles, start + 1, end, aliceSum, total, memo)
                    || helperMemoization(piles, start, end - 1, aliceSum, total, memo);
        }

        memo[start][end][aliceSum] = res ? 1 : 0;
        return res;
    }

    public static boolean stoneGameDp(int[] piles) {
        int total = 0;
        for (int i : piles) {
            total += i;
        }

        int[][][] dp = new int[piles.length][piles.length][total + 1];
        for (int start = piles.length - 1; start >= 0; start--) {
            for (int end = start; end < piles.length; end++) {
                for (int aliceSum = 0; aliceSum <= total; aliceSum++) {
                    boolean isAliceTurn = (start + end) % 2 == 0;
                    boolean res = false;
                    if (start == end) {
                        res = isAliceTurn && (aliceSum + piles[start] > total / 2);
                    } else {
                        if (isAliceTurn) {
                            res = (start + 1 <= end && aliceSum + piles[start] <= total
                                    && dp[start + 1][end][aliceSum + piles[start]] == 1)
                                    || (start <= end - 1 && aliceSum + piles[end] <= total
                                            && dp[start][end - 1][aliceSum + piles[end]] == 1);
                        } else {
                            res = (start + 1 <= end
                                    && dp[start + 1][end][aliceSum] == 1)
                                    || (start <= end - 1
                                            && dp[start][end - 1][aliceSum] == 1);
                        }
                    }
                    dp[start][end][aliceSum] = res ? 1 : 0;
                }
            }
        }

        return dp[0][piles.length - 1][0] == 1;
    }
}

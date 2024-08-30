import java.util.*;

public class StoneGameII {
    public static void main(String[] args) {
        int[] piles = { 2, 7, 9, 4, 4 };
        System.out.println(stoneGameIIRecursion(piles));
        System.out.println(stoneGameIIMemoization(piles));
        System.out.println(stoneGameIIDp(piles));
    }

    public static int stoneGameIIRecursion(int[] piles) {
        // 0 means alice 1 means bob
        return helperRecursion(piles, 0, 1, 0);
    }

    public static int helperRecursion(int[] piles, int i, int m, int turn) {
        if (i == piles.length) {
            return 0;
        }

        int aliceScore = turn == 0 ? 0 : Integer.MAX_VALUE;
        int currSum = 0;
        for (int x = 1; x < 2 * m + 1; x++) {
            if (i + x > piles.length) {
                break;
            }
            currSum += piles[i + x - 1];
            if (turn == 0) {
                aliceScore = Math.max(aliceScore, currSum + helperRecursion(piles, i + x, Math.max(m, x), 1));
            } else {
                aliceScore = Math.min(aliceScore, helperRecursion(piles, i + x, Math.max(m, x), 0));
            }
        }

        return aliceScore;
    }

    public static int stoneGameIIMemoization(int[] piles) {
        Map<String, Integer> memo = new HashMap<>();
        return helperMemoization(piles, 0, 1, 0, memo);
    }

    public static int helperMemoization(int[] piles, int i, int m, int turn, Map<String, Integer> memo) {
        if (i == piles.length) {
            return 0;
        }

        String state = i + "," + m + "," + turn;
        if (memo.containsKey(state)) {
            return memo.get(state);
        }

        int aliceScore = turn == 0 ? 0 : Integer.MAX_VALUE;
        int currSum = 0;
        for (int x = 1; x < 2 * m + 1; x++) {
            if (i + x > piles.length) {
                break;
            }
            currSum += piles[i + x - 1];
            if (turn == 0) {
                aliceScore = Math.max(aliceScore, currSum + helperMemoization(piles, i + x, Math.max(m, x), 1, memo));
            } else {
                aliceScore = Math.min(aliceScore, helperMemoization(piles, i + x, Math.max(m, x), 0, memo));
            }
        }

        memo.put(state, aliceScore);
        return aliceScore;
    }

    public static int stoneGameIIDp(int[] piles) {
        int[][][] dp = new int[piles.length + 1][piles.length + 1][2];

        for (int i = piles.length - 1; i >= 0; i--) {
            for (int m = 1; m <= piles.length; m++) {
                for (int turn = 0; turn < 2; turn++) {
                    int aliceScore = turn == 0 ? 0 : Integer.MAX_VALUE;
                    int currSum = 0;
                    for (int x = 1; x <= 2 * m && i + x <= piles.length; x++) {
                        currSum += piles[i + x - 1];
                        if (turn == 0) {
                            aliceScore = Math.max(aliceScore,
                                    currSum + dp[i + x][Math.max(m, x)][1]);
                        } else {
                            aliceScore = Math.min(aliceScore, dp[i + x][Math.max(m, x)][0]);
                        }
                    }
                    dp[i][m][turn] = aliceScore;
                }
            }
        }

        return dp[0][1][0];
    }
}

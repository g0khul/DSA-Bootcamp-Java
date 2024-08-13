import java.util.Arrays;

public class BooleanEvaluation {
    public static void main(String[] args) {
        String exp = "F|T^F&T&T&T&T";
        System.out.println(evaluateExpRecursion(exp));
        System.out.println(evaluateExpMemoization(exp));
        System.out.println(evaluateExpDp(exp));
    }

    public static int evaluateExpRecursion(String exp) {
        return helperRecursion(exp, 0, exp.length() - 1, 1);
    }

    public static int helperRecursion(String exp, int i, int j, int isTrue) {
        if (i > j) {
            return 0;
        }

        if (i == j) {
            if (isTrue == 1) {
                return exp.charAt(i) == 'T' ? 1 : 0;
            }
            return exp.charAt(i) == 'F' ? 1 : 0;
        }

        int ways = 0;
        int MOD = 1000000007;
        for (int k = i + 1; k <= j - 1; k += 2) {
            int leftTrue = helperRecursion(exp, i, k - 1, 1);
            int leftFalse = helperRecursion(exp, i, k - 1, 0);
            int rightTrue = helperRecursion(exp, k + 1, j, 1);
            int rightFalse = helperRecursion(exp, k + 1, j, 0);

            if (exp.charAt(k) == '&') {
                if (isTrue == 1) {
                    ways = (ways + (leftTrue * rightTrue) % MOD) % MOD;
                } else {
                    ways = ways + (leftFalse * rightFalse) % MOD;
                    ways = ways + (leftFalse * rightTrue) % MOD;
                    // Do mod when all operations are done
                    ways = (ways + (leftTrue * rightFalse) % MOD) % MOD;
                }
            } else if (exp.charAt(k) == '|') {
                if (isTrue == 1) {
                    ways = (ways + (leftTrue * rightTrue) % MOD);
                    ways = (ways + (leftTrue * rightFalse) % MOD);
                    ways = (ways + (leftFalse * rightTrue) % MOD) % MOD;
                } else {
                    ways = (ways + (leftFalse * rightFalse) % MOD) % MOD;
                }
            } else if (exp.charAt(k) == '^') {
                if (isTrue == 1) {
                    ways = (ways + (leftFalse * rightTrue) % MOD);
                    ways = (ways + (leftTrue * rightFalse) % MOD) % MOD;
                } else {
                    ways = (ways + (leftTrue * rightTrue) % MOD);
                    ways = (ways + (leftFalse * rightFalse) % MOD);
                }
            }
        }

        return ways;
    }

    public static int evaluateExpMemoization(String exp) {
        int[][][] memo = new int[exp.length()][exp.length()][2];
        for (int[][] is : memo) {
            for (int[] is2 : is) {
                Arrays.fill(is2, -1);
            }
        }

        return helperMemoization(exp, 0, exp.length() - 1, 1, memo);
    }

    public static int helperMemoization(String exp, int i, int j, int isTrue, int[][][] memo) {
        if (i > j) {
            return 0;
        }

        if (i == j) {
            if (isTrue == 1) {
                return exp.charAt(i) == 'T' ? 1 : 0;
            }
            return exp.charAt(i) == 'F' ? 1 : 0;
        }

        if (memo[i][j][isTrue] != -1) {
            return memo[i][j][isTrue];
        }

        int ways = 0;
        int MOD = 1000000007;
        for (int k = i + 1; k <= j - 1; k += 2) {
            int leftTrue = helperMemoization(exp, i, k - 1, 1, memo);
            int leftFalse = helperMemoization(exp, i, k - 1, 0, memo);
            int rightTrue = helperMemoization(exp, k + 1, j, 1, memo);
            int rightFalse = helperMemoization(exp, k + 1, j, 0, memo);

            if (exp.charAt(k) == '&') {
                if (isTrue == 1) {
                    ways = (ways + (leftTrue * rightTrue) % MOD) % MOD;
                } else {
                    ways = ways + (leftFalse * rightFalse) % MOD;
                    ways = ways + (leftFalse * rightTrue) % MOD;
                    // Do mod when all operations are done
                    ways = (ways + (leftTrue * rightFalse) % MOD) % MOD;
                }
            } else if (exp.charAt(k) == '|') {
                if (isTrue == 1) {
                    ways = (ways + (leftTrue * rightTrue) % MOD);
                    ways = (ways + (leftTrue * rightFalse) % MOD);
                    ways = (ways + (leftFalse * rightTrue) % MOD) % MOD;
                } else {
                    ways = (ways + (leftFalse * rightFalse) % MOD) % MOD;
                }
            } else if (exp.charAt(k) == '^') {
                if (isTrue == 1) {
                    ways = (ways + (leftFalse * rightTrue) % MOD);
                    ways = (ways + (leftTrue * rightFalse) % MOD) % MOD;
                } else {
                    ways = (ways + (leftTrue * rightTrue) % MOD);
                    ways = (ways + (leftFalse * rightFalse) % MOD);
                }
            }
        }

        return memo[i][j][isTrue] = ways;
    }

    public static int evaluateExpDp(String exp) {
        int n = exp.length();
        int[][][] dp = new int[n + 1][n + 1][2];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j <= n - 1; j++) {
                for (int isTrue = 0; isTrue <= 1; isTrue++) {
                    if (i == j) {
                        if (isTrue == 1) {
                            dp[i][j][isTrue] = exp.charAt(i) == 'T' ? 1 : 0;
                        } else {
                            dp[i][j][isTrue] = exp.charAt(i) == 'F' ? 1 : 0;
                        }
                        continue;
                    }
                    int ways = 0;
                    int MOD = 1000000007;
                    for (int k = i + 1; k <= j - 1; k += 2) {
                        int leftTrue = dp[i][k - 1][1];
                        int leftFalse = dp[i][k - 1][0];
                        int rightTrue = dp[k + 1][j][1];
                        int rightFalse = dp[k + 1][j][0];

                        if (exp.charAt(k) == '&') {
                            if (isTrue == 1) {
                                ways = (ways + (leftTrue * rightTrue) % MOD) % MOD;
                            } else {
                                ways = ways + (leftFalse * rightFalse) % MOD;
                                ways = ways + (leftFalse * rightTrue) % MOD;
                                // Do mod when all operations are done
                                ways = (ways + (leftTrue * rightFalse) % MOD) % MOD;
                            }
                        } else if (exp.charAt(k) == '|') {
                            if (isTrue == 1) {
                                ways = (ways + (leftTrue * rightTrue) % MOD);
                                ways = (ways + (leftTrue * rightFalse) % MOD);
                                ways = (ways + (leftFalse * rightTrue) % MOD) % MOD;
                            } else {
                                ways = (ways + (leftFalse * rightFalse) % MOD) % MOD;
                            }
                        } else if (exp.charAt(k) == '^') {
                            if (isTrue == 1) {
                                ways = (ways + (leftFalse * rightTrue) % MOD);
                                ways = (ways + (leftTrue * rightFalse) % MOD) % MOD;
                            } else {
                                ways = (ways + (leftTrue * rightTrue) % MOD);
                                ways = (ways + (leftFalse * rightFalse) % MOD);
                            }
                        }
                    }
                    dp[i][j][isTrue] = ways;
                }
            }
        }

        return dp[0][n - 1][1];
    }
}

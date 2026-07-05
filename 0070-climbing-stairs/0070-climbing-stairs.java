class Solution {

    int[] dp;

    public int climbStairs(int n) {
        dp = new int[n + 1];

        return nWays(n);
    }

    int nWays(int n) {
        if (n <= 2) {
            return n;
        }

        if (dp[n] != 0) {
            return dp[n];
        }

        dp[n] = nWays(n - 1) + nWays(n - 2);
        return dp[n];
    }
}
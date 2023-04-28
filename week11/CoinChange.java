/**
 * TC = O(M * k) ; where M is the amount and k is the length od coins.
 * MC = O(M);
 * Problem link : https://leetcode.com/problems/coin-change/description/
 */

class Solution {

    private static final int INF = Integer.MAX_VALUE;

    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, INF);
        dp[0] = 0;
        
        for (int i = 1; i <= amount; i++) {
            for (int k = 0; k < coins.length; k++) {
                if (i >= coins[k] && dp[i - coins[k]] != INF) {
                    dp[i] = Math.min(dp[i], 1 + dp[i - coins[k]]);
                }
            }
        }

        return dp[amount] == INF ? -1 : dp[amount];
    }
}

/**
 * TC = O(n * k) ; where n is the length of prices array and k is the max number of transaction allowed.
 * MC = O(n * k);
 * Problem link : https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/description/
 */

class Solution {

    Integer[][][] dp;
    int[] prices;
    int n;

    private static final int INF = Integer.MAX_VALUE / 2;

    public int maxProfit(int k, int[] prices) {
        this.prices = prices;
        n = prices.length;
        dp = new Integer[n][k + 1][2];

        return calMaxProfit(0, k, 0);
    }

    private int calMaxProfit(int i, int k, int isBought) {
        if (i >= n) {
            return isBought == 0 ? 0 : -INF;
        }
        if (k <= 0) {
            return 0;
        }
        if (dp[i][k][isBought] != null) {
            return dp[i][k][isBought];
        }

        int mxGain = calMaxProfit(i + 1, k, isBought);

        if (isBought == 1) {
            mxGain = Math.max(mxGain, prices[i] + calMaxProfit(i + 1, k - 1, 0));
        } else {
            mxGain = Math.max(mxGain, -prices[i] + calMaxProfit(i + 1, k, 1));
        }

        return dp[i][k][isBought] = mxGain;
    }
}

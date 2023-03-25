/**
 * TC = O(n) ; where n is the length of prices array.
 * MC = O(1);
 * Problem link : https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/
 */

class Solution {

    public int maxProfit(int[] prices) {
        int minPriceSoFar = Integer.MAX_VALUE / 2, maxGain = 0;

        for (int i = 0; i < prices.length; i++) {
            maxGain = Math.max(maxGain, prices[i] - minPriceSoFar);
            minPriceSoFar = Math.min(minPriceSoFar, prices[i]);
        }

        return maxGain;
    }
}

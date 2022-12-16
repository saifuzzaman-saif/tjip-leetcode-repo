class Solution {

    // TC = O(n) ; where n is the size of prices array
    // MC = O(1)

    public int maxProfit(int[] prices) {
        int totalProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            totalProfit += Math.max(0, prices[i] - prices[i - 1]);
        }

        return totalProfit;
    }
}
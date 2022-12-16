class Solution {

    // TC = O(n) : where n is the size of Prices array.
    // MC = O(1)

    private static final int INF = 1_000_000_000;

    public int maxProfit(int[] prices) {
        int leftMin = INF;
        int maxGain = 0;

        for (int price : prices) {
            maxGain = Math.max(maxGain, price - leftMin);
            leftMin = Math.min(leftMin, price);
        }

        return maxGain;
    }
}
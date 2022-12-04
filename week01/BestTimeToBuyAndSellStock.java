class Solution {

    // TC = O(n) : where n is the size of Prices array.
    // MC = O(1)

    int inf = 1_000_000_000;

    public int maxProfit(int[] prices) {
        int leftMin = inf;
        int maxGain = 0;

        for (int price : prices) {
            maxGain = Math.max(maxGain, price - leftMin);
            leftMin = Math.min(leftMin, price);
        }

        return maxGain;
    }
}
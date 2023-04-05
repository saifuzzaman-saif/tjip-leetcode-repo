/**
 * TC = O(n * sqrt(n)) ; where n is the given integer.
 * MC = O(n);
 * Problem link : https://leetcode.com/problems/perfect-squares/description/
 */

class Solution {

    public int numSquares(int n) {
        List<Integer> squares = new ArrayList<>();
        for (int i = 1; i * i <= n; i++) {
            squares.add(i*i);
        }

        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < squares.size(); j++) {
                if (i >= squares.get(j)) {
                    dp[i] = Math.min(dp[i], 1 + dp[i - squares.get(j)]);
                }
            }
        }

        return dp[n];
    }
}

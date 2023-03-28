/**
 * TC = O(n^2) ; where n is the length of nums array.
 * MC = O(n);
 * Problem link : https://leetcode.com/problems/longest-increasing-subsequence/description/
 */

class Solution {

    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] < nums[j]) {
                    dp[j] = Math.max(dp[j], dp[i] + 1);
                }
            }
        }

        int length = 0;
        for (int d : dp) {
            length = Math.max(length, d);
        }

        return length;
    }
}

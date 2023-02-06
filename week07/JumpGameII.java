/**
 * TC = O(N); where N is the length of nums.
 * MC = O(1);
 * Problem Link : https://leetcode.com/problems/jump-game-ii/description/
 */

class Solution {

    public int jump(int[] nums) {
        int n = nums.length;
        int jumpCount = 0;
        int endOfCurrJump = 0;
        int maxReachablePos = 0;

        for (int pos = 0; pos + 1 < n; pos++) {
            maxReachablePos = Math.max(maxReachablePos, pos + nums[pos]);

            if (pos == endOfCurrJump) {
                jumpCount++;
                endOfCurrJump = maxReachablePos;
            }
        }

        return jumpCount;
    }
}

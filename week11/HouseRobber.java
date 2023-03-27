/**
 * TC = O(n) ; where n is the length of nums array.
 * MC = O(1);
 * Problem link : https://leetcode.com/problems/house-robber/description/
 */

class Solution {

    public int rob(int[] nums) {
        int n = nums.length;
        int todayGain = 0;
        int nextDayGain = 0, nextOfNextDayGain = 0;

        for (int i = n - 1; i >= 0; i--) {
            todayGain = Math.max(nextDayGain, nums[i] + nextOfNextDayGain);
            nextOfNextDayGain = nextDayGain;
            nextDayGain = todayGain;
        }

        return todayGain;
    }
}

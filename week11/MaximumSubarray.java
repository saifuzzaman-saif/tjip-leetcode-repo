/**
 * TC = O(n) ; where n is the length of the nums array.
 * MC = O(1);
 * Problem link : https://leetcode.com/problems/maximum-subarray/
 */

class Solution {

    public int maxSubArray(int[] nums) {
        int mxSum = nums[0], currSum = 0;

        for (int num : nums) {
            currSum = Math.max(currSum, 0) + num;
            mxSum = Math.max(mxSum, currSum);
        }

        return mxSum;
    }
}

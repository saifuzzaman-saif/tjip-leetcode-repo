/*
 * TC = O(logN) ; where N is the length of nums;
 * MC = O(1)
 * Problem link : https://leetcode.com/problems/find-peak-element/description/
 */

class Solution {

    public int findPeakElement(int[] nums) {
        int l = 0, r = nums.length - 1;

        while (l < r) {
            int m = l + (r - l) / 2;

            if (nums[m] <= nums[m+1]) {
                l = m + 1;
            } else {
                r = m;
            }
        }

        return l;
    }
}

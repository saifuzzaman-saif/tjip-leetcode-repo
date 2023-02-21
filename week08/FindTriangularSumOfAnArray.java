/**
 * TC = O(N^2) ; where N is the length of nums given.
 * MC = O(1)
 * Problem link : https://leetcode.com/problems/find-triangular-sum-of-an-array/description/
 */

class Solution {

    private static final int MOD = 10;

    public int triangularSum(int[] nums) {
        int len = nums.length;

        while (len > 1) {
            for (int i = 0; i + 1 < len; i++) {
                nums[i] = (nums[i] + nums[i+1]) % MOD;
            }

            len--;
        }

        return nums[0];
    }
}

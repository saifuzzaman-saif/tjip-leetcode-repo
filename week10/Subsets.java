
/**
 * TC = o(2^n * n) ; where n is the length of nums.
 * MC = O(2^n); to store the results.
 * Problem link : https://leetcode.com/problems/subsets/
 */

class Solution {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> sets = new ArrayList<>();
        int n = nums.length;

        for (int i = 0; i < (1 << n); i++) {
            List<Integer> subset = new ArrayList<>();

            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) > 0) {
                    subset.add(nums[j]);
                }
            }

            sets.add(subset);
        }

        return sets;
    }
}

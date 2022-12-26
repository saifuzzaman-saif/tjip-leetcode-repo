// TC = O(n^2) ; where n is the length of nums array.
// MC = O(n^2)
// Problem link : https://leetcode.com/problems/4sum-ii/

class Solution {
    
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Integer> count = new HashMap<>();

        for (int x : nums1) {
            for (int y : nums2) {
                count.put(x + y, count.getOrDefault(x + y, 0) + 1);
            }
        }

        int cntTuples = 0;

        for (int x : nums3) {
            for (int y : nums4) {
                cntTuples += count.getOrDefault(-(x + y), 0);
            }
        }

        return cntTuples;
    }
}

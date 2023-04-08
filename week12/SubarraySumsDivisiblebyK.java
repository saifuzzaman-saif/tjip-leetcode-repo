/**
* TC = O(n); where n is the length of the nums array.
* MC = O(k); where k is the given integer.
* Problem link : https://leetcode.com/problems/subarray-sums-divisible-by-k/description/
*/

class Solution {

    public int subarraysDivByK(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> cache = new HashMap<>();
        int currSum = 0, subarrayCnt = 0;
        cache.put(0, 1);

        for (int num : nums) {
            currSum += num;
            currSum %= k;
            currSum = (currSum + k) % k;

            subarrayCnt += cache.getOrDefault(currSum, 0);
            cache.put(currSum, cache.getOrDefault(currSum, 0) + 1);
        }

        return subarrayCnt;
    }
}

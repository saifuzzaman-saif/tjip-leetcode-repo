class Solution {

    // TC = O(n) : where n is the size of Nums array.
    // MC = O(n)

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> cache = new HashMap<>();
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            if (cache.containsKey(target - nums[i])) {
                return new int[]{cache.get(target - nums[i]), i};
            } else {
                cache.put(nums[i], i);
            }
        }

        return new int[]{-1, -1};
    }
}

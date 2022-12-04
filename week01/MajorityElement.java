class Solution {

    // TC = O(n) ; where n is the size of Nums array.
    // MC = O(1)

    public int majorityElement(int[] nums) {
        int candidate = -1;
        int voteCount = 0;

        for (int num : nums) {
            if (voteCount == 0) {
                candidate = num;
                voteCount = 1;
            } else {
                voteCount += num == candidate ? 1 : -1;
            }
        }

        return candidate;
    }
}
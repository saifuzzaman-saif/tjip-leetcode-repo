class Solution {

    // TC = O(n) ; where n is the size of nums array.
    // MC = O(1) 

    public int singleNumber(int[] nums) {
        int xor = 0;

        for (int num : nums) {
            xor ^= num;
        }

        return xor;
    }
}
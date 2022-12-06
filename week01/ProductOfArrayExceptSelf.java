class Solution {

    // TC = O(n) ; where n is the size of nums array.
    // MC = O(1)

    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] prods = new int[n];
        prods[0] = 1;

        int prefixProd = nums[0];
        for (int i = 1; i < n; i++) {
            prods[i] = prefixProd;
            prefixProd *= nums[i];
        }

        int suffixProd = nums[n-1];
        for (int i = n-2; i >= 0; i--) {
            prods[i] *= suffixProd;
            suffixProd *= nums[i];
        }

        return prods;
    }
}
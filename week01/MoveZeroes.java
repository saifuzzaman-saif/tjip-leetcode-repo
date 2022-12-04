class Solution {

    // TC = O(n) : where n is the size of Nums array.
    // MC = O(1)

    public void moveZeroes(int[] nums) {
        int prevNonZeroIdx = -1;

        for (int currIdx = 0; currIdx < nums.length; currIdx++) {
            if (nums[currIdx] != 0) {
                if(prevNonZeroIdx + 1 != currIdx) {
                    swap(nums, prevNonZeroIdx + 1, currIdx);
                }

                prevNonZeroIdx++;
            } 
        }
    }

    private void swap(int[] arr, int idx1, int idx2) {
        arr[idx1] += arr[idx2];
        arr[idx2] = arr[idx1] - arr[idx2];
        arr[idx1] = arr[idx1] - arr[idx2];
    }
}
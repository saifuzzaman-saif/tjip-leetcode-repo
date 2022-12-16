class Solution {

    // TC = O(n) ; where n is the size of nums array.
    // MC = O(1)

    public int firstMissingPositive(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < n; ) {
            if (nums[i] < 1 || nums[i] > n || nums[i] == i + 1 
                || nums[nums[i] - 1] == nums[i]) {

                i++;
            } else {
                swap(nums, i, nums[i] - 1);
            }
        }

        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i+1;
            }
        }

        return n+1;
    }

    private void swap(int[] arr, int idx1, int idx2) {
        arr[idx1] += arr[idx2];
        arr[idx2] = arr[idx1] - arr[idx2];
        arr[idx1] -= arr[idx2];
    }
}
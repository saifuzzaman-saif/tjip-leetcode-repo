class Solution {

    // TC = O(n) ; where n is the size of nums array.
    // MC = O(1)

    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int idx1 = n - 2;

        while (idx1 >= 0 && nums[idx1] >= nums[idx1 + 1]) {
            idx1--;
        }

        if (idx1 >= 0) {
            int idx2 = n - 1;
            while (idx2 > idx1 && nums[idx2] <= nums[idx1]) {
                idx2--;
            }

            swap(nums, idx1, idx2);
        }

        reverse(nums, idx1 + 1, n - 1);
    }

    private void swap(int[] arr, int idx1, int idx2) {
        arr[idx1] += arr[idx2];
        arr[idx2] = arr[idx1] - arr[idx2];
        arr[idx1] -= arr[idx2];
    }

    private void reverse(int[] arr, int start, int end) {
        while (start < end) {
            swap(arr, start, end);
            start++;
            end--;
        }
    }
}
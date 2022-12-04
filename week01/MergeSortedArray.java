class Solution {

    // TC = O(m + n) ; where m is the size of nums1 array and n is the size of nums2 array.
    // MC = O(1)

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int firstIdx = m - 1;
        int secondIdx = n - 1;
        int currPos = m + n - 1;

        while (firstIdx >= 0 || secondIdx >= 0) {
            if (firstIdx < 0) {
                nums1[currPos--] = nums2[secondIdx--];
            } else if (secondIdx < 0) {
                nums1[currPos--] = nums1[firstIdx--];
            } else if (nums1[firstIdx] > nums2[secondIdx]) {
                nums1[currPos--] = nums1[firstIdx--];
            } else {
                nums1[currPos--] = nums2[secondIdx--];
            }
        }
    }
}
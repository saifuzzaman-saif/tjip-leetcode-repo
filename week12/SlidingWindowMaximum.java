/**
* TC = O(n); where n is the length of the nums array.
* MC = O(n);
* Problem link : https://leetcode.com/problems/sliding-window-maximum/description/
*/

class Solution {

    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] maximums = new int[n - k + 1];
        Deque<Integer> dq = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            while (!dq.isEmpty() && nums[dq.peekLast()] < nums[i]) {
                dq.pollLast();
            }
            if (!dq.isEmpty() && dq.peekFirst() <= i - k) {
                dq.pollFirst();
            }

            dq.addLast(i);

            if (i >= k - 1) {
                maximums[i - k + 1] = nums[dq.peekFirst()];
            }
        }

        return maximums;
    }
}

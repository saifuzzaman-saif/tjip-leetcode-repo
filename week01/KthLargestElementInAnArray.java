class Solution {

    // TC = O(n Log(k)) ; where n is the size of nums array.
    // MC = O(k)

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int val : nums) {
            pq.add(val);

            if (pq.size() > k) {
                pq.poll();
            }
        }

        return pq.peek();
    }
}
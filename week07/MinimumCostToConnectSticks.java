/**
 * TC = O(n * log(n)); where n is the length of sticks.
 * MC = O(n);
 * Problem Link : https://leetcode.com/problems/minimum-cost-to-connect-sticks/
 */

class Solution {

    public int connectSticks(int[] sticks) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int minCost = 0;

        for (int stick : sticks) {
            pq.add(stick);
        }

        while (pq.size() > 1) {
            int x = pq.poll();  // poll() also returns the element.
            int y = pq.poll();

            minCost += (x + y);
            pq.add(x + y);
        }

        return minCost;
    }
}

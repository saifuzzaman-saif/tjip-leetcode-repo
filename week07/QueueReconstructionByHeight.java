/**
 * TC = O(n^2); where n is the length of people array.
 * MC = O(n);
 * Problem Link : https://leetcode.com/problems/queue-reconstruction-by-height/description/
 */

class Solution {

    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (p1, p2) -> p1[0] == p2[0] ? p1[1] - p2[1] : p2[0] - p1[0]);

        List<int[]> q = new ArrayList<>();

        for (int[] attr : people) {
            q.add(attr[1], attr);
        }

        return q.toArray(new int[0][2]);
    }
}

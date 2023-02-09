/**
 * TC = O(n * log(n)) ; where n is the number of intervals.
 * MC = O(1);
 * Problem link : https://leetcode.com/problems/non-overlapping-intervals/description/
 */

class Solution {

    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (i1, i2) -> i1[1] - i2[1]);
        int cntValidIntervals = 0;
        int prevEnd = Integer.MIN_VALUE;

        for (int[] interval : intervals) {
            if (prevEnd <= interval[0]) {
                prevEnd = interval[1];
                cntValidIntervals++;
            }
        }

        return intervals.length - cntValidIntervals;
    }
}
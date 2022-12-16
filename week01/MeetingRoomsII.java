/**
 * Definition of Interval:
 * public class Interval {
 *     int start, end;
 *     Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

public class Solution {

    // TC = O(n Log(n)) ; Where n is the size of intervals array.
    // MC = O(n);

    public int minMeetingRooms(List<Interval> intervals) {
        Collections.sort(intervals, (a, b) -> a.start - b.start);
        TreeSet<Integer> endTimes = new TreeSet<>();

        for (Interval interval : intervals) {
            if (!endTimes.isEmpty() && interval.start > endTimes.first()) {
                endTimes.pollFirst();
            }

            endTimes.add(interval.end);
        }

        return endTimes.size();
    }
}
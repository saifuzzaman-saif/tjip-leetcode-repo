/**
 * TC = O(n * log(n)) ; where n is the number of intervals.
 * MC = O(n);
 * Problem link : https://leetcode.com/problems/meeting-rooms-ii/
 */

class Solution {
    
    public int minMeetingRooms(int[][] intervals) {
        Map<Integer, Integer> times = new TreeMap<>();
        
        for (int[] interval : intervals) {
            times.put(interval[0], times.getOrDefault(interval[0], 0) + 1);
            times.put(interval[1], times.getOrDefault(interval[1], 0) - 1);
        }
        
        int minRooms = 0, currRooms = 0;
        
        for (Map.Entry entry : times.entrySet()) {
            currRooms += (int) entry.getValue();
            minRooms = Math.max(minRooms, currRooms);
        }
        
        return minRooms;
    }
}

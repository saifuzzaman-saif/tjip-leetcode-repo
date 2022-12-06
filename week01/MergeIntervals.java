class Interval implements Comparable<Interval> {

    int start;
    int end;

    Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public int compareTo(Interval obj) {
        return this.start - obj.start;
    }
}

class Solution {

    // TC = O(n Log(n)) ; where n is the size of intervals array
    // MC = O(n)
    
    public int[][] merge(int[][] intervals) {
        List<Interval> intervalList = new ArrayList<>();

        for (int[] interval : intervals) {
            intervalList.add(new Interval(interval[0], interval[1]));
        }

        Collections.sort(intervalList);
        List<int[]> mergedIntervals = new ArrayList<>();

        for (Interval interval : intervalList) {
            if (!mergedIntervals.isEmpty() && interval.start <= mergedIntervals.get(mergedIntervals.size()-1)[1]) {
                mergedIntervals.get(mergedIntervals.size()-1)[1] = Math.max(mergedIntervals.get(mergedIntervals.size()-1)[1], interval.end);
            } else {
                mergedIntervals.add(new int[]{interval.start, interval.end});
            }
        }

        return mergedIntervals.toArray(new int[mergedIntervals.size()][2]);
    }
}
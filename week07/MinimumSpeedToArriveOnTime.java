/**
 * TC = O(N * log (M)) ; Where N is the length of dist and M is the max speed.
 * MC = O(1)
 * Problem link : https://leetcode.com/problems/minimum-speed-to-arrive-on-time/description/
 */

class Solution {

    private static final int MAX_SPEED = 1_000_000_1;

    public int minSpeedOnTime(int[] dist, double hour) {
        int l = 1, r = MAX_SPEED;

        while (l < r) {
            int m = l + (r - l) / 2;
            double timeNeeded = calcTime(dist, m);

            if (timeNeeded > hour) {
                l = m + 1;
            } else {
                r = m;
            }
        }

        return l < MAX_SPEED ? l : -1;
    }

    private double calcTime(int[] dist, int v) {
        double timeNeeded = 0;

        for (int i = 0; i < dist.length; i++) {
            if (i + 1 == dist.length) {
                timeNeeded += 1.0 * dist[i] / v;
            } else {
                timeNeeded += (dist[i] + v - 1) / v;
            }
        }

        return timeNeeded;
    }
}

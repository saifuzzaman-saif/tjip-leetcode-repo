/**
 * TC = o(n * log(n)) ; where n is number of points given;
 * MC = O(n);
 * Problem link : https://leetcode.com/problems/maximum-number-of-visible-points/description/
 */

class Solution {

    private static final Double MAX_ANG = 360.0;

    public int visiblePoints(List<List<Integer>> points, int angle, List<Integer> location) {
        int pointsAtLocation = 0;
        List<Double> angles = new ArrayList<>();

        for (List<Integer> point : points) {
            if (point.get(0) == location.get(0) && point.get(1) == location.get(1)) {
                pointsAtLocation++;
            } else {
                angles.add(getAngle(point, location));
            }
        }

        Collections.sort(angles);
        int maxVisiblePoints = 0;
        int n = angles.size();

        for (int l = 0, r = 0; l < n; l++) {
            while ((r < n && angles.get(r) - angles.get(l) <= angle) ||
                   (r >= n && MAX_ANG + angles.get(r % n) - angles.get(l) <= angle)) {
                
                r++;
            }
            
            maxVisiblePoints = Math.max(maxVisiblePoints, r - l);
        }

        return maxVisiblePoints + pointsAtLocation;
    }

    private double getAngle(List<Integer> point1, List<Integer> point2) {
        double angle = Math.atan2(point1.get(1) - point2.get(1), point1.get(0) - point2.get(0)) * 180 / Math.PI;
        
        return angle < 0 ? MAX_ANG + angle : angle;
    }
}

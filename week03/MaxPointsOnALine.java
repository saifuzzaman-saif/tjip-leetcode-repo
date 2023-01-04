// TC = O(n^2 log(M)) ; where n is the length of points & M is the max coordinate value;
// MC = O(n);
// Problem link: https://leetcode.com/problems/max-points-on-a-line/description/

class Solution {

    private static final long BASE = 10007;

    public int maxPoints(int[][] points) {
        int n = points.length;

        if (n < 2) {
            return n;
        }

        int maxPointsOnLine = 0;

        for (int i = 0; i < n; i++) {
            Map<Long, Integer>slopes = new HashMap<>();
            
            for (int j = i + 1; j < n; j++) {
                int[] slope = findSlope(points[i], points[j]);
                long hash = getHashVal(slope);
                slopes.put(hash, slopes.getOrDefault(hash, 0) + 1);
                maxPointsOnLine = Math.max(maxPointsOnLine, 1 + slopes.get(hash));
            }
        }

        return maxPointsOnLine;
    }

    private int[] findSlope(int[] pointA, int[] pointB) {
        int dx = pointA[0] - pointB[0];
        int dy = pointA[1] - pointB[1];
        int gcd = findGcd(dx, dy);
        dx /= gcd;
        dy /= gcd;

        return new int[]{dy, dx};
    }

    private int findGcd(int a, int b) {
        return (a == 0) ? b : findGcd(b % a, a);
    }

    private long getHashVal(int[] point) {
        return point[0] * BASE + point[1];
    }
}


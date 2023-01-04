// TC = O(n^2); Where n is the length of points.
// MC = O(n);
// problem link : https://leetcode.com/problems/minimum-area-rectangle/description/

class Solution {

    private static final long BASE = 100007;
    private static final int INF = Integer.MAX_VALUE;

    public int minAreaRect(int[][] points) {
        Map<Long, Integer>pointsMap = new HashMap<>();
        int minArea = INF;

        for (int[] point : points) {
            pointsMap.put(getHash(point), 1);
        }

        for (int[] point : points) {
            int x1 = point[0];
            int y1 = point[1];

            for (Map.Entry<Long, Integer>entry : pointsMap.entrySet()) {
                int x3 = (int) (entry.getKey() / BASE);
                int y3 = (int) (entry.getKey() % BASE);

                if (x1 == x3 || y1 == y3) {
                    continue;
                }
                
                int x2 = x3, y2 = y1;
                int x4 = x1, y4 = y3;

                if (pointsMap.containsKey(getHash(new int[]{x2, y2})) && 
                    pointsMap.containsKey(getHash(new int[]{x4, y4}))) {

                    minArea = Math.min(minArea, getArea(x1, y1, x3, y3));
                }
            }
        }

        minArea = (minArea == INF) ? 0 : minArea;

        return minArea;
    }

    private long getHash(int[] point) {
        return point[0] * BASE + point[1];
    }

    private int getArea(int x1, int y1, int x3, int y3) {
        return Math.abs(x1 - x3) * Math.abs(y1 - y3);
    }
}


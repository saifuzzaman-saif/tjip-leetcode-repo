// TC = O(1) for add & O(N) for count. Where N is the current size of the stream of points.
// MC = O(N)

class DetectSquares {

    Map<Integer, Integer>points;
    private static final int BASE = 1007;

    public DetectSquares() {
        points = new HashMap<>();
    }
    
    public void add(int[] point) {
        int hashVal = getHash(point);
        points.put(hashVal, points.getOrDefault(hashVal, 0) + 1);
    }
    
    public int count(int[] point) {
        int totalSquare = 0;
        int x1 = point[0];
        int y1 = point[1];

        for (Map.Entry<Integer, Integer> entry : points.entrySet()) {
            int x2 = entry.getKey() / BASE;
            int y2 = entry.getKey() % BASE;

            if (x1 != x2 && y1 != y2 && (Math.abs(x1 - x2) == Math.abs(y1 - y2))) {
                int x3 = x2, y3 = y1;
                int x4 = x1, y4 = y2;

                totalSquare += 
                                points.getOrDefault(getHash(new int[]{x2, y2}), 0)
                              * points.getOrDefault(getHash(new int[]{x3, y3}), 0)
                              * points.getOrDefault(getHash(new int[]{x4, y4}), 0);
            }
        }

        return totalSquare;
    }

    private int getHash(int[] point) {
        return point[0] * BASE + point[1];
    }
}

/**
 * Your DetectSquares object will be instantiated and called as such:
 * DetectSquares obj = new DetectSquares();
 * obj.add(point);
 * int param_2 = obj.count(point);
 */
 

/**
 * TC = O(n * m) ; where n x m is the dimension of the matrix.
 * MC = O(n * m);
 * Problem link : https://leetcode.com/problems/longest-increasing-path-in-a-matrix/description/
 */

class Solution {

    Integer[][] dp;
    int[][] matrix;
    int n, m;
    int[] dir = {0, 1, 0, -1, 0};

    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }

        n = matrix.length;
        m = matrix[0].length;
        this.matrix = matrix;
        dp = new Integer[n][m];
        int longestPathLength = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                longestPathLength = Math.max(longestPathLength, longestIncreasingPathHelper(i, j));
            }
        }

        return longestPathLength;
    }

    private int longestIncreasingPathHelper(int x, int y) {
        if (dp[x][y] != null) {
            return dp[x][y];
        }

        int length = 1;
        for (int d = 0; d < 4; d++) {
            int nx = x + dir[d];
            int ny = y + dir[d + 1];

            if (isValid(nx, ny) && matrix[nx][ny] > matrix[x][y]) {
                length = Math.max(length, 1 + longestIncreasingPathHelper(nx, ny));
            }
        }

        return dp[x][y] = length;
    }

    private boolean isValid(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < m;
    }
}

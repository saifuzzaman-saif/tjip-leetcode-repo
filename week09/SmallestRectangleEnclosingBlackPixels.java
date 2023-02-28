/**
 * TC = O(N * M) ; Where N * M is the dimension of image.
 * MC = O(N * M) 
 * Problem link : https://leetcode.com/problems/smallest-rectangle-enclosing-black-pixels/
 */

class Solution {

    int minX, maxX, minY, maxY;
    int[] dir = {0, 1, 0, -1, 0};
    int n, m;

    public int minArea(char[][] image, int x, int y) {
        if (image.length == 0) {
            return 0;
        }

        minX = maxX = x;
        minY = maxY = y;
        n = image.length; m = image[0].length;

        dfs(image, x, y);

        return (maxX - minX + 1) * (maxY - minY + 1);
    }

    private void dfs(char[][] image, int x, int y) {
        minX = Math.min(minX, x);
        maxX = Math.max(maxX, x);
        minY = Math.min(minY, y);
        maxY = Math.max(maxY, y);

        for (int d = 0; d < 4; d++) {
            int nx = x + dir[d];
            int ny = y + dir[d+1];

            if (isValid(nx, ny) && image[nx][ny] == '1') {
                image[x][y] = '0';
                dfs(image, nx, ny);
            }
        }
    }

    private boolean isValid(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < m;
    }
}

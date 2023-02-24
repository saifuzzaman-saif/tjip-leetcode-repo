/**
 * TC = O(N * M) ; Where N is number of rows & M is the number of columns in the grid.
 * MC = O(N * M) required for recursion
 * Problem link : https://leetcode.com/problems/number-of-islands/description/
 */

class Solution {

    int n, m;
    char[][] grid;
    int[] dir = {0, 1, 0, -1, 0};

    public int numIslands(char[][] grid) {
        n = grid.length;
        if (n == 0) {
            return 0;
        }
        m = grid[0].length;
        this.grid = grid;
        int islandCnt = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1') {
                    islandCnt++;
                    dfs(i, j);
                }
            }
        }

        return islandCnt;
    }

    private void dfs(int r, int c) {
        grid[r][c] = '2';

        for (int k = 0; k < 4; k++) {
            int x = r + dir[k];
            int y = c + dir[k+1];

            if (isValid(x, y) && grid[x][y] == '1') {
                dfs(x, y);
            }
        }
    }

    private boolean isValid(int r, int c) {
        return r >= 0 && r < n && c >= 0 && c < m;
    }
}

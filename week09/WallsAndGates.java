/**
 * TC = O(N * M) ; Where N is the number of rows and M is the number of columns.
 * MC = O(N * M) ;
 * Problem link : https://leetcode.com/problems/walls-and-gates/description/
 */

class Solution {

    private int[] dir = {0, 1, 0, -1, 0};

    public void wallsAndGates(int[][] rooms) {
        if (rooms.length == 0) {
            return;
        }

        int n = rooms.length, m = rooms[0].length;
        Queue<Pair> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (rooms[i][j] == 0) {
                    q.add(new Pair(i, j));
                }
            }
        }

        while (!q.isEmpty()) {
            Pair curr = q.poll();
            int x = (int) curr.getKey();
            int y = (int) curr.getValue();

            for (int d = 0; d < 4; d++) {
                int nx = x + dir[d];
                int ny = y + dir[d + 1];

                if (isValid(nx, ny, n, m) && rooms[x][y] + 1 < rooms[nx][ny]) {
                    rooms[nx][ny] = rooms[x][y] + 1;
                    q.add(new Pair(nx, ny));
                }
            }
        }
    }

    private boolean isValid(int x, int y, int n, int m) {
        return x >= 0 && x < n && y >= 0 && y < m;
    }
}

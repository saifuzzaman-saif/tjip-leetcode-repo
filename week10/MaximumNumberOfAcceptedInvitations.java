/**
 * TC = O(N * M^2) ; where N is the number of boys and girls & M is the number of invitations.
 * MC = O(N); 
 * Problem link : https://leetcode.com/problems/maximum-number-of-accepted-invitations/description/
 */

class Solution {

    public int maximumInvitations(int[][] grid) {
        Flow flow = new Flow(grid);

        return flow.run();
    }

    private class Flow {

        int source, sink;
        int[][] adjMatrix, grid;
        int[] par;

        Flow(int[][] grid) {
            this.grid = grid;
        }

        public int run() {
            initializeAdjMatrix();

            int totFlow = 0;
            par = new int[sink+1];

            while (bfs()) {
                int v = sink, minCap = Integer.MAX_VALUE;
                while (v != source) {
                    int u = par[v];
                    minCap = Math.min(minCap, adjMatrix[u][v]);
                    v = u;
                }

                v = sink;
                while (v != source) {
                    int u = par[v];
                    adjMatrix[u][v] -= minCap;
                    adjMatrix[v][u] += minCap;
                    v = u;
                }

                totFlow += minCap;
            }

            return totFlow;
        }

        private boolean bfs() {
            Queue<Integer> q = new LinkedList<>();
            boolean[] vis = new boolean[sink + 1];
            q.add(source);
            vis[source] = true;

            while (!q.isEmpty()) {
                int u = q.poll();

                for (int v = 0; v <= sink; v++) {
                    if (!vis[v] && v != u && adjMatrix[u][v] > 0) {
                        q.add(v);
                        par[v] = u;
                        vis[v] = true;
                    }
                }
            }

            return vis[sink];
        }

        private void initializeAdjMatrix() {
            int m = grid.length, n = grid[0].length;
            source = 0; sink = m + n + 1;
            adjMatrix = new int[sink + 1][sink + 1];

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    int u = i + 1, v = m + j + 1;
                    adjMatrix[u][v] = grid[i][j];
                }
            }

            for (int i = 0; i < m; i++) {
                adjMatrix[source][i + 1] = 1;
            }
            for (int i = 0; i < n; i++) {
                adjMatrix[m + i + 1][sink] = 1;
            }
        }
    }
}
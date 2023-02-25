/**
 * TC = O(N) ; Where N is number of employees.
 * MC = O(N) to store the graph
 * Problem link : https://leetcode.com/problems/time-needed-to-inform-all-employees/description/
 */

class Solution {

    private List<List<Integer>> adjList;
    private int[] informTime;

    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        this.informTime = informTime;
        buildGraph(n, manager);

        return dfs(headID);
    }

    private int dfs(int curr) {
        int mxTimeNeeded = 0;

        for (int next : adjList.get(curr)) {
            mxTimeNeeded = Math.max(mxTimeNeeded, dfs(next));
        }

        return mxTimeNeeded + informTime[curr];
    }

    private void buildGraph(int n, int[] manager) {
        adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            int mngr = manager[i];

            if (mngr != -1) {
                adjList.get(mngr).add(i);
            }
        }
    }
}

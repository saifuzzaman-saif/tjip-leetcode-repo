/**
 * TC = O(N + E) ; Where N is number of courses & E is the number of prerequisites.
 * MC = O(N + E)
 * Problem link : https://leetcode.com/problems/course-schedule/description/
 */

class Solution {

    private enum Color {WHITE, GRAY, BLACK}
    private List<List<Integer>> adjList;
    private Color[] color;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        color = new Color[numCourses];
        Arrays.fill(color, Color.WHITE);

        buildGraph(numCourses, prerequisites);

        for (int course = 0; course < numCourses; course++) {
            if (color[course] == Color.WHITE && isCyclic(course)) {
                return false;
            }
        }

        return true;
    }

    private boolean isCyclic(int curr) {
        color[curr] = Color.GRAY;

        for (int next : adjList.get(curr)) {
            if (color[next] == Color.GRAY) {
                return true;

            } else if (color[next] == Color.WHITE && isCyclic(next)) {
                return true;
            }
        }

        color[curr] = Color.BLACK;
        return false;
    }

    private void buildGraph(int numCourses, int[][] prerequisites) {
        adjList = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int[] prerequisite : prerequisites) {
            adjList.get(prerequisite[1]).add(prerequisite[0]);
        }
    }
}

/**
 * // This is the robot's control interface.
 * // You should not implement it, or speculate about its implementation
 * interface Robot {
 *     // Returns true if the cell in front is open and robot moves into the cell.
 *     // Returns false if the cell in front is blocked and robot stays in the current cell.
 *     public boolean move();
 *
 *     // Robot will stay in the same cell after calling turnLeft/turnRight.
 *     // Each turn will be 90 degrees.
 *     public void turnLeft();
 *     public void turnRight();
 *
 *     // Clean the current cell.
 *     public void clean();
 * }
 */

 /**
 * TC = o(n) ; where n is the number of empty cells in the room.
 * MC = O(n);
 * Problem link : https://leetcode.com/problems/robot-room-cleaner/description/
 */

class Solution {

    private int[] d = {0, 1, 0, -1, 0};
    Set<Pair<Integer,Integer>> vis;

    void goBack(Robot robot) {
        robot.turnLeft();
        robot.turnLeft();
        robot.move();
        robot.turnRight();
        robot.turnRight();
    }

    public void cleanRoom(Robot robot) {
        vis = new HashSet<>();
        dfs(0, 0, 0, robot);
    }

    private void dfs(int x, int y, int dir, Robot robot) {
        robot.clean();
        vis.add(new Pair(x,y));

        for (int i = 0; i < 4; i++) {
            int nDir = (dir + i) % 4;
            int nx = x + d[nDir];
            int ny = y + d[nDir + 1];

            if (!vis.contains(new Pair(nx,ny)) && robot.move()) {
                dfs(nx, ny, nDir, robot);
                goBack(robot);
            }

            robot.turnLeft();
        }
    }
}

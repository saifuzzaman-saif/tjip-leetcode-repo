/**
 * TC = O(N*M) ; Where N*M is the dimension of board.
 * MC = O(1) ;
 * Problem link : https://leetcode.com/problems/battleships-in-a-board/description/
 */

class Solution {

    public int countBattleships(char[][] board) {
        if (board.length == 0) {
            return 0;
        }

        int n = board.length, m = board[0].length;
        int cntBattleship = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == '.') {
                    continue;
                }

                boolean isLeftEmpty = (j == 0 || board[i][j-1] == '.');
                boolean isTopEmpty = (i == 0 || board[i-1][j] == '.');

                cntBattleship += (isLeftEmpty && isTopEmpty) ? 1 : 0;
            }
        }

        return cntBattleship;
    }
}

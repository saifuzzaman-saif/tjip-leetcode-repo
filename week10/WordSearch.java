/**
 * TC = o(N * 3^L) ; where N is number of cells in the board and L is the length of word.
 * MC = O(L); requred for recursion depth.
 * Problem link : https://leetcode.com/problems/word-search/description/
 */

class Solution {

    int[] dir = {0, 1, 0, -1, 0};
    int n, m;

    public boolean exist(char[][] board, String word) {
        n = board.length;
        m = board[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(backtrack(i, j, 0, board, word)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean backtrack(int x, int y, int l, char[][] board, String word) {
        if (l >= word.length()) {
            return true;
        }

        if (!isValid(x, y) || board[x][y] != word.charAt(l)) {
            return false;
        }

        char c = board[x][y];
        board[x][y] = 'x';
        for (int d = 0; d < 4; d++) {
            int nx = x + dir[d];
            int ny = y + dir[d+1];

            if (backtrack(nx, ny, l+1, board, word)) {
                return true;
            }
        }

        board[x][y] = c;
        return false;
    }

    private boolean isValid(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < m;
    }
}

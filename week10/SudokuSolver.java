/**
 * TC = O(9^m) ; where m is the number of empty cells.
 * MC = O(1); As board size is always constant i.e. 9 x 9.
 * Problem link : https://leetcode.com/problems/sudoku-solver/description/
 */

class Solution {

    private int n = 3;
    private int N = n * n;
    private int[][] grid;
    private boolean[][] rowFlag;
    private boolean[][] colFlag;
    private boolean[][][] subGridFlag;
    private boolean isSudokuSolved;

    public void solveSudoku(char[][] board) {
        grid = new int[N][N];
        isSudokuSolved = false;
        rowFlag = new boolean[N][N+1];
        colFlag = new boolean[N][N+1];
        subGridFlag = new boolean[n][n][N+1];
        initializeGridAndFlags(board);

        backtrack(0, 0);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                board[i][j] = (char) (grid[i][j] + '0');
            }
        }
    }

    private void backtrack(int i, int j) {
        if (i >= N) {
            isSudokuSolved = true;
            return;
        }

        int ni = i, nj = j + 1;
        if (nj == N) {
            ni++; nj = 0;
        }

        if (grid[i][j] == 0) {
            for (int val = 1; val <= N; val++) {
                if (!isValidPlacement(i, j, val)) continue;

                makePlacement(i, j, val);

                backtrack(ni, nj);

                if (!isSudokuSolved) removePlacement(i, j, val);
            }

        } else {
            backtrack(ni, nj);
        }
    }

    private boolean isValidPlacement(int i, int j, int val) {
        return !rowFlag[i][val] && !colFlag[j][val] && !subGridFlag[i/n][j/n][val];
    }

    private void initializeGridAndFlags(char[][] board) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] != '.') {
                    makePlacement(i, j, board[i][j] - '0');
                }
            }
        }
    }

    private void makePlacement(int i, int j, int val) {
        grid[i][j] = val;
        rowFlag[i][val] = true;
        colFlag[j][val] = true;
        subGridFlag[i/n][j/n][val] = true;
    }

    private void removePlacement(int i, int j, int val) {
        grid[i][j] = 0;
        rowFlag[i][val] = false;
        colFlag[j][val] = false;
        subGridFlag[i/n][j/n][val] = false;
    }
}

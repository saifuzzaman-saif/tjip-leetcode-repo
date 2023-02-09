/**
 * TC = O(log(m*n)) ; where m and n are the number rows and columns respectivly. 
 * MC = O(1);
 * Problem link : https://leetcode.com/problems/search-a-2d-matrix/description/
 */

class Solution {

    public boolean searchMatrix(int[][] matrix, int target) {
        int numRows = matrix.length, numCols = matrix[0].length;
        int l = 0, r = numRows * numCols - 1;

        while (l <= r) {
            int m = l + (r - l) / 2;
            int x = m / numCols, y = m % numCols;

            if (matrix[x][y] == target) {
                return true;
            } else if (matrix[x][y] > target) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }

        return false;
    }
}
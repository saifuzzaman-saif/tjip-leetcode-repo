/**
 * TC = O(n^2) ; where n is the length of the string.
 * MC = O(n^2);
 * Problem link : https://leetcode.com/problems/longest-palindromic-substring/description/
 */

class Solution {

    Boolean[][] dp;
    String s;

    public String longestPalindrome(String s) {
        this.s = s;
        int n = s.length();
        dp = new Boolean[n][n];

        int mxLen = 0, startIdx = -1;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (isPalindromic(i, j) && j - i + 1 > mxLen) {
                    mxLen = j - i + 1;
                    startIdx = i;
                }
            }
        }

        return s.substring(startIdx, startIdx + mxLen);
    }

    private boolean isPalindromic(int i, int j) {
        if (i >= j) {
            return true;
        }
        if (dp[i][j] != null) {
            return dp[i][j];
        }

        if (s.charAt(i) == s.charAt(j)) {
            return dp[i][j] = isPalindromic(i + 1, j - 1);
        }

        return dp[i][j] = false;
    }
}

/**
 * TC = O(n * m) ; where n is the length of string s and m is the length of pattern p.
 * MC = O(n * m);
 * Problem link : https://leetcode.com/problems/wildcard-matching/description/
 */

class Solution {

    String s, p;
    Boolean[][] dp;

    public boolean isMatch(String s, String p) {
        this.s = s;
        this.p = p;
        dp = new Boolean[s.length()][p.length()];

        return isMatch(0, 0);
    }

    private boolean isMatch(int i, int j) {
        if (i >= s.length() && j >= p.length()) {
            return true;
        }
        if (j < p.length() && p.substring(j, p.length()).chars().allMatch(c -> c == '*')) {
            return true;
        }
        if (i >= s.length() || j >= p.length()) {
            return false;
        }
        if (dp[i][j] != null) {
            return dp[i][j];
        }

        if (p.charAt(j) == '?' || p.charAt(j) == s.charAt(i)) {
            return dp[i][j] = isMatch(i + 1, j + 1);
        } else if (p.charAt(j) == '*') {
            return dp[i][j] = isMatch(i + 1, j) || isMatch(i, j + 1);
        } else {
            return dp[i][j] = false;
        }
    }
}

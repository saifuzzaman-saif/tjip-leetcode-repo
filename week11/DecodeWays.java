/**
 * TC = O(n) ; where n is the length of string s.
 * MC = O(n);
 * Problem link : https://leetcode.com/problems/decode-ways/description/
 */

class Solution {

    Integer[] dp;
    String s;
    private static final int MAX_VAL = 26;

    public int numDecodings(String s) {
        this.s = s;
        dp = new Integer[s.length()];

        return calNumDecodings(0);
    }

    private int calNumDecodings(int i) {
        if (i >= s.length()) {
            return 1;
        }
        if (s.charAt(i) == '0') {
            return 0;
        }
        if (dp[i] != null) {
            return dp[i];
        }

        int ways = calNumDecodings(i + 1);
        if (i + 1 < s.length() && Integer.parseInt(s.substring(i, i + 2)) <= MAX_VAL) {
            ways += calNumDecodings(i + 2);
        }

        return dp[i] = ways;
    }
}

// TC = O(|s|)
// MC = O(1)
// problem link: https://leetcode.com/problems/string-to-integer-atoi/description/

class Solution {

    public int myAtoi(String s) {
        int currIdx = 0, n = s.length();
        boolean isNegative = false;
        long val = 0;

        if (n == 0) {
            return 0;
        }

        while (currIdx < n && s.charAt(currIdx) == ' ') {
            currIdx++;
        }

        if (currIdx < n && s.charAt(currIdx) == '-') {
            isNegative = true;
            currIdx++;
        } else if (currIdx < n && s.charAt(currIdx) == '+') {
            currIdx++;
        }

        while (currIdx < n) {
            if (!isDigit(s.charAt(currIdx)) || val > Integer.MAX_VALUE) {
                break;
            }

            val = val * 10 + s.charAt(currIdx) - '0';
            currIdx++;
        }

        if (isNegative) {
            val = -val;
        }

        if (val > Integer.MAX_VALUE) {
            val = Integer.MAX_VALUE;
        } else if (val < Integer.MIN_VALUE) {
            val = Integer.MIN_VALUE;
        }

        return (int) val;
    }

    boolean isDigit(char c) {
        return c >= '0' && c <= '9';
    }
}

/**
 * TC = O(n) ; where n is the given integer.
 * MC = O(n);
 * Problem link : https://leetcode.com/problems/student-attendance-record-ii/description/
 */

class Solution {

    private static final int MOD = 1_000_000_007;
    Integer[][][][] dp;

    public int checkRecord(int n) {
        dp = new Integer[n][2][3][2];

        return checkRecordHelper(n - 1, 0, 0, 0);
    }

    private int checkRecordHelper(int i, int Acnt, int Lcnt, int isPrevDayLate) {
        if (Acnt > 1) {
            return 0;
        }
        if (Lcnt > 2) {
            return 0;
        }
        if (i < 0) {
            return 1;
        }
        if (dp[i][Acnt][Lcnt][isPrevDayLate] != null) {
            return dp[i][Acnt][Lcnt][isPrevDayLate];
        }

        int ways = checkRecordHelper(i - 1, Acnt, 0, 0) % MOD;  // Present at i^th day

        ways = (ways + checkRecordHelper(i - 1, Acnt + 1, 0, 0)) % MOD;  // Absent at i^th day

        ways = (ways + checkRecordHelper(i - 1, Acnt, isPrevDayLate == 1 ? Lcnt + 1 : 1, 1)) % MOD;  // Late at i^th day

        return dp[i][Acnt][Lcnt][isPrevDayLate] = ways;
    }
}

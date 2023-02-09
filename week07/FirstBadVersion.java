/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

/*
 * TC = O(logN) ; where N is the number of total versions;
 * MC = O(1)
 * Problem link : https://leetcode.com/problems/first-bad-version/description/
 */

public class Solution extends VersionControl {

    public int firstBadVersion(int n) {
        int l = 1, r = n;

        while (l < r) {
            int m = l + (r - l) / 2;

            if (!isBadVersion(m)) {
                l = m + 1;
            } else {
                r = m;
            }
        }

        return l;
    }
}

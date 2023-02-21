/**
 * TC = O(log(n)); where n is the given number.
 * MC = O(1)
 * Problem link :  https://leetcode.com/problems/factorial-trailing-zeroes/description/
 */

class Solution {

    public int trailingZeroes(int n) {
        int zeroCnt = 0;
        
        while (n > 0) {
            n /= 5;
            zeroCnt += n;
        }

        return zeroCnt;
    }
}

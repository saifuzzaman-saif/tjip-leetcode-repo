/**
 * TC = O(log(|n|));
 * MC = O(1)
 * Problem link : https://leetcode.com/problems/powx-n/submissions/
 */

class Solution {
    
    public double myPow(double x, int n) {
        return binExpo(x, n);
    }
    
    private double binExpo(double x, long n) {
        if (n < 0) {
            x = 1 / x;
            n = Math.abs(n);
        }
        
        double pwr = 1;
        
        while (n > 0) {
            if (n % 2 == 1) pwr *= x;
            x *= x;
            n >>= 1;
        }
        
        return pwr;
    }
}

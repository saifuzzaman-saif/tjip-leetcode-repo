/**
 * TC = O(number of iterations);
 * MC = O(1)
 * Problem link :  https://leetcode.com/problems/sqrtx/description/
 */

class Solution {
    
    private static final int ITERATIONS = 20;
    
    public int mySqrt(int x) {
        double root = x;
        
        for (int itr = 0; itr < ITERATIONS; itr++) {
            root = (root + x * 1.0 / root) / 2;
        }
        
        return (int) root;
    }
}

/**
 * TC = O(log(primeFactors))
 * MC = O(1);
 * Problem link : https://leetcode.com/problems/maximize-number-of-nice-divisors/description/
 */

class Solution {

    private static final int MOD = 1_000_000_007;

    public int maxNiceDivisors(int primeFactors) {
        if (primeFactors == 1) {
            return 1;
        } else if (primeFactors % 3 == 0) {
            return (int) pow(3, primeFactors / 3);
        } else if (primeFactors % 3 == 1) {
            return (int) (pow(3, (primeFactors - 4) / 3) * 4 % MOD);
        } else {
            return (int) (pow(3, (primeFactors - 2) / 3) * 2 % MOD);
        }
    }

    private long pow(long a, long b) {
        long ret = 1;

        while (b > 0) {
            if ((b & 1) > 0) ret = (ret * a) % MOD;
            a = (a * a) % MOD;
            b >>= 1;
        }

        return ret;
    }
}

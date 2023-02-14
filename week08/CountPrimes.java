/**
 * TC = O(sqrt(n) log(log(n))); where n is the given integer.
 * MC = O(n)
 * Problem link :  https://leetcode.com/problems/count-primes/description/
 */

class Solution {

    boolean[] isPrime;

    public int countPrimes(int n) {
        if (n <= 2) {
            return 0;
        }

        isPrime = new boolean[n];
        sieve(n);

        int primeCnt = 0;
        for (int i = 0; i < n; i++) {
            primeCnt += isPrime[i] ? 1 : 0;
        }

        return primeCnt;
    }

    private void sieve(int n) {
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;

        for (int i = 4; i < n; i += 2) {
            isPrime[i] = false;
        }

        for (int i = 2; i * i < n; i++) {
            if (isPrime[i]) {
                for (int j = i*i; j < n; j += 2 * i) {
                    isPrime[j] = false;
                }
            }
        }
    }
}

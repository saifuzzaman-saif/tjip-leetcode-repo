// TC = O(n*m); Where n is the size of dict and m is the length dict[i].
// MC = O(M); where m is total number of characters in dict.
// Problem link : https://leetcode.com/problems/strings-differ-by-one-character/description/

class Solution {

    private static final int N = 1_000_09;
    private static final long BASE = 997L;
    private static final long MOD = 1_000_000_000_7L;
    private static long[] powers;
    private static long[] prefixHash;

    public boolean differByOne(String[] dict) {
        init();
        Map<Long, Integer> hashes = new HashMap<>();

        for (String s : dict) {
            calculatePrefixHash(s);

            for (int i = 1; i <= s.length(); i++) {
                long hashVal = getHashAfterReplacingAt(i, s.length());

                if (hashes.containsKey(hashVal)) {
                    return true;
                }

                hashes.put(hashVal, 1);
            }
        }

        return false;
    }

    private long getHashAfterReplacingAt(int idx, int sz) {
        long hashVal = prefixHash[idx-1];
        hashVal = (hashVal * BASE + '#') % MOD;
        hashVal = (hashVal * powers[sz-idx] % MOD + getSubstringHash(idx+1, sz)) % MOD;

        return hashVal;
    }

    private long getSubstringHash(int l, int r) {
        return (prefixHash[r] - (prefixHash[l-1] * powers[r - l + 1] % MOD) + MOD) % MOD;
    }

    private void calculatePrefixHash(String s) {
        int n = s.length();
        prefixHash = new long[n+2];
        prefixHash[0] = prefixHash[n+1] = 0;

        for (int i = 1; i <= n; i++) {
            prefixHash[i] = (prefixHash[i-1] * BASE + s.charAt(i-1)) % MOD;
        }
    }

    private void init() {
        powers = new long[N];
        powers[0] = 1;

        for (int i = 1; i < N; i++) {
            powers[i] = (powers[i-1] * BASE) % MOD;
        }
    }
}


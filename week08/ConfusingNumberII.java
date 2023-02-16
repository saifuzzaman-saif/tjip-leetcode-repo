/**
 * TC = O(5 ^ log10(n)) ; where n is the given number.
 * MC = O(log10(n)) required for recursion.
 * Problem link : https://leetcode.com/problems/confusing-number-ii/description/
 */

class Solution {

    private static Map<Integer, Integer> mirrors = new HashMap<>();
    private static final int TENS = 10;
    int[] validDigits = {0, 1, 6, 8, 9};
    int cnt;

    static {
        mirrors.put(0, 0);
        mirrors.put(1, 1);
        mirrors.put(6, 9);
        mirrors.put(8, 8);
        mirrors.put(9, 6);
    }

    public int confusingNumberII(int n) {
        cnt = 0;
        
        bktk(0, n, true);

        return cnt;
    }

    private void bktk(int curr, int n, boolean isLeadingZero) {
        if (isConfusing(curr)) {
            cnt++;
        }

        for (int dgt : validDigits) {
            if (dgt == 0 && isLeadingZero) {
                continue;
            }

            if (curr <= (n - dgt) / TENS) {
                bktk(curr * TENS + dgt, n, false);
            }
        }
    }

    private boolean isConfusing(int val) {
        int rotatedVal = 0, original = val;

        while (val > 0) {
            int lastDgt = val % TENS;

            if (!mirrors.containsKey(lastDgt)) {
                return false;
            }

            rotatedVal = rotatedVal * TENS + mirrors.get(lastDgt);
            val /= TENS;
        }

        return original != rotatedVal;
    }
}

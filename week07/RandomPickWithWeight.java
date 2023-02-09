/*
 * TC = O(log(n)) ; where n is the length of array w.
 * MC = O(1); used the same referance of w as prefSum
 * Problem link : https://leetcode.com/problems/random-pick-with-weight/description/
 */

class Solution {

    int[] prefSum;
    Random rand;

    public Solution(int[] w) {
        rand = new Random();
        prefSum = w;

        for (int i = 1; i < w.length; i++) {
            prefSum[i] = prefSum[i-1] + w[i];
        }
    }
    
    public int pickIndex() {
        int x = 1 + rand.nextInt(prefSum[prefSum.length-1]);
        int l = 0, r = prefSum.length - 1;

        while (l < r) {
            int m = l + (r - l) / 2;

            if (prefSum[m] < x) {
                l = m + 1;
            } else {
                r = m;
            }
        }

        return l;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */

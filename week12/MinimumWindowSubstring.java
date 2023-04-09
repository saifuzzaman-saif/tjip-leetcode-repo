/**
* TC = O(m + n); where m is the length string s & n is the length of t.
* MC = O(1);
* Problem link : https://leetcode.com/problems/minimum-window-substring/
*/

class Solution {

    public String minWindow(String s, String t) {
        int m = s.length();
        int[] freqS = new int[256];
        int[] freqT = new int[256];
        int uniqCharsInT = 0;

        for (char c : t.toCharArray()) {
            freqT[c]++;
            uniqCharsInT += freqT[c] == 1 ? 1 : 0;
        }

        int left = -1, right = -1, minLength = -1;
        int charsWithMinFreq = 0;
        for (int l = 0, r = 0; r < m; r++) {
            char c = s.charAt(r);
            freqS[c]++;
            charsWithMinFreq += freqS[c] == freqT[c] ? 1 : 0;

            while (l <= r && charsWithMinFreq == uniqCharsInT) {
                if (minLength == -1 || minLength > r - l + 1) {
                    minLength = r - l + 1;
                    left = l; right = r;
                }

                c = s.charAt(l);
                freqS[c]--;
                charsWithMinFreq -= (freqS[c] == freqT[c] - 1) ? 1 : 0; 
                l++;
            }
        }

        return minLength == -1 ? "" : s.substring(left, right + 1);
    }
}

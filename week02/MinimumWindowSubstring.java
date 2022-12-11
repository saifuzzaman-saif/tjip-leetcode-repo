// TC = O(|s| + |t|) ; where |s| is the length of string s.
// MC = O(1)
// problem link : https://leetcode.com/problems/minimum-window-substring/

class Solution {

    public String minWindow(String s, String t) {
        int[] freqS = new int[256];
        int[] freqT = new int[256];
        int uniqueCharsInT = 0;
        
        for (int i = 0; i < t.length(); i++) {
            freqT[t.charAt(i)]++;
            uniqueCharsInT += (freqT[t.charAt(i)] == 1) ? 1 : 0;
        }

        int l = 0, r = 0, cntCharsWithMinFreq = 0;
        int minLength = -1, left = -1, right = -1;

        while (r < s.length()) {
            freqS[s.charAt(r)]++;
            cntCharsWithMinFreq += (freqS[s.charAt(r)] == freqT[s.charAt(r)]) ? 1 : 0;

            while (l <= r && cntCharsWithMinFreq == uniqueCharsInT) {
                if(minLength == -1 || r - l + 1  < minLength) {
                    minLength = r - l + 1;
                    left = l;
                    right = r;
                }

                freqS[s.charAt(l)]--;
                cntCharsWithMinFreq += (freqS[s.charAt(l)] == freqT[s.charAt(l)] - 1) ? -1 : 0;

                l++;
            }

            r++;
        }

        return minLength == -1 ? "" : s.substring(left, right + 1);
    }
}
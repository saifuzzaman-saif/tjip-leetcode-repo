// TC = O(n) ;  Where n is the length of string s.
// MC = O(1)
// problem link : https://leetcode.com/problems/longest-substring-with-at-least-k-repeating-characters/

class Solution {

    public int longestSubstring(String s, int k) {
        int maxLength = 0;

        for (int uniqChars = 1; uniqChars <= 26; uniqChars++) {
            maxLength = Math.max(maxLength, findLongestSubstringWithUniqChars(s, uniqChars, k));
        }

        return maxLength;
    }

    private int findLongestSubstringWithUniqChars(String s, int uniqChars, int k) {
        int maxLength = 0, uniqCharsInWindow = 0, cntCharsWithMinFreqK = 0;
        int left = 0, right = 0;
        int[] freq = new int[26];

        while (right < s.length()) {
            int chR = s.charAt(right) - 'a';
            freq[chR]++;
            uniqCharsInWindow += (freq[chR] == 1) ? 1 : 0;
            cntCharsWithMinFreqK += (freq[chR] == k) ? 1 : 0;

            while (left <= right && uniqCharsInWindow > uniqChars) {
                int chL = s.charAt(left) - 'a';
                freq[chL]--;
                uniqCharsInWindow += (freq[chL] == 0) ? -1 : 0;
                cntCharsWithMinFreqK += (freq[chL] == k - 1) ? -1 : 0;
                left++;
            }

            if (uniqCharsInWindow == uniqChars && cntCharsWithMinFreqK == uniqChars) {
                maxLength = Math.max(maxLength, right - left + 1);
            }

            right++;
        }

        return maxLength;
    }
}
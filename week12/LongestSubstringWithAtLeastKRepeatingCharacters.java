/**
* TC = O(n); where n is the length of the string s.
* MC = O(1); where k is the given integer.
* Problem link : https://leetcode.com/problems/longest-substring-with-at-least-k-repeating-characters/description/
*/

class Solution {

    public int longestSubstring(String s, int k) {
        int length = 0;

        for (int uniqCharsAllowed = 0; uniqCharsAllowed < 26; uniqCharsAllowed++) {
            length = Math.max(length, findLongestSubstrWithUniqChars(s, uniqCharsAllowed, k));
        }

        return length;
    }

    private int findLongestSubstrWithUniqChars(String s, int uniqCharsAllowed, int k) {
        int maxLength = 0;
        int[] frq = new int[26];
        int uniqCharsInWindow = 0, charsWithMinFrq = 0;

        for (int left = 0, right = 0; right < s.length(); right++) {
            int c = s.charAt(right) - 'a';
            frq[c]++;
            uniqCharsInWindow += frq[c] == 1 ? 1 : 0;
            charsWithMinFrq += frq[c] == k ? 1 : 0;

            while (left <= right && uniqCharsInWindow > uniqCharsAllowed) {
                c = s.charAt(left) - 'a';
                frq[c]--;
                uniqCharsInWindow -= frq[c] == 0 ? 1 : 0;
                charsWithMinFrq -= frq[c] == k - 1 ? 1 : 0;
                left++;
            }

            if (uniqCharsInWindow == uniqCharsAllowed && charsWithMinFrq == uniqCharsAllowed) {
                maxLength = Math.max(maxLength, right - left + 1);
            }
        }

        return maxLength;
    }
}

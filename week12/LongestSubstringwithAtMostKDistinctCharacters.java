/**
* TC = O(n); where n is the length of string s.
* MC = O(1);
* Problem link : https://leetcode.com/problems/longest-substring-with-at-most-k-distinct-characters/
*/

class Solution {

    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int[] freq = new int[256];
        int maxLength = 0, uniqChars = 0;

        for (int l = 0, r = 0; r < s.length(); r++) {
            freq[s.charAt(r)]++;
            uniqChars += freq[s.charAt(r)] == 1 ? 1 : 0;

            while (uniqChars > k) {
                freq[s.charAt(l)]--;
                uniqChars -= freq[s.charAt(l)] == 0 ? 1 : 0;
                l++;
            }

            maxLength = Math.max(maxLength, r - l + 1);
        }

        return maxLength;
    }
}

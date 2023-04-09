/**
* TC = O(n); where n is the length of string s.
* MC = O(1);
* Problem link : https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
*/

class Solution {

    public int lengthOfLongestSubstring(String s) {
        int[] freq = new int[256];
        int length = 0, kAllowed = 1;

        for (int l = 0, r = 0; r < s.length(); r++) {
            freq[s.charAt(r)]++;

            while (freq[s.charAt(r)] > kAllowed) {
                freq[s.charAt(l)]--;
                l++;
            }

            length = Math.max(length, r - l + 1);
        }

        return length;
    }
}

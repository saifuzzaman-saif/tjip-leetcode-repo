class Solution {

    // TC = O(n) ; where n is the length of the string.
    // MC = O(1)

    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int maxLength = 0;
        int[] freq = new int[256];
        int kAllowed = 1;

        for (int left = 0, right = 0; right < n; right++) {
            freq[s.charAt(right)]++;

            while (freq[s.charAt(right)] > kAllowed) {
                freq[s.charAt(left)]--;
                left++;
            }

            if (right - left + 1 > maxLength) {
                maxLength = right - left + 1;
            }
        }

        return maxLength;
    }
}
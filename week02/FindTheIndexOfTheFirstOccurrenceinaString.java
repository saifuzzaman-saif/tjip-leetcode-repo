class Solution {

    // TC = O(|haystack| + |needle|) ; |haystack| is the length of haystack.
    // MC = O(|needle|)

    int[] pi;

    public int strStr(String haystack, String needle) {
        prefixFunction(needle);
        int now = -1;

        for (int i = 0; i < haystack.length(); i++) {
            while (now != -1 && needle.charAt(now + 1) != haystack.charAt(i)) {
                now = pi[now];
            }

            if (needle.charAt(now + 1) == haystack.charAt(i)) {
                ++now;
            } else {
                now = -1;
            }

            if (now == needle.length() - 1) {
                return i - needle.length() + 1;
            }
        }

        return -1;
    }

    private void prefixFunction(String needle) {
        pi = new int[needle.length()];
        int now = -1; pi[0] = -1;

        for (int i = 1; i < needle.length(); i++) {
            while (now != -1 && needle.charAt(now+1) != needle.charAt(i)) {
                now = pi[now];
            }

            if (needle.charAt(now+1) == needle.charAt(i)) {
                pi[i] = ++now;
            } else {
                pi[i] = now = -1;
            }
        }
    }
}

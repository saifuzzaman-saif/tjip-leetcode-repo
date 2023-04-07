/**
* TC = O(M + (N * L)); where M is total number of characters in words, 
*                      N is the length of string s & L is max length of word;
* MC = O(M + N);
* Problem link : https://leetcode.com/problems/word-break/description/
*/

class Solution {

    private static final int LMT = 26;
    private static final int mxWordLen = 20;
    private TrieNode root;
    private Boolean[] dp;
    private String s;

    class TrieNode {
        boolean isEnd;
        TrieNode[] next;

        TrieNode() {
            isEnd = false;
            next = new TrieNode[LMT];
        }
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        root = new TrieNode();

        for (String word : wordDict) {
            insert(word);
        }

        dp = new Boolean[s.length()];
        this.s = s;

        return recur(0);
    }

    private Boolean recur(int idx) {
        if (idx == s.length()) {
            return true;
        }

        if (dp[idx] != null) {
            return dp[idx];
        }

        TrieNode curr = root;
        Boolean isPossible = false;

        for (int i = 0; i < mxWordLen && i + idx < s.length(); i++) {
            int ch = s.charAt(idx + i) - 'a';
            if (curr.next[ch] == null) {
                break;
            }

            curr = curr.next[ch];

            if (curr.isEnd) {
                isPossible |= recur(idx + i + 1);
            }
        }

        return dp[idx] = isPossible;
    }

    private void insert(String word) {
        TrieNode curr = root;

        for (char c : word.toCharArray()) {
            int idx = c - 'a';

            if (curr.next[idx] == null) {
                curr.next[idx] = new TrieNode();
            }

            curr = curr.next[idx];
        }

        curr.isEnd = true;
    }
}

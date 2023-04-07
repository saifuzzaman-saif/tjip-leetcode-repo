/**
 * TC = O(n * l^2) ; where n is the length of words and l is the average length of each word.
 * MC = O(n);
 * Problem link : https://leetcode.com/problems/longest-string-chain/description/
 */

class Solution {
    List<List<Integer>> adj;
    Integer[] dp;

    private int findLongestChain(int curr) {
        if (dp[curr] != null) {
            return dp[curr];
        }

        int length = 1;
        for (int next : adj.get(curr)) {
            length = Math.max(length, 1 + findLongestChain(next));
        }

        return dp[curr] = length;
    }

    private void buildPredecessorGraphFrom(String[] words) {
        int n = words.length;
        adj = new ArrayList<>();
        Map<String, Integer> wordsMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
            wordsMap.put(words[i], i);
        }

        for (int i = 0; i < n; i++) {
            String word = words[i];
            int len = word.length();

            for (int j = 0; j < len; j++) {
                String newWord = word.substring(0, j) + word.substring(j + 1, len);
                if (wordsMap.containsKey(newWord)) {
                    adj.get(wordsMap.get(newWord)).add(i);
                }
            }
        }
    }

    public int longestStrChain(String[] words) {
        int n = words.length;
        dp = new Integer[n];
        int longestChainLength = 0;
        buildPredecessorGraphFrom(words);

        for (int i = 0; i < n; i++) {
            longestChainLength = Math.max(longestChainLength, findLongestChain(i));
        }

        return longestChainLength;
    }
}

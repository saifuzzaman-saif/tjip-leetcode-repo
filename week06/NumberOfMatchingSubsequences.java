// TC = O(M + L) ; where M is the total characters in words & L is the length of s.
// MC = O(M);
// Problem link : https://leetcode.com/problems/number-of-matching-subsequences/

class Solution {

    private static final int LMT = 26;

    class TrieNode {
        int wordCnt;
        TrieNode[] next = new TrieNode[LMT];
    }

    public int numMatchingSubseq(String s, String[] words) {
        TrieNode root = new TrieNode();

        for (String word  : words) {
            insert(root, word);
        }

        Map<Character, List<TrieNode>>q = new HashMap<>();
        int cntOfSubseq = 0;

        for (int i = 0; i < LMT; i++) {
            if (root.next[i] != null) {
                q.put((char) (i + 'a'), Stream.of(root.next[i]).collect(Collectors.toList()));
            }
        }

        for (char c : s.toCharArray()) {
            if (!q.containsKey(c)) {
                continue;
            }

            List<TrieNode> nodes = q.get(c);
            q.remove(c);

            for (TrieNode curr : nodes) {
                cntOfSubseq += curr.wordCnt;

                for (int i = 0; i < LMT; i++) {
                    if (curr.next[i] == null) {
                        continue;
                    }

                    List<TrieNode>nexts = q.getOrDefault((char) (i + 'a'), new ArrayList<TrieNode>());
                    nexts.add(curr.next[i]);
                    q.put((char) (i + 'a'), nexts);
                }
            }
        }

        return cntOfSubseq;
    }

    private void insert(TrieNode curr, String word) {
        for (char c : word.toCharArray()) {
            int idx = c - 'a';

            if (curr.next[idx] == null) {
                curr.next[idx] = new TrieNode();
            }

            curr = curr.next[idx];
        }

        curr.wordCnt++;
    }
}

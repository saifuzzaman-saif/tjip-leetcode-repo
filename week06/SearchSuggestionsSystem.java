// TC = O(M * N) ; where M is the total number of characters in the product list & N is the length of searchWord;
// MC = O(M)
// Problem link : https://leetcode.com/problems/search-suggestions-system/description/

class Solution {

    private static final int LMT = 26;
    private static final int MAX_SUGGESTIONS = 3;

    class Node {
        boolean isEnd;
        Node[] next;

        Node() {
            isEnd = false;
            next = new Node[LMT];
        }
    }

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>>suggestions = new ArrayList<>();
        Node root = new Node();

        for (String product : products) {
            insert(root, product);
        }

        String prefix = "";
        for (char c : searchWord.toCharArray()) {
            prefix += c;
            root = (root != null && root.next[c-'a'] != null) ? root.next[c-'a'] : null;

            List<String>suggestion = new ArrayList<>();
            dfsWithPrefix(root, prefix, suggestion);
            suggestions.add(suggestion);
        }

        return suggestions;
    }

    private void insert(Node curr, String word) {
        for (char c : word.toCharArray()) {
            int idx = c - 'a';

            if (curr.next[idx] == null) {
                curr.next[idx] = new Node();
            }

            curr = curr.next[idx];
        }

        curr.isEnd = true;
    }

    private void dfsWithPrefix(Node curr, String word, List<String>suggestion) {
        if (curr == null || suggestion.size() == MAX_SUGGESTIONS) {
            return;
        }

        if (curr.isEnd) {
            suggestion.add(word);
        }

        for (int i = 0; i < LMT; i++) {
            if (curr.next[i] == null) {
                continue;
            }

            dfsWithPrefix(curr.next[i], word + (char)(i + 'a'), suggestion);
        }
    }
}

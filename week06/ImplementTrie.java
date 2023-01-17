// TC = O(l); for each call, where l is the average length of string;
// MC = O(C); where C is the total number of characters in all calls made to insert.
// Problem link : https://leetcode.com/problems/implement-trie-prefix-tree/description/

class Trie {

    private static final int LMT = 26;

    class Node {
        boolean isEnd;
        Node[] next;

        Node() {
            isEnd = false;
            next = new Node[LMT];
        }
    }

    Node root;

    public Trie() {
        root = new Node();
    }
    
    public void insert(String word) {
        Node curr = root;

        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';

            if (curr.next[idx] == null) {
                curr.next[idx] = new Node();
            }

            curr = curr.next[idx];
        }

        curr.isEnd = true;
    }
    
    public boolean search(String word, boolean ... isPrefix) {
        Node curr = root;

        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';

            if (curr.next[idx] == null) {
                return false;
            }

            curr = curr.next[idx];
        }

        return (isPrefix.length == 1 && isPrefix[0]) ? true : curr.isEnd;
    }
    
    public boolean startsWith(String prefix) {
        return search(prefix, true);
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
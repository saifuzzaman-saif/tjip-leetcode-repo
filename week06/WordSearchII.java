// TC = O(m * n * 3^L); where m x n is the dimension of board & L is the length of each word.
// MC = O(M); where M is the total number of characters.
// Problem link : https://leetcode.com/problems/word-search-ii/description/

class Solution {

    private static final int LMT = 26;
    private static final int[] DX = {0, 0, 1, -1};
    private static final int[] DY = {1, -1, 0, 0};
    private static final char DUMMY_CHAR = '$';
    private List<String>matchedWords;
    private char[][] board;

    class TrieNode {
        boolean isEnd;
        TrieNode[] next;

        TrieNode() {
            isEnd = false;
            next = new TrieNode[LMT];
        }
    }

    public List<String> findWords(char[][] board, String[] words) {
        matchedWords = new ArrayList<>();
        TrieNode root = new TrieNode();
        this.board = board;

        for (String word : words) {
            insert(root, word);
        }

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                int ch = board[row][col] - 'a';

                if (root.next[ch] != null) {
                    dfs(row, col, "", root);
                }
            }
        }

        return matchedWords;
    }

    private void insert(TrieNode curr, String word) {
        for (char c : word.toCharArray()) {
            int idx = c - 'a';

            if (curr.next[idx] == null) {
                curr.next[idx] = new TrieNode();
            }

            curr = curr.next[idx];
        }

        curr.isEnd = true;
    }

    private void dfs(int row, int col, String word, TrieNode par) {
        int ch = board[row][col] - 'a';
        TrieNode curr = par.next[ch];

        if (curr.isEnd) {
            matchedWords.add(word + board[row][col]);
            curr.isEnd = false;
        }

        board[row][col] = DUMMY_CHAR;

        for (int k = 0; k < 4; k++) {
            int nRow = row + DX[k];
            int nCol = col + DY[k];

            if (isValidCell(nRow, nCol) && curr.next[board[nRow][nCol] - 'a'] != null) {
                dfs(nRow, nCol, word + (char) (ch + 'a'), curr);
            }
        }

        board[row][col] = (char) (ch + 'a');
    }

    private boolean isValidCell(int row, int col) {
        int m = board.length;
        int n = board[0].length;

        return row >= 0 && row < m && col >= 0 && col < n && board[row][col] != DUMMY_CHAR;
    }
}
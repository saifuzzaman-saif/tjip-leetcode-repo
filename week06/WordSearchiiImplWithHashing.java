// TC = O(m * n * 3^L); where m x n is the dimension of board & L is the length of each word.
// MC = O(M); where M is the total number of characters.
// Problem link : https://leetcode.com/problems/word-search-ii/description/

class Solution {

    private static final int[] DX = {0, 0, 1, -1};
    private static final int[] DY = {1, -1, 0, 0};
    private static final char DUMMY_CHAR = '$';
    private static final long MOD = 1_000_000_007L;
    private static final long BASE = 997;
    private Map<Long, Boolean> hashes;  // Map value is false if the hash is of a proper prefix, otherwise it is true.
    private List<String>matchedWords;
    private char[][] board;

    public List<String> findWords(char[][] board, String[] words) {
        matchedWords = new ArrayList<>();
        hashes = new HashMap<>();
        this.board = board;

        for (String word : words) {
            calPrefixHash(word);
        }

        Long currHash = 0L;
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                char ch = board[row][col];
                if (hashes.containsKey(genHash(currHash, ch))) {
                    dfs(row, col, "", currHash);
                }
            }
        }

        return matchedWords;
    }

    private void dfs(int row, int col, String word, long hash) {
        char ch = board[row][col];
        long currHash = genHash(hash, ch);

        if (hashes.get(currHash)) {
            matchedWords.add(word + ch);
            hashes.put(currHash, false);  // word is taken, so made it false
        }

        board[row][col] = DUMMY_CHAR;

        for (int k = 0; k < 4; k++) {
            int nRow = row + DX[k];
            int nCol = col + DY[k];
            if (!isValidCell(nRow, nCol)) {
                continue;
            }

            long nextHash = genHash(currHash, board[nRow][nCol]);
            if (hashes.containsKey(nextHash)) {
                dfs(nRow, nCol, word + ch, currHash);
            }
        }

        board[row][col] = ch;
    }

    private void calPrefixHash(String word) {
        long prefixHash = 0;

        for (int i = 0; i < word.length(); i++) {
            prefixHash = genHash(prefixHash, word.charAt(i));

            if (i + 1 == word.length()) {  // end of a word
                hashes.put(prefixHash, true);
            } else if (!hashes.containsKey(prefixHash)) {  // check if it is not end of another word
                hashes.put(prefixHash, false);
            }
        }
    }

    private long genHash(long currPrefixHash, char ch) {
        return (currPrefixHash * BASE + ch - 'a' + 1) % MOD;
    }

    private boolean isValidCell(int row, int col) {
        int m = board.length;
        int n = board[0].length;

        return row >= 0 && row < m && col >= 0 && col < n && board[row][col] != DUMMY_CHAR;
    }
}

class Solution {

    // TC = O((M + N) * Log(M)) ; Where M is the length of string s and N is the total 
    //                            number of characters in words.
    // MC = O(M)

    List<List<Integer>>pos;

    public int numMatchingSubseq(String s, String[] words) {
        init(s);
        int cntSubsequence = 0;

        for (String word : words) {
            cntSubsequence += isSubsequence(word) ? 1 : 0;
        }

        return cntSubsequence;
    }

    private boolean isSubsequence(String s) {
        int lastPos = -1;

        for (int i = 0; i < s.length(); i++) {
            int ch = s.charAt(i) - 'a';
            int idx = Collections.binarySearch(pos.get(ch), lastPos + 1);
            idx = (idx < 0) ? -(idx) - 1 : idx;

            if (idx == pos.get(ch).size()) {
                return false;
            } else {
                lastPos = pos.get(ch).get(idx);
            }
        }

        return true;
    }

    private void init(String s) {
        pos = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            pos.add(new ArrayList<Integer>());
        }

        for(int i = 0; i < s.length(); i++) {
            pos.get(s.charAt(i) - 'a').add(i);
        }
    }
}
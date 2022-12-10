class Solution {

    // TC = O(n) ; Where n is max(|s|, |t|);
    // MC = O(1)
    
    public boolean isAnagram(String s, String t) {
        return getHash(s) == getHash(t);
    }

    private int getHash(String s) {
        long hash = 1, offset = 997, mod = 1_000_000_007;

        for (int i = 0; i < s.length(); i++) {
            hash = (hash * (offset + s.charAt(i))) % mod;
        }

        return (int) hash;
    }
}
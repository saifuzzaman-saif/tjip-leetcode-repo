// TC = O(n); Where n is the length of each string.
// MC = O(n);
// Problem link : https://leetcode.com/problems/isomorphic-strings/

class Solution {

    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character>sMap = new HashMap<>();
        Map<Character, Character>tMap = new HashMap<>();
        int n = s.length();

        for (int i = 0; i < n; i++) {
            char charS = s.charAt(i);
            char charT = t.charAt(i);

            if (sMap.containsKey(charS) && sMap.get(charS) != charT) {
                return false;
            } else if (tMap.containsKey(charT) && tMap.get(charT) != charS) {
                return false;
            } else {
                sMap.put(charS, charT);
                tMap.put(charT, charS);
            }
        }

        return true;
    }
}

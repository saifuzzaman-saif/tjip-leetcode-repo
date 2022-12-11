// TC = O(NK) ; Where N is the number of strings & K is the length of each string;
// MC = O(N)
// problem link : https://leetcode.com/problems/group-anagrams/

class Solution {

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<Integer, List<String>>anagrams = new HashMap<>();

        for (String str : strs) {
            int hashVal = getHashVal(str);
            List<String>list = anagrams.getOrDefault(hashVal, new ArrayList<String>());
            list.add(str);
            anagrams.put(hashVal, list);
        }

        return new ArrayList<>(anagrams.values());
    }

    private int getHashVal(String s) {
        long hash = 1, offset = 997, mod = 1_000_000_007;

        for (int i = 0; i < s.length(); i++) {
            int ch = s.charAt(i) - 'a';
            hash = (hash * (ch + offset)) % mod;
        }

        return (int) hash;
    }
}
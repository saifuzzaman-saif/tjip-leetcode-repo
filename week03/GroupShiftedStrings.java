// TC = O(N*M); where N is length of strings array and M is the length of strings[i].
// MC = O(n*M);
// Problem link : https://leetcode.com/problems/group-shifted-strings/description/

class Solution {

    private static final int MOD = 26;

    private String getHashVal(String s) {
        StringBuffer hash = new StringBuffer();

        for (int i = 0; i < s.length(); i++) {
            hash.append((s.charAt(i) - s.charAt(0) + MOD) % MOD);
            hash.append(',');
        }

        return new String(hash);
    }

    public List<List<String>> groupStrings(String[] strings) {
        Map<String, List<String>>shiftedStringsMap = new HashMap<>();

        for (String s : strings) {
            String hashVal = getHashVal(s);

            if (shiftedStringsMap.containsKey(hashVal)) {
                shiftedStringsMap.get(hashVal).add(s);
            } else {
                List<String>list = new ArrayList<>();
                list.add(s);
                shiftedStringsMap.put(hashVal, list);
            }
        }

        List<List<String>>shiftedStringsList = new ArrayList<>();

        for (Map.Entry<String, List<String>> entry : shiftedStringsMap.entrySet()) {
            shiftedStringsList.add(entry.getValue());
        }

        return shiftedStringsList;
    }
}

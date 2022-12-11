// TC = O(n^2)
// MC O(n)
// problem link : https://leetcode.com/problems/find-and-replace-in-string/description/

class Solution {

    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        int n = s.length();
        int[] mark = new int[n];
        String[] sourceSubstr = new String[n];
        String[] replacedBy = new String[n];

        for (int i = 0; i < indices.length; i++) {
            if (matches(s, sources[i], indices[i])) {
                mark[indices[i]] = 1;
                sourceSubstr[indices[i]] = sources[i];
                replacedBy[indices[i]] = targets[i];
            }
        }

        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < n; ) {
            if (mark[i] == 0) {
                sb.append(s.charAt(i));
                i++;
            } else {
                sb.append(replacedBy[i]);
                i += sourceSubstr[i].length();
            }
        }

        return new String(sb);
    }

    boolean matches (String s, String t, int idx) {
        int n = s.length(), m = t.length();

        if (idx + m - 1 >= n) {
            return false;
        }

        for (int i = 0; i < m; i++) {
            if (s.charAt(idx + i) != t.charAt(i)) {
                return false;
            }
        }

        return true;
    }
}

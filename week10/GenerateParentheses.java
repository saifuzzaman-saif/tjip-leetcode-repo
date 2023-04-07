/**
 * TC = o(C(n)) ; where C(n) means the catalan number for integer n.
 * MC = O(C(n));
 * Problem link : https://leetcode.com/problems/generate-parentheses/description/
 */

class Solution {

    List<String> parentheses;
    StringBuffer sb;
    
    public List<String> generateParenthesis(int n) {
        parentheses = new ArrayList<>();
        sb = new StringBuffer();

        generate(0, 0, n);

        return parentheses;
    }

    private void generate(int opening, int closing, int n) {
        if (opening == closing && opening == n) {
            parentheses.add(new String(sb));
            return;
        }

        if (opening < n) {
            sb.append('(');
            generate(opening + 1, closing, n);
            sb.deleteCharAt(sb.length() - 1);
        }

        if (closing < opening && closing < n) {
            sb.append(')');
            generate(opening, closing + 1, n);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}

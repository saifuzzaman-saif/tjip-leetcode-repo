/**
 * TC = O(N); where N is the length of num;
 * MC = O(N);
 * Problem link : https://leetcode.com/problems/remove-k-digits/description/
 */

class Solution {

    public String removeKdigits(String num, int k) {
        Stack<Character> stk = new Stack<>();

        for (int i = 0; i < num.length(); i++) {
            char dgt = num.charAt(i);

            while (!stk.isEmpty() && stk.peek() > dgt && k > 0) {
                stk.pop();
                k--;
            }

            stk.add(dgt);
        }

        while (k > 0 && !stk.isEmpty()) {
            stk.pop();
            k--;
        }

        StringBuffer sb = new StringBuffer();
        while (!stk.isEmpty()) {
            sb.append(stk.pop());
        }

        return removeLeadingZero(sb.reverse());
    }

    private String removeLeadingZero(StringBuffer sb) {
        String s = new String(sb);
        int l = 0, r = s.length();

        while (l < r && s.charAt(l) == '0') {
            l++;
        }

        return s.substring(l, r).isEmpty() ? "0" : s.substring(l, r);
    }
}

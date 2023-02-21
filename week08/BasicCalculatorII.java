/**
 * TC = O(n) ; where n is the length of string s.
 * MC = O(n) 
 * Problem link : https://leetcode.com/problems/basic-calculator-ii/description/
 */

class Solution {

    public int calculate(String s) {
        Stack<Integer> stk = new Stack<>();
        int curr = 0;
        char opt = '+';

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                curr = curr * 10 + (c - '0');
            }

            if (c != ' ' && !Character.isDigit(c) || i == s.length() - 1) {
                if (opt == '+') {
                    stk.push(curr);
                } else if (opt == '-') {
                    stk.push(-curr);
                } else if (opt == '*') {
                    stk.push(stk.pop() * curr);
                } else {
                    stk.push(stk.pop() / curr);
                }

                curr = 0;
                opt = c;
            }
        }

        int res = 0;

        while (!stk.isEmpty()) {
            res += stk.pop();
        }

        return res;
    }
}

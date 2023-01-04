// TC = O(n) ; where n is the length of string s.
// MC = O(n)
// problem link : https://leetcode.com/problems/valid-parentheses/

class Solution {

    public boolean isValid(String s) {
        Stack<Character> stk = new Stack<>();
        Map<Character, Character>closeToOpen = new HashMap<>();
        closeToOpen.put(')', '(');
        closeToOpen.put('}','{' );
        closeToOpen.put(']', '[');

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '(' || ch == '{' || ch == '[') {
                stk.push(ch);
            } else if (stk.isEmpty() || stk.peek() != closeToOpen.get(ch)) {
                return false; 
            } else {
                stk.pop();
            }
        }

        return stk.isEmpty();
    }
}
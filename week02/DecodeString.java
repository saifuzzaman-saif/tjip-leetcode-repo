class Pair {
    int first;
    StringBuffer second;

    Pair(int first, StringBuffer second) {
        this.first = first;
        this.second = second;
    }
}

class Solution {

    // TC = O(N) ; where N is length of the final output string.
    // MC = O(|s|)

    public String decodeString(String s) {
        Stack<Pair> stk = new Stack<>();
        stk.push(new Pair(1, new StringBuffer()));
        int curr = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (isDigit(ch)) {
                curr = curr * 10 + ch - '0';
            } else if (isLetter(ch)) {
                stk.peek().second.append(ch);
            } else if (ch == '[') {
                stk.push(new Pair(curr, new StringBuffer()));
                curr = 0;
            } else if (ch == ']') {
                Pair top = stk.pop();
                appendKTimes(stk.peek().second, top.second, top.first);
            }
        }

        return new String(stk.peek().second);
    }

    private void appendKTimes(StringBuffer first, StringBuffer second, int k) {
        while (k > 0) {
            first.append(second);
            k--;
        }
    }

    private boolean isDigit(char c) {
        return c >= '0' && c <= '9';
    }

    private boolean isLetter(char c) {
        return c >= 'a' && c <= 'z';
    }
}

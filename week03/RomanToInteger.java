// TC = O(|s|); where |s| is the length of string s.
// MC = o(1);
// Problem link : https://leetcode.com/problems/roman-to-integer/

class Solution {

    Map<Character, Integer> romans;
    private static final int N = 7;
    private static final char[] SYMBOLS = {'I', 'V', 'X', 'L', 'C', 'D', 'M'};
    private static final int[] VALS = {1, 5, 10, 50, 100, 500, 1000};

    public int romanToInt(String s) {
        init();
        int val = 0;

        for (int i = 0; i < s.length(); i++) {
            Character curr = s.charAt(i);
            Character next = null;

            if (i + 1 < s.length()) {
                next = s.charAt(i + 1);
            }

            if (Objects.nonNull(next) && romans.get(next) > romans.get(curr)) {
                val -= romans.get(curr);
            } else {
                val += romans.get(curr);
            }
        }

        return val;
    }

    private void init() {
        romans = new HashMap<>();

        for (int i = 0; i < N; i++) {
            romans.put(SYMBOLS[i], VALS[i]);
        }
    }
}


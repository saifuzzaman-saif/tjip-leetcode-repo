// TC = O(|s|); where |s| is the length of string s.
// MC = o(1);

class Solution {

    Map<Character, Integer> romans;
    private static final int N = 7;

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
        char[] symbols = {'I', 'V', 'X', 'L', 'C', 'D', 'M'};
        int[] vals = {1, 5, 10, 50, 100, 500, 1000};
        romans = new HashMap<>();

        for (int i = 0; i < N; i++) {
            romans.put(symbols[i], vals[i]);
        }
    }
}

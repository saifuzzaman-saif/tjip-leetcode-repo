/**
 * TC = O(L) ; where L is the length of result string which may be 10^4 at most as constraints.
 * MC = O(L)
 * Problem link : https://leetcode.com/problems/fraction-to-recurring-decimal/description/
 */

class Solution {

    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) {
            return "0";
        }

        StringBuffer result = new StringBuffer();

        if ((numerator < 0 && denominator > 0) || (numerator > 0 && denominator < 0)) {
           result.append("-");
        }

        long dividend = Math.abs((long) numerator);
        long divisor = Math.abs((long) denominator);
        result.append(dividend / divisor);
        long rem = dividend % divisor;

        if (rem == 0) {
            return new String(result);
        }

        result.append(".");
        Map<Long, Integer> pos = new HashMap<>();
        while (rem != 0) {
            if (pos.containsKey(rem)) {
                result.insert(pos.get(rem), "(");
                result.append(")");
                break;
            }

            pos.put(rem, result.length());
            rem *= 10;
            result.append(rem / divisor);
            rem %= divisor;
        }

        return new String(result);
    }
}

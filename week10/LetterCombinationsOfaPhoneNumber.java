/**
 * TC = o(4^n * n) ; where n is the length of digits.
 * MC = O(n + m); m is the number of combinations. O(n) is required for recursion. O(m) is to store result.
 * Problem link : https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/
 */

class Solution {

    private StringBuffer letterCombination;
    private List<String> letterCombinationList;
    private static Map<Character, String> digitToLettersMap;

    static {
        digitToLettersMap = new HashMap<>();
        digitToLettersMap.put('2', "abc");
        digitToLettersMap.put('3', "def");
        digitToLettersMap.put('4', "ghi");
        digitToLettersMap.put('5', "jkl");
        digitToLettersMap.put('6', "mno");
        digitToLettersMap.put('7', "pqrs");
        digitToLettersMap.put('8', "tuv");
        digitToLettersMap.put('9', "wxyz");
    }

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return new ArrayList<>();
        }

        letterCombination = new StringBuffer();
        letterCombinationList = new ArrayList<>();
        generateCombination(0, digits);

        return letterCombinationList;
    }

    private void generateCombination(int idx, String digits) {
        if (idx == digits.length()) {
            letterCombinationList.add(new String(letterCombination));
            return;
        }
        
        String letters = digitToLettersMap.get(digits.charAt(idx));

        for (char c : letters.toCharArray()) {
            letterCombination.append(c);
            generateCombination(idx + 1, digits);
            letterCombination.deleteCharAt(letterCombination.length() - 1);        
        }
    }
}

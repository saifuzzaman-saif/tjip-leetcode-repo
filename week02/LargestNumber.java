// TC = O(n Log(n))
// MC = O(1)
// problem link : https://leetcode.com/problems/largest-number/

class Solution {

    public String largestNumber(int[] nums) {
        List<String>numStrings = new ArrayList<>();

        for(int num : nums) {
            numStrings.add(String.valueOf(num));
        }

        Collections.sort(numStrings, (s1, s2) -> (s2 + s1).compareTo(s1 + s2));

        if (numStrings.get(0).equals("0")) {
            return "0";
        }
        
        StringBuffer largestVal = new StringBuffer();

        for (String s : numStrings) {
            largestVal.append(s);
        }

        return new String(largestVal);
    }
}
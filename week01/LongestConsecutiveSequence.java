class Solution {

    // TC = O(n) ; where n is the size of nums array.
    // MC = O(n)

    public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> cache = new HashMap<>();

        for (int num : nums) {
            cache.put(num, num);
        }

        int longestSeq = 0;
        for (Map.Entry<Integer, Integer> entry : cache.entrySet()) {
            if (!cache.containsKey(entry.getKey() - 1)) {
                int currSeq = 0;
                int x = entry.getKey();

                while (cache.containsKey(x)) {
                    currSeq++;
                    x++;
                }

                longestSeq = Math.max(longestSeq, currSeq);
            }
        }

        return longestSeq;
    }
}
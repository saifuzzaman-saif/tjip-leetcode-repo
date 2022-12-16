class Solution {

    // TC = O(n) ; where n is the size of Heights array.
    // MC = O(1)

    public int trap(int[] height) {
        int leftMax = -1;
        int rightMax = -1;
        int l = 0;
        int r = height.length - 1;
        int totalWater = 0;

        while (l <= r) {
            leftMax = Math.max(leftMax, height[l]);
            rightMax = Math.max(rightMax, height[r]);

            if (height[l] < height[r]) {
                totalWater += leftMax - height[l++];
            } else {
                totalWater += rightMax - height[r--];
            }
        }

        return totalWater;
    }
}
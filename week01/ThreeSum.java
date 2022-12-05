class Solution {

    // TC = O(n^2) ; where n is the size of nums array
    // MC = O(1)

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> triplets = new ArrayList<>();
        int n = nums.length;
        Arrays.sort(nums);

        for (int i = 0; i < n; ) {
            int l = i + 1;
            int r = n - 1;
            int target = -nums[i];
            
            while (l < r) {
                if (nums[l] + nums[r] == target) {
                    List<Integer> triplet = getTriplet(nums[i], nums[l], nums[r]);
                    triplets.add(triplet);

                    while(l + 1 < r && nums[l+1] == nums[l]) {
                        l++;
                    }
                    while(r - 1 > l && nums[r-1] == nums[r]) {
                        r--;
                    }

                    l++;
                    r--;
                } else if (nums[l] + nums[r] > target) {
                    r--;
                } else {
                    l++;
                }
            }

            while(i+1 < n && nums [i+1] == nums[i]) {
                i++;
            }

            i++;
        }

        return triplets;
    }

    private List<Integer> getTriplet(int a, int b, int c) {
        List<Integer> triplet = new ArrayList<>();
        triplet.add(a);
        triplet.add(b);
        triplet.add(c);
        
        return triplet;
    }
}
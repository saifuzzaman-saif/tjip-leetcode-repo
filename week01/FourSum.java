class Solution {

    // TC = O(n^3) ; where n is the size of nums array.
    // MC = O(n);

    public List<List<Integer>> fourSum(int[] nums, int target) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> quadruplets = new ArrayList<>();

        for (int i = 0; i < n; ) {
            for (int j = i + 1; j < n; ) {
                int k = j + 1;
                int l = n - 1;

                while (k < l) {
                    if (nums[k] + nums[l] == (long) target - nums[i] - nums[j]) {
                        List<Integer> quadruplet = getQuadruplet(nums[i], nums[j], nums[k], nums[l]);
                        quadruplets.add(quadruplet);

                        while (k + 1 < l && nums[k+1] == nums[k]) {
                            k++;
                        }
                        while (l - 1 > k && nums[l - 1] == nums[l]) {
                            l--;
                        }

                        k++;
                        l--;
                    } else if (nums[k] + nums[l] > (long) target - nums[i] - nums[j]) {
                        l--;
                    } else {
                        k++;
                    }
                }

                while (j + 1 < n && nums[j+1] == nums[j]) {
                    j++;
                }
                j++;
            }

            while (i + 1 < n && nums[i+1] == nums[i]) {
                i++;
            }
            i++;
        }

        return quadruplets;
    }

    private List<Integer> getQuadruplet(int a, int b, int c, int d) {
        List<Integer> quadruplet = new ArrayList<>();
        quadruplet.add(a);
        quadruplet.add(b);
        quadruplet.add(c);
        quadruplet.add(d);

        return quadruplet;
    }
}
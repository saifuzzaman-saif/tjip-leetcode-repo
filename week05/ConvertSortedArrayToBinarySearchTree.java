/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

// TC = O(n); where n is the length of nums array.
// MC = O(log(n)) required for recursion stack.
// Problem link : https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/description/

class Solution {

    public TreeNode sortedArrayToBST(int[] nums) {
        return constructBstFrom(nums, 0, nums.length - 1);
    }

    private TreeNode constructBstFrom(int[] nums, int l, int r) {
        if (l > r) {
            return null;
        }

        int mid = l + (r - l) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = constructBstFrom(nums, l, mid - 1);
        root.right = constructBstFrom(nums, mid + 1, r);

        return root;
    }
}
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

// TC = O(n); where n is the number of nodes in the given tree.
// MC = O(H); where H is the height of the tree, required for recursion.
// Problem link : https://leetcode.com/problems/binary-tree-maximum-path-sum/

class Solution {

    private int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        helper(root); // returns maximum path sum started at root node and going down
                      // and also finds max path sum that pass through the root node.

        return maxSum;
    }

    int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = Math.max(0, helper(root.left));
        int right = Math.max(0, helper(root.right));
        maxSum = Math.max(maxSum, left + right + root.val);

        return root.val + Math.max(left, right);
    }
}

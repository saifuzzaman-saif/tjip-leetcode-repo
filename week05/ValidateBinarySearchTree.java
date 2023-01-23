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

// TC = O(n); where n is the number of nodes in the tree;
// MC = O(n)
// Problem link : https://leetcode.com/problems/validate-binary-search-tree/description/

class Solution {

    public boolean isValidBST(TreeNode root) {
        return helper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean helper(TreeNode root, long l, long r) {
        if (root == null) {
            return true;
        } 
        
        if (l > root.val || root.val > r) {
            return false;
        }

        return helper(root.left, l, (long) root.val - 1) && helper(root.right, (long) root.val + 1, r);
    }
}

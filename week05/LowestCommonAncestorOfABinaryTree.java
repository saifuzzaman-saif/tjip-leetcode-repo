/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// TC = O(n); where n is the number of nodes in the tree;
// MC = O(n);
// Problem link : https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/description/

class Solution {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return search(root, p, q);
    }

    private TreeNode search(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }

        if (root.val == p.val || root.val == q.val) {
            return root;
        }

        TreeNode left = search(root.left, p, q);
        TreeNode right = search(root.right, p, q);

        if (left != null && right != null) {
            return root;
        }

        return (left != null) ? left : right;
    }
}
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

 // TC = O(n); where n is the number of nodes.
 // MC = O(n);
 // Problem link : https://leetcode.com/problems/step-by-step-directions-from-a-binary-tree-node-to-another/description/

class Solution {

    private TreeNode lca;
    private int lca_level = -1;

    public String getDirections(TreeNode root, int startValue, int destValue) {
        lca = search(root, startValue, destValue);
        traverse(root, 0);

        StringBuffer left = new StringBuffer();
        StringBuffer right = new StringBuffer();
        findPath(root, startValue, left);
        findPath(root, destValue, right);

        String leftPath = new String(left.reverse()).substring(lca_level);
        String rightPath = new String(right.reverse()).substring(lca_level);

        return "U".repeat(leftPath.length()) + rightPath;
    }

    private TreeNode search(TreeNode root, int p, int q) {
        if (root == null) {
            return null;
        }
        if (root.val == p || root.val == q) {
            return root;
        }

        TreeNode left = search(root.left, p, q);
        TreeNode right = search(root.right, p, q);

        if (left != null && right != null) {
            return root;
        }

        return (left == null) ? right : left;
    }

    private boolean findPath(TreeNode root, int target, StringBuffer sb) {
        if (root == null) {
            return false;
        }
        if (root.val == target) {
            return true;
        }

        boolean isFound = findPath(root.left, target, sb);
        if (isFound) {
            sb.append('L');
            return true;
        }

        isFound = findPath(root.right, target, sb);
        if (isFound) {
            sb.append('R');
            return true;
        }

        return false;
    }

    private void traverse(TreeNode root, int level) {
        if (root == null) {
            return;
        }
        if (root == lca) {
            lca_level = level;
        }

        traverse(root.left, level + 1);
        traverse(root.right, level + 1);
    }
}

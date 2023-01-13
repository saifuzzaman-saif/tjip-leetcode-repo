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

// TC = O(n); where n is the number of nodes the tree;
// MC = O(H); where H is the height of the tree.
// Problem link : https://leetcode.com/problems/kth-smallest-element-in-a-bst/description/

class Solution {

    private int kthSmallestVal;

    public int kthSmallest(TreeNode root, int k) {
        getSubtreeSize(root, k);  // returns the sub tree size with node root
                                  // and finds Kth smallest element concurrently.

        return kthSmallestVal;
    }

    private int getSubtreeSize(TreeNode root, int k) {
        if (root == null) {
            return 0;
        }

        int leftSubtreeSize = getSubtreeSize(root.left, k);
        int rightSubtreeSize = getSubtreeSize(root.right, k - leftSubtreeSize - 1);

        if (leftSubtreeSize + 1 == k) {
            kthSmallestVal = root.val;
        }

        return leftSubtreeSize + rightSubtreeSize + 1;
    }
}
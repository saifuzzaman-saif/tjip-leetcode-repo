/**
 * TC = O(N) ; Where N is number of nodes.
 * MC = O(H); Where H is height of the tree.
 * Problem link : https://leetcode.com/problems/maximum-depth-of-binary-tree/description/
 */

class Solution {

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);

        return 1 + Math.max(leftDepth, rightDepth);
    }
}

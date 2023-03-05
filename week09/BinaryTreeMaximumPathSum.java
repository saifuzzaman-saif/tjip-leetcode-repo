/**
 * TC = O(N) ; Where N is number of nodes.
 * MC = O(H); Where H is height of the tree.
 * Problem link : https://leetcode.com/problems/binary-tree-maximum-path-sum/description/
 */

class Solution {

    private int maxPathSum;

    public int maxPathSum(TreeNode root) {
        maxPathSum = Integer.MIN_VALUE;
        getChainSum(root);

        return maxPathSum;
    }

    private int getChainSum(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftChainSum = getChainSum(root.left);
        int rightChainSum = getChainSum(root.right);
        maxPathSum = Math.max(maxPathSum, leftChainSum + rightChainSum + root.val);
       
        return Math.max(0, Math.max(leftChainSum, rightChainSum) + root.val);
    }
}

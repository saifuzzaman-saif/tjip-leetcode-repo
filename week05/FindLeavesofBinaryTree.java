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

// TC = O(n); where n is the number of nodes;
// MC = O(n + d); where d is the depth of tree.
// Problem link : https://leetcode.com/problems/find-leaves-of-binary-tree/description/

class Solution {

    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>>leaves = new ArrayList<>();
        getHeight(root, leaves);

        return leaves;
    }

    private int getHeight(TreeNode root, List<List<Integer>>leaves) {
        if (root == null) {
            return -1;
        }

        int left = getHeight(root.left, leaves);
        int right = getHeight(root.right, leaves);
        int height = 1 + Math.max(left, right);

        if (height == leaves.size()) {
            leaves.add(Stream.of(root.val).collect(Collectors.toList()));
        } else {
            leaves.get(height).add(root.val);
        }

        return height;
    }
}

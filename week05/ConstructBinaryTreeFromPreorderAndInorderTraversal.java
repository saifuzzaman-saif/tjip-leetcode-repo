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
 // Problem link : https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/
 
class Solution {

    int[] preorder;
    int preorderIdx = 0;
    Map<Integer, Integer> inorderIdx = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;

        for (int i = 0; i < inorder.length; i++) {
            inorderIdx.put(inorder[i], i);
        }

        return constructTree(0, inorder.length - 1);
    }

    private TreeNode constructTree(int l, int r) {
        if (l > r) {
            return null;
        }

        int val = preorder[preorderIdx++];
        TreeNode root = new TreeNode(val);
        int pos = inorderIdx.get(val);

        root.left = constructTree(l, pos - 1);
        root.right = constructTree(pos + 1, r);

        return root;
    }
}

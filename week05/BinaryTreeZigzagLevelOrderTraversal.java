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

// TC = O(n); where n is the number of nodes in the tree.
// MC = O(L + n); where L is the maximum number of nodes at a certain level.
// Problem link : https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/

class Solution {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>>levels = new ArrayList<>();
        if (root == null) {
            return levels;
        }

        Queue<TreeNode>q = new LinkedList<>();
        q.add(root);
        int levelNo = 0;

        while (!q.isEmpty()) {
            int len = q.size();
            List<Integer>level = new ArrayList<>();

            for (int i = 0; i < len; i++) {
                TreeNode curr = q.poll();
                level.add(curr.val);

                if (curr.left != null) {
                    q.add(curr.left);
                }

                if (curr.right != null) {
                    q.add(curr.right);
                }
            }

            if (levelNo % 2 == 1) {
                Collections.reverse(level);
            }

            levelNo++;
            levels.add(level);
        }

        return levels;
    }
}

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

 // TC = O(n^2);
 // MC = O(n^2);

class Solution {

    Map<String, Integer>counts = new HashMap<>();
    List<TreeNode> duplicates = new ArrayList<>();

    private String dfs(TreeNode root) {
        if (root == null) {
            return "*";
        }

        String left = dfs(root.left);
        String right = dfs(root.right);
        String curr = String.valueOf(root.val) + "," + left + "," + right;

        if (counts.containsKey(curr) && counts.get(curr) == 1) {
            duplicates.add(root);
        }

        counts.put(curr, counts.getOrDefault(curr, 0) + 1);

        return curr;
    }

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        dfs(root);

        return duplicates;
    }
}


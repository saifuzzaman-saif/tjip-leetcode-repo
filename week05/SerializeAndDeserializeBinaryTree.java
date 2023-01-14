/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

 // TC = O(n); where n is the number of nodes
 // MC = O(n);
 // Problem link : https://leetcode.com/problems/serialize-and-deserialize-binary-tree/
 
public class Codec {

    private static final int DUMMY_VAL = 96969696;

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "X";
        }

        String left = serialize(root.left);
        String right = serialize(root.right);

        return String.valueOf(root.val) + "," + left + "," + right;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] nodeVals = data.split(",");
        Stack<TreeNode>stk = new Stack<>();
        TreeNode dummyRoot = new TreeNode(DUMMY_VAL);
        stk.add(dummyRoot);
        stk.add(dummyRoot);

        for (String val : nodeVals) {
            TreeNode root = stk.pop();
            if (val.equals("X")) {
                continue;
            }

            TreeNode curr = new TreeNode(Integer.valueOf(val));

            if (stk.isEmpty() || stk.peek() == root) {
                root.left = curr;
            } else {
                root.right = curr;
            }

            stk.add(curr);
            stk.add(curr);
        }

        return dummyRoot.left;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
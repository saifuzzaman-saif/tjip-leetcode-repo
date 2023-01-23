/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

// TC = O(n); where n is the number of nodes in the tree.
// MC = O(L); where L is maximum number of nodes at a certain level.
// Problem link : https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/

class Solution {

    public Node connect(Node root) {
        if (root == null) {
            return root;
        }

        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int len = q.size();

            for (int i = 0; i < len; i++) {
                Node curr = q.poll();
                if (i + 1 < len) {
                    curr.next = q.peek();
                }

                if (curr.left != null) {
                    q.add(curr.left);
                }

                if (curr.right != null) {
                    q.add(curr.right);
                }
            }
        }

        return root;
    }
}

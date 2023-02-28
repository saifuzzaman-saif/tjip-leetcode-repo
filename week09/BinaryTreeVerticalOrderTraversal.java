 /**
 * TC = O(N) ; Where N is number of nodes.
 * MC = O(N) 
 * Problem link : https://leetcode.com/problems/binary-tree-vertical-order-traversal/
 */

class Solution {

    public List<List<Integer>> verticalOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<List<Integer>> vertLevels = new ArrayList<>();
        Map<Integer, List<Integer>> ranks = new TreeMap<>();

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 0));

        while (!q.isEmpty()) {
            Pair curr = q.poll();
            TreeNode node = (TreeNode) curr.getKey();
            int rank = (int) curr.getValue();
            
            List<Integer> level = ranks.getOrDefault(rank, new ArrayList<>());
            level.add(node.val);
            ranks.put(rank, level);

            if (node.left != null) {
                q.add(new Pair(node.left, rank - 1));
            }
            if (node.right != null) {
                q.add(new Pair(node.right, rank + 1));
            }
        }

        for (List<Integer> level : ranks.values()) {
            vertLevels.add(level);
        }

        return vertLevels;
    }
}

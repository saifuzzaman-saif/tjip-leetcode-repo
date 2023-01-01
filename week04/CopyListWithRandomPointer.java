/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

// TC = O(N); where N is the number of nodes;
// MC = O(N);
// Problem link : https://leetcode.com/problems/copy-list-with-random-pointer/description/

class Solution {

    public Node copyRandomList(Node head) {
        Map<Node, Node>copies = new HashMap<>();
        Node curr = head;

        while (curr != null) {
            copies.put(curr, new Node(curr.val));
            curr = curr.next;
        }

        curr = head;
        while (curr != null) {
            Node copy = copies.get(curr);
            copy.next = copies.get(curr.next);
            copy.random = copies.get(curr.random);
            curr = curr.next;
        }

        return copies.get(head);
    }
}

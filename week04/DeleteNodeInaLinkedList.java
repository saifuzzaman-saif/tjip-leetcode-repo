/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
 
 // TC = O(1)
 // MC = O(1)
 // Problem link : https://leetcode.com/problems/delete-node-in-a-linked-list/description/
 
class Solution {

    public void deleteNode(ListNode node) {
        ListNode nextNode = node.next;
        node.val = nextNode.val;
        node.next = nextNode.next;
    }
}

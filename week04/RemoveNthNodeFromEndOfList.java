/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
 
 // TC = O(M); where M is the number of nodes in list;
 // MC = O(1);
 // Problem link : https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/
 
class Solution {

    private static final int DUMMY_VAL = -1;

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyHead = new ListNode(DUMMY_VAL, head);
        ListNode first = dummyHead, second = dummyHead;

        for (int i = 0; i <= n; i++) {
            first = first.next;
        }

        while (first != null) {
            first = first.next;
            second = second.next;
        }

        second.next = second.next.next;

        return dummyHead.next;
    }
}

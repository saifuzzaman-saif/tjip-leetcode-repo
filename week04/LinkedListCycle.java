/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
 
// TC = O(N) ; where N is the number of nodes in list.
// MC = O(1)
// Problem link : https://leetcode.com/problems/linked-list-cycle/description/
 
public class Solution {

    public boolean hasCycle(ListNode head) {
        ListNode hare = head;
        ListNode tortoise = head;

        while (hare != null && hare.next != null) {
            hare = hare.next.next;
            tortoise = tortoise.next;

            if (hare == tortoise) {
                return true;
            }
        }

        return false;
    }
}

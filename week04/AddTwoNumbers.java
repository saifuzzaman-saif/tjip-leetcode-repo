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
 
 // TC = O(N) ; Where N is maximum number of nodes in linked list.
 // MC = O(N)
 // Problem link : https://leetcode.com/problems/add-two-numbers/description/
 
class Solution {

    private static final int BASE = 10;
    private static final int DUMMY_VAL = -1;

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(DUMMY_VAL);
        ListNode curr = head;
        int carry = 0;

        while (true) {
            int sum = 0;

            if (l1 == null && l2 == null) {
                break;
            } else if (l1 == null) {
                sum = l2.val;
                l2 = l2.next;
            } else if (l2 == null) {
                sum = l1.val;
                l1 = l1.next;
            } else {
                sum = l1.val + l2.val;
                l1 = l1.next;
                l2 = l2.next;
            }

            sum += carry;
            carry = sum / BASE;
            sum = sum % BASE;

            curr.next = new ListNode(sum);
            curr = curr.next;
        }

        if (carry != 0) {
            curr.next = new ListNode(carry);
        }

        return head.next;
    }
}


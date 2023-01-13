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
 
 // TC = O(N); N is the number of nodes;
 // MC = O(1);
 // Problem link : https://leetcode.com/problems/maximum-twin-sum-of-a-linked-list/description/
 
class Solution {

    public int pairSum(ListNode head) {
        ListNode left = head, right = head.next;
        ListNode fast = head;

        while (true) {
            if (fast.next == null || fast.next.next == null) {
                break;
            }
            fast = fast.next.next;

            ListNode next = right.next;
            right.next = left;
            left = right;
            right = next;
        }

        int maxSum = Integer.MIN_VALUE;
        while (right != null) {
            maxSum = Math.max(maxSum, left.val + right.val);
            left = left.next;
            right = right.next;
        }

        return maxSum;
    }
}

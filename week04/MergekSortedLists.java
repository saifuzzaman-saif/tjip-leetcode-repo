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
 
 // TC = O(N log(k)) // Where N is total number of nodes in the lists & k is the length of lists
 // MC = O(log(k))
 // Problem link : https://leetcode.com/problems/merge-k-sorted-lists/description/
 
class Solution {

    private static final int DUMMY_VAL = -1;

    public ListNode mergeKLists(ListNode[] lists) {
        return mergeKLists(lists, 0, lists.length - 1);
    }

    public ListNode mergeKLists(ListNode[] lists, int l, int r) {
        if (l > r) {
            return null;
        } else if (l == r) {
            return lists[l];
        }

        int mid = (l + r) >> 1;
        ListNode left = mergeKLists(lists, l, mid);
        ListNode right = mergeKLists(lists, mid + 1, r);

        return merge2Lists(left, right);
    }

    ListNode merge2Lists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(DUMMY_VAL);
        ListNode curr = head;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }

            curr = curr.next;
        }

        if (l1 != null) {
            curr.next = l1;
        } else {
            curr.next = l2;
        }

        return head.next;
    }
}


/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {

    public ListNode deleteMiddle(ListNode head) {
        ListNode slowPtr = head;
        ListNode fastPtr = head;
        ListNode prevPtr = head;
        if (head.next == null) { // base case if only one node return null
            return null;
        }
        while (fastPtr.next != null && fastPtr.next.next != null) {
            prevPtr = slowPtr;
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
        }
        if (fastPtr.next == null) { // odd length case
            prevPtr.next = slowPtr.next;
        } else { // even length case
            slowPtr.next = slowPtr.next.next;
        }
        return head;
    }
}

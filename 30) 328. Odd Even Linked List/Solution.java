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

    public ListNode oddEvenList(ListNode head) {
        // Base case of length zero and length one
        if (head == null || head.next == null) {
            return head;
        }
        ListNode oddPtr = head;
        ListNode evenPtr = head.next;
        ListNode evenHead = evenPtr;
        while (oddPtr.next != null && evenPtr.next != null) {
            oddPtr.next = oddPtr.next.next;
            evenPtr.next = oddPtr.next.next;
            oddPtr = oddPtr.next;
            evenPtr = oddPtr.next;
        }
        oddPtr.next = evenHead;
        return head;
    }
}

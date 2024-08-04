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

    public int pairSum(ListNode head) {
        // Using slowptr and fastptr to get the middle node of the Linked List
        ListNode slowPtr = head;
        ListNode fastPtr = head;

        while (fastPtr != null) {
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
        }

        // Reversing second half of the List
        ListNode reversedHalf = reverseList(slowPtr);

        // checking maximum value of each twin sum
        int ans = 0;
        while (reversedHalf != null) {
            ans = Math.max(ans, head.val + reversedHalf.val);
            head = head.next;
            reversedHalf = reversedHalf.next;
        }

        return ans;
    }

    public ListNode reverseList(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;
        ListNode nextPtr = null;
        while (curr != null) {
            nextPtr = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextPtr;
        }
        return prev;
    }
}

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

class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;

        while(curr != null){
            //Save the next
            ListNode next = curr.next;
            //Flip the pointer
            curr.next = prev;
            // update the prev one step forward
            prev = curr;
            //update the curr one step forward
            curr = next;
        }
        return prev;
    }
}

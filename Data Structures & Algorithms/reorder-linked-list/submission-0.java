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
    public void reorderList(ListNode head) {
        
        // find middle
        ListNode sp = head;
        ListNode fp = head;

        while(fp!=null && fp.next!=null){
            sp = sp.next;
            fp = fp.next.next;
        }

        
        ListNode prev = null;
        ListNode curr = sp.next;
        sp.next = null;
        // reverse the second half
        while(curr!=null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        // merge
        ListNode first = head;
        ListNode second = prev;

        while(second != null){

            ListNode tmp1 = first.next;
            ListNode tmp2 = second.next;

            first.next = second;
            second.next = tmp1;

            first = tmp1;
            second = tmp2;

        }

    }
}

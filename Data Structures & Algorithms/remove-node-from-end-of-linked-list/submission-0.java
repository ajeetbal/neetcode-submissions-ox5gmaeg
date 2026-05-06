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
    public ListNode removeNthFromEnd(ListNode head, int n) {
       
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode sp = dummy;
        ListNode fp = dummy;
        
        for(int i = 0; i<=n ; i++){
            fp = fp.next;
        }

        while(fp!=null){
            fp = fp.next;
            sp = sp.next;
        }

        sp.next=sp.next.next;

        return dummy.next;
    }
}

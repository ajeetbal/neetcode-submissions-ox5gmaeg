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
    public boolean hasCycle(ListNode head) {
       if (head == null) return false;

       ListNode sp = head;
        ListNode fp = head;
        
        // Move fast by 2 and slow by 1
        while(fp!=null && fp.next!=null){
            sp = sp.next;
            fp = fp.next.next;

        // If they meet, there is a cycle
            if(sp == fp){
                return true;
            }
        }

        return false;

    }
}

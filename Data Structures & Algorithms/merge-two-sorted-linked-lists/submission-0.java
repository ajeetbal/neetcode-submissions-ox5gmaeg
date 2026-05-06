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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;
        
        ListNode head = null;
        ListNode curr = null;

        while (list1 != null && list2 != null) {
            int value = 0;
            if (list1.val < list2.val) {
                value = list1.val;
                list1 = list1.next;
            } else {
                value = list2.val;
                list2 = list2.next;
            }

            if (head == null) {
                head = new ListNode(value);
                curr = head;
            } else {
                curr.next = new ListNode(value);
                curr = curr.next;
            }
        }

        if (list1 != null) {
            curr.next = list1;
        }
        if (list2 != null) {
            curr.next = list2;
        }
        return head;
    }
}
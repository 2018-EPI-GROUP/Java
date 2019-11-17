/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode tmp = dummy;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            int l1Val = l1 == null ? 0 : l1.val;
            l1 = l1 == null ? null : l1.next;
            int l2Val = l2 == null ? 0 : l2.val;
            l2 = l2 == null ? null : l2.next;
            int val = l1Val + l2Val + carry;
            carry = val / 10;
            val = val % 10;
            tmp.next = new ListNode(val);
            tmp = tmp.next; 
        }
        
        return dummy.next;
    }
    
}
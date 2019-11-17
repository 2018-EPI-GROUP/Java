/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    
    public ListNode swapPairs(ListNode head) {
        if (head == null) {
            return null;
        }
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode tmp = dummy;
        while (tmp.next != null && tmp.next.next != null) {
            ListNode odd = tmp.next;
            ListNode even = tmp.next.next;
            tmp.next = even;
            odd.next = even.next;
            even.next = odd;
            tmp = odd;
        }
        
        return dummy.next;
    }
    
}
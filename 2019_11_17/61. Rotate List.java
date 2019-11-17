/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        
        int listSize = getListSize(head);
        k = k % listSize;
        for (int i = 0; i < k; i++) {
            ListNode tailPre = head;
            ListNode tail = head.next;
            while (tail != null && tail.next != null) {
                tailPre = tail;
                tail = tail.next;
            }
            tailPre.next = null;
            tail.next = head;
            head = tail;
        }
        
        return head;
    }
    
    public int getListSize(ListNode head) {
        if (head == null) {
            return 0;
        }
        
        int listSize = 0;
        while (head != null) {
            listSize++;
            head = head.next;
        }
        
        return listSize;
    }
    
}
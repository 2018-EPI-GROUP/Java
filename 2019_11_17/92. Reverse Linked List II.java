/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
 /*
	虚拟头节点
	找到位置m的前一个节点为前驱节点
	找到位置n的后一个节点为后继节点
	反转链表（见206. Reverse Linked List）
	让前驱节点的下一个节点为链表反转部分反转后的头节点
 */
class Solution {
    
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || m == n) {
            return head;
        }
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        while (--m > 0) {
            pre = pre.next;
        }
        head = pre.next;
        ListNode suc = dummy;
        while (n-- >= 0) {
            suc = suc.next;
        }
        
        ListNode node1 = null;
        ListNode node2 = suc;
        while (head != suc) {
            node1 = head.next;
            head.next = node2;
            node2 = head;
            head = node1;
        }
        pre.next = node2;
        
        return dummy.next;
    }
    
}

/*
	1->2->3->4->5->null(m = 2, n = 4)
	1->3->2->4->5->null
	1->4->3->2->5->null
*/
class Solution {
    
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || m == n) {
            return head;
        }
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        for (int i = 0; i < m - 1; i++) {
            pre = pre.next;
        }
        head = pre.next;
        for (int i = m; i < n; i++) {
            ListNode next = head.next;
            head.next = next.next;
            next.next = pre.next;
            pre.next = next;
        }
        
        return dummy.next;
    }
    
}
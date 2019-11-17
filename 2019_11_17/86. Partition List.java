/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) {
            return head;    
        }
        
        ListNode dummy = new ListNode(0); // 虚拟头节点
        dummy.next = head;
        ListNode smaller = dummy; // 值小于x的最后一个节点
        while (smaller.next != null && smaller.next.val < x) { // 处理链表头部分值小于x的节点
            smaller = smaller.next;
        }
        ListNode tmp = smaller;
        while (tmp != null && tmp.next != null) { // 处理smaller后的节点
            if (tmp.next.val >= x) { // 如果节点的值大于等于x 继续遍历后边的节点
                tmp = tmp.next;
                continue;
            }
            ListNode next = tmp.next; // 如果节点的值小于x就把该节点插到smaller后 继续遍历后边的节点
            tmp.next = next.next;
            next.next = smaller.next;
            smaller.next = next;
            smaller = smaller.next;
        }
        
        return dummy.next;
    }
    
}

/*
	将链表分成两个链表
	一个存值小于x的节点
	另一个存值大于x的节点
	最后首尾相接
*/
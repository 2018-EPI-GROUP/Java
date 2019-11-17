/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
 /*
	快慢指针法
	都从头节点开始
	快指针每次向后移动两个节点
	慢指针每次向后移动一个节点
	当快指针指向的节点为空或快指针指向节点的下一个节点为空时
	慢指针指向的节点就为链表的中间节点
 */
class Solution {
    
    public ListNode middleNode(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        return slow;
    }
    
}
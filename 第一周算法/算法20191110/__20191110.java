package EPI任务.算法20191110;
/**
 * 反转一个单链表。
 * 示例:
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 * MiseryG
 */

public class __20191110 {
}
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode l1=null;
        ListNode l2=null;
        ListNode l3=null;
        while(head!=null){
            l1=head.next;
            head.next=l2;
            l2=head;
            head=l1;
        }
        return l2;
    }
}
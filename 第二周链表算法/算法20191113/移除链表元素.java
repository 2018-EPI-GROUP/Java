package EPI任务.算法20191113;

/**
 * 删除链表中等于给定值 val 的所有节点。
 * 示例:
 * 输入: 1->2->6->3->4->5->6, val = 6
 * 输出: 1->2->3->4->5
 * MiseryG
 */
public class 移除链表元素 {
}
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution3 {
    public ListNode removeElements(ListNode head, int val) {
        ListNode l1=head;
        while(head!=null){
            if(head.val==val) {
                if(head.next!=null){
                    head=head.next;
                    l1=head;
                }else return null;
            }
            if(head.val!=val){
                while(head.next!=null){
                    if(head.next.val==val){
                        head.next=head.next.next;
                    }else
                        head=head.next;
                }
                return l1;
            }
        }
        return null;
    }
}
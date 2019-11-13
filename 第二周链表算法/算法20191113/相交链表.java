package EPI任务.算法20191113;
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

public class 相交链表 {
}

class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode a=headA;
        ListNode b=headB;
        if (headA == null || headB == null)
            return null;
        while(a!=b){
            if(a==null)
                a=headA;
            else
                a=a.next;
            if(b==null)
                b=headB;
            else
                b=b.next;
        }
        return a;
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode(int x){
          val = x;
          next = null;
      }
 }
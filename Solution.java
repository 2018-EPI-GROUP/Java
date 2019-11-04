package Demo02;

public class Solution {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {val = x; }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //每次从俩个链表中各取一个数字，知道俩个链表都到末尾
        ListNode head = new ListNode(0);//定义一个不带数据的头结点，省去了待会判断是不是第一个结点的操作
        ListNode r = head;   //始终指向末尾结点，尾插法

        int z = 0;
        while(l1 != null || l2 != null || z != 0){

            int res1 = l1 == null ? 0:l1.val;
            int res2 = l2 == null ? 0:l2.val;

            ListNode sumNode = new ListNode((res1+res2 + z)%10);
            r.next = sumNode;
            r = sumNode;

            z = (res1 + res2 + z)/10;
            if(l1 != null){
                l1 = l1.next;
            }
            if(l2 != null){
                l2 = l2.next;
            }
        }
        return head.next;
    }
}
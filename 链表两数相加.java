package EPI任务;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class 链表两数相加 {
    public static void main(String[] args) {
        ListNode a=new ListNode(3);
        ListNode b=new ListNode(0);
        ListNode c;
        a.next=new ListNode(7);
        a.next.next=new ListNode(4);
        b.next=new ListNode(8);
        b.next.next=new ListNode(1);
        Solutio s=new Solutio();
        c=s.addTwoNumbers(a,b);
        while (c!=null){
            System.out.print(c.val+"  ");
            c=c.next;
        }

    }
}

class Solutio {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode p = l1;
        ListNode q = l2;
        ListNode xxx = new ListNode(0);
        ListNode head = xxx;
        int sum = 0;
        int more = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            sum = more + x + y;
            more = sum / 10;
            xxx.next = new ListNode(sum % 10);
            xxx = xxx.next;
            if (p != null)
                p = p.next;
            if (q != null)
                q = q.next;
        }
        if (more == 1)
            xxx.next = new ListNode(more);
        return head.next;
    }
}
class ListNode {
    int val;
    ListNode next;
    public ListNode(int x) {
        val = x;
    }
}

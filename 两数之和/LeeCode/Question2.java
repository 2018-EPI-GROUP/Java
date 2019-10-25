//给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
//
//        如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
//
//        您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode-cn.com/problems/add-two-numbers
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
package LeeCode;
import LeeCode.LinkNode.LinkNode;

public class Question2
{
        public static LinkNode twoNumberSum(LinkNode l1, LinkNode l2)
        {
            int carry = 0;
            int i = 1;
            int count = 0;
            int num1 = 0;
            int num2 = 0;
            LinkNode resute = new LinkNode();
            while(l1.getLength() >= i || l2.getLength() >= i || carry == 1)
            {
                num1 = (l1.getLength() >= i)? l1.getData(i): 0;
                num2 = (l2.getLength() >= i)? l2.getData(i): 0;
                count = num1 + num2 + carry;
                carry = (count >= 10)? 1: 0;
                resute.addNode(count % 10);
                i++;
            }
            return resute;
        }
}

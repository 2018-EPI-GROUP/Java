/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 /*
	将链表每个节点的值存入整型数组
	递归建立二叉搜索树
 */
class Solution {
    
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        
        List<Integer> list = new LinkedList<Integer>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }

        return sortedListToBST(list.toArray(new Integer[list.size()]), 0, list.size() - 1);
    }
    
    public TreeNode sortedListToBST(Integer[] sortedArray, int l, int r) {
        if (l > r) {
            return null;
        }
        
        int mid = l + (r - l + 1) / 2;
        TreeNode root = new TreeNode(sortedArray[mid]);
        root.left = sortedListToBST(sortedArray, l, mid - 1);
        root.right = sortedListToBST(sortedArray, mid + 1, r);
        
        return root;
    }
    
}
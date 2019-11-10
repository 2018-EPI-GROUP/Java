/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution { // 从下到上 将节点的左子树变为右子树 将右子树变为左子树最右节点的右子树
    
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }    
        
        flatten(root.left);
        flatten(root.right);
        TreeNode tmp = root.right;
        root.right = root.left;
        root.left = null;
        while (root.right != null) {
            root = root.right;
        }
        root.right = tmp;
    }
    
}

class Solution { // 从上到下 将根节点的左子树变为右子树 将右子树变为左子树最右节点的右子树 根节点向右移动重复该过程
    
    public void flatten(TreeNode root) {
        while (root != null) {
            if (root.left == null) {
                root = root.right;
            } else {
                TreeNode left = root.left;
                while (left.right != null) {
                    left = left.right;
                }
                left.right = root.right;
                root.right = root.left;
                root.left = null;
                root = root.right;
            }
        }
    }
    
}

class Solution { // 二叉树展开为链表 链表中节点的顺序为二叉树先序遍历的结果 考虑用先序遍历 遍历时让前一个节点的右子树为后一个节点 左子树为空
    
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }    
        
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        TreeNode tmp1 = null;
        while (!stack.empty()) {
            TreeNode tmp2 = stack.pop();
            if (tmp1 != null) {
                tmp1.right = tmp2;
                tmp1.left = null;
            }
            if (tmp2.right != null) {
                stack.push(tmp2.right);
            }
            if (tmp2.left != null) {
                stack.push(tmp2.left);
            }
            tmp1 = tmp2;
        }
    }
    
}
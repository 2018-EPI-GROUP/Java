/*
	需要参考654. 最大二叉树
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
class Solution {
    
    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        TreeNode add = new TreeNode(val);
        if (root == null) {
            return add;
        }
        
        if (val > root.val) { // 如果附加值大于根节点的值
            add.left = root; // 让原来根节点为附加节点的左子树
            root = add; // 附加节点为根节点
        } else if (val < root.val) { // 如果附加值小于根节点的值（节点不含重复值不存在附加值等于根节点的值的情况）
            TreeNode tmp1 = null; // 存储刚刚比附加值小的节点
            TreeNode tmp2 = root; // 存储tmp1的右子树
            while (tmp2 != null && val < tmp2.val) { // 寻找插入附加节点的合适位置
                tmp1 = tmp2; // 附加值在数组的最右边 tmp1和tmp2每次向有移动
                tmp2 = tmp2.right;
            }
            tmp1.right = add; // 附加值在数组的最右边 附加节点应为值刚刚比附加值小的节点的右子树
            if (tmp2 != null) { // 附加值在数组的最右边 如果附加节点还有子树 一定是左子树
                add.left = tmp2;
            }
        }
        
        return root;
    }
    
}
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
    
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return constructMaximumBinaryTree2(nums, 0, nums.length - 1);
    }
    
    public TreeNode constructMaximumBinaryTree2(int[] nums, int l, int r) {
        if (l > r) {
            return null;
        }
        
        int maxNumIndex = getMaxNumIndex(nums, l, r);
        TreeNode root = new TreeNode(nums[maxNumIndex]);
        root.left = constructMaximumBinaryTree2(nums, l, maxNumIndex - 1);
        root.right = constructMaximumBinaryTree2(nums, maxNumIndex + 1, r);
        
        return root;
    }
    
    public int getMaxNumIndex(int[] nums, int l, int r) {
        int maxNumIndex = l;
        for (int i = l + 1; i <= r; i++) {
            if (nums[maxNumIndex] < nums[i]) {
                maxNumIndex = i;
            }
        }
        
        return maxNumIndex;
    }
    
}
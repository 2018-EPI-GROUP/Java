/*
	动态转移方程dp[n] = dp[0] * dp[n - 1] + dp[1] + dp[n - 2] + ... + dp[n - 2] * dp[1] + dp[n - 1] * dp[0]
	当根节点左边有0个节点右边有n - 1个节点时 组成dp[0] * dp[n - 1]种二叉搜索树
	当根节点左边有1个节点右边有n - 2个节点时 组成dp[1] * dp[n - 2]种二叉搜索树
	...
	当根节点左边有n - 2个节点右边有1个节点时 组成dp[n - 2] * dp[1]种二叉搜索树
	当根节点左边有n - 1个节点右边有0个节点时 组成dp[n - 1] * dp[0]种二叉搜索树
	相加即为n个节点组成的二叉搜索树的种数
*/
class Solution {
    
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1; // 0个节点可以组成1种二叉搜索树
        for (int i = 1; i < n + 1; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j] * dp[i - j - 1];
            }
        }
        
        return dp[n];
    }
    
}
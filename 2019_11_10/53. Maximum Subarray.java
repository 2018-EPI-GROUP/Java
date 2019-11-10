class Solution {
    
    public int maxSubArray(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]); // 计算出以位置i的元素结尾的连续子数组的最大和
        }
        
        int max = dp[0];
        for (int i = 1; i < nums.length; i++) {
            if (max < dp[i]) {
                max = dp[i]; // 找到以每个位置的元素结尾的连续子数组的最大和中的最大值
            }
        }
        
        return max;
    }
    
}

class Solution {
	
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int sum = 0;
        for (int num : nums) {
			sum = sum > 0 ? sum + num : num;
            max = Math.max(max, sum);
        }
		
        return res;
    }
	
}
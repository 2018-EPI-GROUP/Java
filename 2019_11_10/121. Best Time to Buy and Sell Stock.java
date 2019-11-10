class Solution {
    
    public int maxProfit(int[] prices) {
        if (prices.length == 0 || prices.length == 1) { // 想获取利润 股票至少有两天的价格
            return 0;
        }
        
        int minPrice = prices[0];
        int maxProfi = 0;
        for (int i = 1; i < prices.length; i++) { // 遍历股票价格数组的过程中 不断更新股票的最低价格和获取的最大利润
            maxProfi = Math.max(maxProfi, prices[i] - minPrice);
            minPrice = Math.min(minPrice, prices[i]);
        }
        
        return maxProfi;
    }
    
}
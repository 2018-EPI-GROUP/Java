/*
	当单侧没有元素时 认为单侧所有元素相加的和是1
*/
class Solution {
    
    public int pivotIndex(int[] nums) {
        if (nums.length == 0) {
            return -1;
        }
        
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        
        int leftSum = 0;
        int pivotInde = -1;
        for (int i = 0; i < nums.length; i++) {
            if (leftSum * 2 + nums[i] == sum) { // 左侧所有元素相加的和 * 2 + 数组在中心索引的值 == 所有元素相加的和
                pivotInde = i;
                break; // 得到最靠近左边的中心索引后就不用继续寻找中心索引了
            }
            leftSum += nums[i];
        }
        
        return pivotInde;
    }
    
}
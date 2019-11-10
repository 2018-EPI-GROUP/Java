/*
	位运算抑或 1 ^ 1 = 0  1 ^ 0 = 1  0 ^ 1 = 1  0 ^ 0 = 1
*/
class Solution {
    
    public int singleNumber(int[] nums) {
        int singleNumber = 0;
        for (int i = 0; i < nums.length; i++) {
            singleNumber ^= nums[i]; // 出现两次的数字互相抑或的结果为0 0和0抑或的结果为0 singleNumber最后的值为只出现一次的数字和0抑或 结果为只出现一次的数字
        }  
        
        return singleNumber;
    }
    
}
package cn.edu.xiyou.arrTest;

public class Search {
    public static void main(String[] args) {
        int[] arr = {4,8,6,5,7,52};
        int target=10;
        int[] twoSum = twoSum(arr, target);
        for (int i : twoSum) {
            System.out.println(i);
        }
    }
    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if(nums[i]+nums[j]==target){
                    result[0]=i;
                    result[1]=j;
                }
            }
        }
        return result;
    }
}

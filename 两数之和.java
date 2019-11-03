package EPI任务;

import java.util.Arrays;

public class 两数之和 {
    public static void main(String[] args) {
        int[] in={2,7,9};
        int tar=16;
        Solution ss=new Solution();
        System.out.println(Arrays.toString(ss.twoSum(in,tar)));
    }
}
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] a = {0, 0};
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    a[0] = i;
                    a[1] = j;
                    return a;
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

}
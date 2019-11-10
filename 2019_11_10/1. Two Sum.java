class Solution {
    
    public int[] twoSum(int[] nums, int target) {
        int[] arr = new int[2];
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    arr[0] = i;
                    arr[1] = j;
                    break;
                }
            }
        }
        
        return arr;
    }
    
}

class Solution {
    
    public int[] twoSum(int[] nums, int target) {
        int[] arr = new int[2];
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(target - nums[i], i);
            } else {
                arr[0] = map.get(nums[i]);
                arr[1] = i;
            }
        }
        
        return arr;
    }
    
}
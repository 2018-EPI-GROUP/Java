此方法比较容易想到，但运行时间长，为nums 的平方
class Solution {
    public int[] twoSum(int[] nums, int target) {
        for(int i = 0;i<nums.length;i++){
            for(int j = 0;i< nums.length;j++){
                if(nums[j] == target - nums[i]){
                    return new int[]{i,j};
                }
            }
        }
      return null;
    }
    }


利用哈希表来进行查找，

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i<nums.length;i++){
            int tmp = target - nums[i];
            if(map.containsKey(tmp)){
                return new int[]{map.get(tmp),i};   //存在即返回
            }
            map.put(nums[i],i);  //不存在，则加入
        }
        return nill;
    }
}
map集合的使用
建立map 集合：
如：
Map<String ,String> map = new HashMap<>();
添加内容map.put("黄晓明"，"杨颖")；
	map.put("文章，"马伊利")；
集合的取出  : 
//先获取map 集合的所有键的Set集合，keySet();
//有了Set集合可以获取其迭代器
Iterator  <String> it = KeySet.iterator();


while(it.hasnext){
	String key =  it.next();

	String value  = map.get(key);
	System.out.println("key"+  key  +"value" + value);
}  

对于map.containsKey方法的了解
map.containsKey就是用于判断map集合对象中是否包含指定的键名
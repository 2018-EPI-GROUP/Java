给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
示例 1:
输入: 123
输出: 321

class Solution {
    public int reverse(int x) {
        long rst=0;
        while(x!=0){
            rst= rst*10+ x%10;
            x=x/10;
           
        }
        if((int)rst!=rst){
            return 0;
            
        }else{
            return (int)rst;
        }        
    }
}
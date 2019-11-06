import java.util.Scanner;

public class Solution {
    static boolean flag=true;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (flag){
            boolean flag2=true;
            System.out.println("请输入一段字符串，我将会返给您一段最长回文子串...");
            String s = sc.nextLine();
            System.out.println(longestPalindrome(s));
            System.out.println("是否继续测试？请输入 y or n");
            while (flag2){
                String s1 = sc.nextLine();
                if(s1.equals("n")||s1.equals("N")){
                    flag=false;
                    flag2=false;
                }else if(s1.equals("y")||s1.equals("Y")){
                    flag2=false;
                }else {
                    System.out.println("输入格式不对，请重新输入 y or n");
                }
            }
        }
    }
    public static String longestPalindrome(String s) {
        //解决空串问题
        String result="";
        //长度由大及小，可以在第一次就找到最长回文子串
        for (int i = s.length(); i > 0; i--) {
            //若该字串没有回文子串，则返回第一个字母
            if(i==1){
                result=s.substring(0,1);
                break;
            }
            //循环改变最长回文字串的起始位置，循环次数=字符串长度-最长回文字串的长度
            for (int j = 0; j <= s.length()-i; j++) {
                //循环比较 字符串以中心对称的字母是否相同 循环次数=字符串长度/2
                for (int k = 0; k < i/2; k++) {
                    //判断以中心对称的字母是否相同
                    Boolean flag = s.substring(j+k, j+k+1).equals(s.substring((i-1)+j-k, i+j-k));
                    //如果相同，结束这次循环
                    if(!flag){
                        break;
                    }
                    //如果索引到了字符串的中间索引，则说明这个字符串以中心对称的字母全部相同
                    if(k==(i-2)/2){
                        //进到这个判断语句则说明这个字符串就是我们想要的结果了
                        result=s.substring(j,j+i);
                    }
                }
            }
            //若进到下面的判断语句则说明：这个字符串是空串，结束循环并直接return空串
            if(!(result.equals(""))){
                break;
            }
        }
        //暴力枚举过后，返回得到的结果
        return result;
    }
}
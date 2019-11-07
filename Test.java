import java.util.Scanner;

public class Test {
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
        String result = "";
        int len = s.length();
        //模拟一个二维的表，第一个[]内的数字是字符串的起始索引，第二个[]内的数字是字符串的终止索引，
        //指的是从起始索引到终止索引的字符串是否回文，若回文则将默认值false改为true
        boolean[][] flags = new boolean[len][len];
        for (int i = len - 1; i >= 0; i--) {
            for (int j = i; j < len; j++) {
                //如果s的第 i 个字符和第 j 个字符不同的话，f[i][j] 不是回文串，就不用进到判断语句改二维数组的值
                if(s.charAt(i) == s.charAt(j) && (j - i <= 1 || flags[i + 1][j - 1])) {
                    //若进到这个判断语句，则从i索引开始，j索引结束的字符串必回文，改它对应二维数组那一项的值
                    flags[i][j] = true;
                    //如果这个回文字符串的长度大于此前回文字符串的长度，则覆盖此前的result值
                    if(j - i >= result.length()){
                        result = s.substring(i, j + 1);
                    }
                }
            }
        }
        //返回结果
        return result;
    }
}

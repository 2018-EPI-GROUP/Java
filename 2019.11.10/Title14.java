package course;

import java.util.Scanner;
/*

14:一个5位数，判断它是不是回文数。即12321是回文数，个位与万位相同，十位与千位相同
 */
public class Title14 {
    public static void main(String [] args) {
        System.out.printf("请输入一个数：");
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        String str = String.valueOf(n);
        StringBuffer sb = new StringBuffer(str);
        int n1 = Integer.valueOf(sb.reverse().toString());
        if (n == n1) {
            System.out.println("该数字是回文字");
        } else {
            System.out.println("该数字不是回文字");
        }
    }
}

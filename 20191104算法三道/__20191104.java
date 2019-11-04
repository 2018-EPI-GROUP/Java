package EPI任务;

import java.util.Scanner;

/**
 * 求“相反数”问题
 * 为了得到一个数的"相反数",我们将这个数的数字顺序颠倒,然后再加上原先的数得到"相反数"。例如,为了得到1325的"相反数",首先我们将该数的数字顺序颠倒,我们得到5231,之后再加上原先的数,我们得到5231+1325=6556.如果颠倒之后的数字有前缀零,前缀零将会被忽略。例如n = 100, 颠倒之后是1.
 * 输入描述: 输入包括一个整数n,(1 ≤ n ≤ 10^5)
 * 输出描述: 输出一个整数,表示n的相反数
 * 输入例子1: 1325
 * 输出例子1: 6556

 * 在 Java 中要将 String 类型转化为 int 类型时,
 * 需要使用 Integer 类中的 parseInt() 方法或者 valueOf() 方法进行转换.
 * 因为Integer.parseInt()的参数类型必须是字符串所以必须加上toString()
 */

public class __20191104 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String str=scanner.next();
        int a=Integer.parseInt(str);
        int b=Integer.parseInt(new StringBuilder(str).reverse().toString());
        System.out.println(a+b);
    }
}

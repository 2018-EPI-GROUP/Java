package course;

import java.util.Scanner;
/*
8:求s=a+aa+aaa+aaaa+aa...a的值，其中a是一个数字。例如2+22+222+2222+22222(此时共有5个数相加)，几个数相加有键盘控制。输出结果的形式如：2+22+222=246；

 */
public class Title08 {
    public static void main(String[] args)throws Exception {
        System.out.println("请输入a：");
        Scanner sc=new Scanner(System.in);
        int a = sc.nextInt();
        System.out.println("请输入加法次数：");
        int times=sc.nextInt();
        int result = 0;
        if (a == 0) {
            result = 0;
        } else if (a > 9 && a < 0) {
            System.out.println("add number must more than 0 and less than 10");
        } else {
            int begin = 0;
            for (int j = 0; j < times; j++) {
                begin = 10 * begin + 1;
                result += begin * a ;
            }
            System.out.printf("输出结果：%d",result);
        }
        sc.close();
    }
}

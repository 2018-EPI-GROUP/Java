package course;

import java.util.Scanner;
/*
6:输入两个正整数m和n，求其最大公约数和最小公倍数。

 */
public class Title06 {
    public static void main(String[] args) throws Exception{
        System.out.print("请输入正整数 m 的值：");
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        System.out.print("请输入正整数 n 的值：");
        Scanner scanner1 = new Scanner(System.in);
        int n = scanner1.nextInt();
        int a = division(m,n);
        int b = m*n/a;
        System.out.println(m+"和"+n+"的最大公约数为："+a+"，最小公倍数为："+b);
        scanner.close();
    }
    public static int division(int x,int y){
        int t;
        if(x<y){
            t=x;
            x=y;
            y=t;
        }
        while (y!=0){
            if(x==y){
                return 1;
            }else {
                int k = x % y;
                x=y;
                y=k;
            }
        }
        return x;
    }
}
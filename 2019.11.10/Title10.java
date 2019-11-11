package course;

import java.util.Scanner;
/*

10:输入三个整数x,y,z，请把这三个数由小到大输出。
 */
public class Title10 {
    public static void main(String[] args){
        int num1=0,num2=0,num3=0;
        Scanner sc=new Scanner(System.in);
        System.out.printf("请输入第一个数：");
        num1=sc.nextInt();
        System.out.printf("请输入第二个数：");
        num2=sc.nextInt();
        System.out.printf("请输入第三个数：");
        num3=sc.nextInt();
        int j;
        if(num1>num2){
            j=num2;
            num2=num1;
            num1=j;
        }
        if(num1>num3){
            j=num3;
            num3=num1;
            num1=j;
        }
        if(num2>num3){
            j=num3;
            num3=num2;
            num2=j;
        }
        System.out.printf("三个数从小到大的排序为:%d\t%d\t%d\t",num1,num2,num3);
    }
}

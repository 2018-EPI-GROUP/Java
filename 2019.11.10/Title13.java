package course;

import java.util.Scanner;
/*
13:给一个不多于5位的正整数，要求：一、求它是几位数，二、逆序打印出各位数字。
 */
public class Title13 {
    public static void main(String[] args) {
        System.out.printf("请输入：");
        Scanner sc=new Scanner(System.in);
        int num=sc.nextInt();
        System.out.printf("该数字有%d位",findNums(num));
        System.out.println();
        reservePrint(num);
    }

    public static int findNums(int num) {
        int sum = 0;
        if (num > 0 &&num<100000){
            if (num < 10) {
                return sum = 1;
            } else if (num < 100) {
                return sum = 2;
            } else if (num < 1000) {
                return sum = 3;
            } else if (num < 10000) {
                return sum = 4;
            } else {
                return sum = 5;
            }
        }
        else{
            System.out.println("不是正整数或超过5位！");
            return -1;
        }
    }

    public static void reservePrint(int num) {
        int sum = findNums(num);
        int n;
        System.out.printf("各个位上数字为：");
        for (int i = sum; i > 0; i--) {
            n=num%10;
            System.out.printf("%d\t",n);
            num=num/10;
        }
    }
}

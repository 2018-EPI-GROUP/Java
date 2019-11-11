package course;

import java.util.Scanner;
/*

5:利用条件运算符的嵌套来完成此题：学习成绩>=90分的同学用A表示，60-89分之间的用B表示，60分以下的用C表示。
 */
public class Title05{
    public static void main(String[] args)throws Exception{
        System.out.println("请输入成绩：");
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        grade(n);
        sc.close();
    }
    private static void grade(int n){
        if(n>100 || n<0)
            System.out.println("输入无效");
        else{
            String str = (n>=90)?"分，属于A等":((n>60)?"分，属于B等":"分，属于C等");
            System.out.println(n+str);
        }
    }
}

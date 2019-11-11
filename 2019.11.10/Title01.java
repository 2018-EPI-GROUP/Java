package course;

import java.util.Scanner;
/*1:古典问题：有一对兔子，从出生后第3个月起每个月都生一对兔子，小兔子长到第三个月后每个月又生一对兔子，假如兔子都不死，问每个月的兔子对数为多少？
程序分析：
兔子的规律为数列1,1,2,3,5,8,13,21....
*/
public class Title01 {
    public static void main(String[] args)throws Exception{
        Scanner s=new Scanner(System.in);
        System.out.println("请输入月份：");
        int month=s.nextInt();
        Tuzi tuzi=new Tuzi();
        System.out.printf("第%d个月的兔子对数为%d",month,tuzi.fib(month));
        s.close();
    }
}
class Tuzi{
    public int fib(int month){
        if(month==1||month==2)
            return 1;
        else
            return fib(month-1)+fib(month-2);
    }
}
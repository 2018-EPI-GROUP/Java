package EPI任务;

import java.util.Scanner;

/**
 * 获得特定数量硬币问题
 * 小易准备去魔法王国采购魔法神器,购买魔法神器需要使用魔法币,但是小易现在一枚魔法币都没有,但是小易有两台魔法机器可以通过投入x(x可以为0)个魔法币产生更多的魔法币。
 * 魔法机器1:如果投入x个魔法币,魔法机器会将其变为2x+1个魔法币
 * 魔法机器2:如果投入x个魔法币,魔法机器会将其变为2x+2个魔法币
 * 小易采购魔法神器总共需要n个魔法币,所以小易只能通过两台魔法机器产生恰好n个魔法币,小易需要你帮他设计一个投入方案使他最后恰好拥有n个魔法币。
 * 输入描述: 输入包括一行,包括一个正整数n(1 ≤ n ≤ 10^9),表示小易需要的魔法币数量。
 * 输出描述: 输出一个字符串,每个字符表示该次小易选取投入的魔法机器。其中只包含字符'1'和'2'。
 * 输入例子1: 10
 * 输出例子1: 122

 * next()和nextLine()的区别
 * 在Java中输入字符串有两种方法，就是next()和nextLine().两者的区别就是：
 * nextLine()的输入是碰到回车就终止输入，而next()方法是碰到空格，回车，Tab键都会被视为终止符。
 * 所以next()不会得到带空格的字符串，而nextLine()可以得到带空格的字符串。
 */

public class _20191104 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int a=scanner.nextInt();
        StringBuilder stringBuilder=new StringBuilder();
        while (a>0){
            if(a%2==0){
                stringBuilder.append(2);
                a=(a-2)/2;
            }
            if(a%2==1){
                stringBuilder.append(1);
                a=(a-1)/2;
            }
        }
        stringBuilder=stringBuilder.reverse();
        System.out.println(stringBuilder);
    }
}

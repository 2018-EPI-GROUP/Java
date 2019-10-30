package cn.edu.xiyou.demo2;

//递归实现汉诺塔游戏
public class myHanoi {
    public static void main(String[] args) {
        hanoi(4,"A柱","B柱","C柱");
    }

    /**
     *
     * @param n 汉诺塔游戏的环数（总共有多少个环）
     * @param from 起始位置（A柱）
     * @param in 中间位置（B柱）
     * @param to 目标位置（C柱）
     */

    //自己根据网上的汉诺塔游戏就能理解该方法的作用0]y
    private static void hanoi(int n, String from, String in, String to) {
        //只有一个环的情况
        if(n==1){
            System.out.println("第1个盘子从"+from+"移到"+to);
        //大于一个环时的情况
        }else {
            //递归调用方法，将最底层环以上的环由起始位置（A柱）全部移到中间位置（B柱），以便把最底层环移到目标位置（C柱）
            hanoi(n-1,from,to,in);
            //将最底层的环移到目标位置（C柱）
            System.out.println("第"+n+"个盘子从"+from+"移到"+to);
            //递归调用方法，将最底层环以上的环从中间位置（B柱）又移到目标位置（C柱）
            hanoi(n-1,in,from,to);
        }
    }
    //可以跟着执行结果一步一步完成游戏，你可以发现没有任何毛病，哈哈
}

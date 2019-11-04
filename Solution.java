package Demo02;

import static java.lang.Math.abs;

//给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
public class Solution {
    public static int reverse(int x){
        long end = 0;

        while(x != 0){
            int num = x % 10;
            x /= 10;
            end = end * 10 + num;
        }
        return (end<Integer.MIN_VALUE||end>Integer.MAX_VALUE)? 0:(int)end;
    }

    public static void main(String[] args) {
        System.out.println(reverse(1));
    }
}

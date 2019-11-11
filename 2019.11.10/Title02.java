package course;

import static java.lang.Math.sqrt;
/*
2:判断101-200之间有多少个素数，并输出所有素数。
程序分析：
素数是：只能被1或本身整除的数，如：3,5,7,11,131... 
判断素数的方法：用一个数分别去除2到sqrt(这个数)，
其实用这个数分别去除2到他本身少1的数也可以，但是运算时间增加了
如果能被整除，则表明此数不是素数，反之是素数。
 */
public class Title02 {
    public static void main(String[] args) {
        Sushu sushu=new Sushu();
        System.out.println("100到200的素数个数：");
        System.out.println(sushu.howmuch());
        System.out.println("100到200的素数：");
        sushu.print();
    }
}

class Sushu {
    public int howmuch(){
        boolean flag=false;
        int sum=0;
        for(int i=101;i<=200;i++){
            for(int j=2;j<=sqrt(i);j++){
                if(i%j==0) {
                    flag=false;
                    break;
                }
                else
                    flag=true;
            }
            if(flag==true){
                sum++;
            }
        }
        return sum;
    }
    public void print(){
        boolean flag=false;
        for(int i=101;i<=200;i++){
            for(int j=2;j<=sqrt(i);j++){
                if(i%j==0) {
                    flag=false;
                    break;
                }
                else
                    flag=true;
            }
            if(flag==true){
                System.out.printf("%d\t",i);
            }
        }
    }
}
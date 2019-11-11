package course;
/*

3:打印出所有的"水仙花数"，所谓"水仙花数"是指一个三位数，其各位数字立方和等于该数本身。
例如：153是一个"水仙花数"，因为153=1的三次方＋5的三次方＋3的三次方。

 */
public class Title03 {
    public static void main(String[] args) {
        ShuiXianHua shuixianhua=new ShuiXianHua();
        shuixianhua.print();
    }
}

class ShuiXianHua {
    void print() {
        int a, b, c;
        System.out.println("三位数中所有的水仙花数为：");
        for (int n = 100; n <= 999; n++) {
            a = n / 100;
            b = n % 100 / 10;
            c = n % 10;
            if (a * a * a + b * b * b + c * c * c == n) {
                System.out.printf("%d\t",n);
            }

        }
    }
}
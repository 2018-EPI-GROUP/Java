package course;
/*
9:一个数如果恰好等于它的因子之和，这个数就称为"完数"。例如6=1＋2＋3.编程找出1000以内的所有完数。

 */
public class Title09 {
    public static void main(String[] args) {
        WanShu ws=new WanShu();
        ws.print();
    }
}
class WanShu {
    public void print() {
        int s;
        System.out.printf("1000以内的所有完数为：");
        for (int i = 6; i <= 1000; i++) {
            s = 0;
            for (int j = 1; j < i; j++) {
                if (i % j == 0)
                    s += j;
            }
            if (i == s)
                System.out.printf("%d\t",i);
        }
    }
}
